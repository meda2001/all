from flask import Flask, render_template, redirect, url_for, session, flash
from flask_sqlalchemy import SQLAlchemy
from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField, RadioField
from wtforms.validators import DataRequired, Length

app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key'
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///site.db'
db = SQLAlchemy(app)

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(20), unique=True, nullable=False)
    password = db.Column(db.String(60), nullable=False)

class ExamQuestion(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    topic = db.Column(db.String(20), nullable=False)
    question = db.Column(db.String(200), nullable=False)
    option_a = db.Column(db.String(50), nullable=False)
    option_b = db.Column(db.String(50), nullable=False)
    option_c = db.Column(db.String(50), nullable=False)
    option_d = db.Column(db.String(50), nullable=False)
    correct_option = db.Column(db.String(1), nullable=False)

class RegistrationForm(FlaskForm):
    username = StringField('Username', validators=[DataRequired(), Length(min=2, max=20)])
    password = PasswordField('Password', validators=[DataRequired()])
    submit = SubmitField('Sign Up')

class LoginForm(FlaskForm):
    username = StringField('Username', validators=[DataRequired()])
    password = PasswordField('Password', validators=[DataRequired()])
    submit = SubmitField('Sign In')

class ExamForm(FlaskForm):
    answer = RadioField('Your Answer', choices=[('A', 'A'), ('B', 'B'), ('C', 'C'), ('D', 'D')], validators=[DataRequired()])
    next_question = SubmitField('Next Question')

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/signup', methods=['GET', 'POST'])
def signup():
    form = RegistrationForm()

    if form.validate_on_submit():
        hashed_password = form.password.data  # You should hash the password before storing it in production
        user = User(username=form.username.data, password=hashed_password)
        db.session.add(user)
        db.session.commit()
        flash('Your account has been created! You can now log in.', 'success')
        return redirect(url_for('login'))

    return render_template('signup.html', form=form)

@app.route('/login', methods=['GET', 'POST'])
def login():
    form = LoginForm()

    if form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data).first()

        if user and user.password == form.password.data:  # In production, use secure password hashing
            session['user_id'] = user.id
            flash('Login successful!', 'success')
            return redirect(url_for('exam'))

        else:
            flash('Login unsuccessful. Please check your username and password.', 'danger')

    return render_template('login.html', form=form)

@app.route('/logout')
def logout():
    session.pop('user_id', None)
    return redirect(url_for('home'))

@app.route('/exam', methods=['GET', 'POST'])
def exam():
    if 'user_id' not in session:
        flash('You need to log in first.', 'warning')
        return redirect(url_for('login'))

    if 'question_number' not in session:
        # Choose a random topic for the user
        session['topic'] = random.choice(['Mathematics', 'Science', 'History'])
        session['question_number'] = 0
        session['score'] = 0

    current_topic = session['topic']

    if current_topic not in ['Mathematics', 'Science', 'History']:
        # No questions available for the chosen topic
        flash('No questions available for the chosen topic.', 'danger')
        return redirect(url_for('exam_result'))

    current_question_number = session['question_number']
    current_question = ExamQuestion.query.filter_by(topic=current_topic).offset(current_question_number).first()

    form = ExamForm()

    if form.validate_on_submit():
        # Check the submitted answer and update the score
        user_answer = form.answer.data
        correct_answer = current_question.correct_option

        if user_answer == correct_answer:
            session['score'] += 1

        # Move to the next question
        session['question_number'] += 1

        if session['question_number'] < 3:  # Limiting to 3 questions for simplicity
            return redirect(url_for('exam'))
        else:
            return redirect(url_for('exam_result'))

    return render_template('exam.html', topic=current_topic, question=current_question, form=form)

@app.route('/exam/result')
def exam_result():
    if 'user_id' not in session:
        flash('You need to log in first.', 'warning')
        return redirect(url_for('login'))

    final_score = session.get('score', 0)
    # Clear session data after displaying the result
    session.pop('topic', None)
    session.pop('question_number', None)
    session.pop('score', None)

    return render_template('exam_result.html', final_score=final_score)

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
    app.run(debug=True)

