searched_book = input()
current_book = input()
book_count = 0
is_book_found = False

while current_book != "No More Books":
    if current_book == searched_book:
        is_book_found = True
        print(f"You checked {book_count} books and found it.")
        break

    book_count += 1
    current_book = input()

if not is_book_found:
    print(f'The book you search is not here!\n'
          f"You checked {book_count} books.")