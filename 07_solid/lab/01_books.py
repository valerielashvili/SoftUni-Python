"""Single Responsibility Principle"""

class Book:
    def __init__(self, title, author):
        self.title = title
        self.author = author
        self.page = 0

    def turn_page(self, page):
        self.page = page

    def __repr__(self):
        return f"\"{self.title}\" by {self.author}"

class Library:
    def __init__(self, *args):
        self.books = list(args)

    def find_book(self, title: str):
        return next((b for b in self.books if b.title == title), "Book not found")

    def add_book(self, book: Book):
        self.books.append(book)

    def remove_book(self, book: Book):
        if book in self.books:
            self.books.remove(book)

    def __repr__(self):
        return f"Library of [{', '.join(map(str, self.books))}]"


# Test code
b1 = Book("Book1", "Book Worm1")
b2 = Book("Book2", "Book Worm2")
b3 = Book("Book3", "Book Worm3")

library = Library(b1, b2)
print(library)
print(library.find_book("Book1"))
