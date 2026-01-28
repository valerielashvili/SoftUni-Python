def rectangle(length, width):
    if not isinstance(length, int) or not isinstance(width, int):
        return 'Enter valid values!'

    length, width = int(length), int(width)

    def area(l, w):
        return l * w

    def perimeter(l, w):
        return 2 * (l + w)

    area = area(length, width)
    perimeter = perimeter(length, width)

    return f'Rectangle area: {area}\nRectangle perimeter: {perimeter}'


print(rectangle(2, 10))
print(rectangle('2', 10))
