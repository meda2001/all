num= 1000
count = 1
steps=0



for i in range(2,num+1):

    steps=steps+1

    if (num%i==0):
        count=count +1



print("count=",count, "steps=",steps)
if count==2:
    print("prime")
else:
    print("not prime")