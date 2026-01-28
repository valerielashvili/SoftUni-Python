def even_odd(*numbers):
    character = numbers[-1]
    if character == 'even':
        return [n for n in numbers[:-1] if n % 2 == 0]
    elif character == 'odd':
        return [n for n in numbers[:-1] if n % 2 != 0]

    return None

print(even_odd(1, 2, 3, 4, 5, 6, "even"))
