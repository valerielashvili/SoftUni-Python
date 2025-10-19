def add_book(shelf: list, book_name: str) -> list:
    book_name = tokens[1]
    if book_name not in shelf:
        shelf.insert(0, book_name)

    return shelf


def take_book(shelf: list, book_name: str) -> list:
    book_name = tokens[1]
    if book_name in shelf:
        shelf.remove(book_name)

    return shelf


def swap_books(shelf: list, book_1: str, book_2: str) -> list:
    if book_1 in shelf and book_2 in shelf:
        idx_1, idx_2 = shelf.index(book_1), shelf.index(book_2)
        shelf[idx_1], shelf[idx_2] = shelf[idx_2], shelf[idx_1]

    return shelf


def insert_book(shelf: list, book_name: str) -> list:
    if book_name not in book_shelf:
        book_shelf.append(book_name)

    return shelf


def check_book(shelf: list, idx: int) -> None:
    if 0 <= idx < len(shelf):
        print(shelf[idx])


book_shelf = input().split('&')
tokens = input().split(' | ')

while tokens[0] != 'Done':
    command = tokens[0]

    if command == 'Add Book':
        book_shelf = add_book(book_shelf, tokens[1])

    elif command == 'Take Book':
        book_shelf = take_book(book_shelf, tokens[1])

    elif command == 'Swap Books':
        book_shelf = swap_books(book_shelf, tokens[1], tokens[2])

    elif command == 'Insert Book':
        book_shelf = insert_book(book_shelf, tokens[1])

    elif command == 'Check Book':
        check_book(book_shelf, int(tokens[1]))

    tokens = input().split(' | ')

print(", ".join(book_shelf))
