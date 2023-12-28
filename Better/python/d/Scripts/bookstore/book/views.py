from django.shortcuts import render
from .models import Book

from django.http import HttpResponse
# Create your views here.

def welcome(request):
    books = Book.objects.all()
    return render(request,"book/index.html",{'books': books})


def welcomePage(request):
    return render(request,"book/index.html")

def test(request):
    return HttpResponse("Hello curl")