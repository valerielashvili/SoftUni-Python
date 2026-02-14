def classify_books(*args, **kwargs):
    fiction_books = {}
    non_fiction_books = {}

    for genre, title in args:
        if genre == 'fiction' and title not in fiction_books:

            for key in kwargs.keys():
                if kwargs[key] == title:
                    fiction_books[key] = title

        elif genre == 'non_fiction' and title not in non_fiction_books:
            for key in kwargs.keys():
                if kwargs[key] == title:
                    non_fiction_books[key] = title

    sorted_fiction = dict(sorted(fiction_books.items(), key=lambda b: b[0]))
    sorted_non_fiction = dict(sorted(non_fiction_books.items(), key=lambda b: b[0], reverse=True))

    output = ''
    if sorted_fiction:
        output += "Fiction Books:\n"
        for key, title in sorted_fiction.items():
            output += f"~~~{key}#{title}\n"

    if sorted_non_fiction:
        output += "Non-Fiction Books:\n"
        for key, title in sorted_non_fiction.items():
            output += f"***{key}#{title}\n"

    return output

print(classify_books(
    ("non_fiction", "The Art of War"),
    ("fiction", "The Great Gatsby"),
    ("non_fiction", "A Brief History of Time"),
    ("fiction", "Brave New World"),
    FF1234HH="The Great Gatsby",
    NF3845UU="A Brief History of Time",
    NF3421NN="The Art of War",
    FF1234UU="Brave New World"
))
