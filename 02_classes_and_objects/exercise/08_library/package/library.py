from user import User

class Library:
    def __init__(self):
        self.user_records = [] # Users objects
        self.books_available = {} # {authors: [books]}
        self.rented_books = {} # {usernames: {book_names: days_left}}

    def get_book(self, author: str, book_name: str, days_to_return: int, user: User):
        if author in self.books_available.keys() and book_name in self.books_available[author]:
                self.books_available[author].remove(book_name)
                user.books.append(book_name)
                self.rented_books[author].update({book_name: days_to_return})
                return f"{book_name} successfully rented for the next {days_to_return} days!"
        else:
            rented_books = self.rented_books.values()
            rent_duration = next(days for name, days in rented_books if name == book_name)
            return f"The book \"{book_name}\" is already rented and will be available in {rent_duration} days!"
