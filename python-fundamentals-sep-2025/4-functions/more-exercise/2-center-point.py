import math

x_first = float(input())
y_first = float(input())
x_second = float(input())
y_second = float(input())

def closest_to_center(x1, y1, x2, y2):
    first_point = abs(x1) + abs(y1)
    second_point = abs(x2) + abs(y2)

    if first_point < second_point:
        return f"({math.floor(x1)}, {math.floor(y1)})"
    else:
        return f"({math.floor(x2)}, {math.floor(y2)})"

result = closest_to_center(x_first, y_first, x_second, y_second)
print(result)
