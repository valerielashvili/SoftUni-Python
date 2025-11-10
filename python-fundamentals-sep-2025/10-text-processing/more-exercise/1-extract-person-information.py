def check_name(person_name: str) -> str | None:
    """Check if a string is person's name and return it."""
    start, end = 0, 0
    for j in range(0, len(person_name)):
        if person_name[j] == '@':
            start = j
        elif person_name[j] == '|':
            end = j
    if start >= 0 and end > 0:
        return person_name[start + 1: end]
    else:
        return None


def check_age(person_age: str) -> str | None:
    """Check if a string is person's age and return it."""
    start, end = 0, 0
    for j in range(0, len(person_age)):
        if person_age[j] == '#':
            start = j
        elif person_age[j] == '*':
            end = j
    if start >= 0 and end > 0:
        return person_age[start + 1: end]
    else:
        return None


n = int(input())

for i in range(n):
    strings = input().split()
    name, age = '', ''

    for string in strings:
        if not name:
            name = check_name(string)
        if not age:
            age = check_age(string)

    if name and age:
        print(f"{name} is {age} years old.")
