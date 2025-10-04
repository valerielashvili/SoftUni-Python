from math import floor

x_first = float(input())
y_first = float(input())
x_second = float(input())
y_second = float(input())

def closest_to_center(x1, y1, x2, y2):
    first_point = x1 ** 2 + y1 ** 2
    second_point = x2 ** 2 + y2 ** 2

    if first_point <= second_point:
        return f"({floor(x1)}, {floor(y1)})"
    else:
        return f"({floor(x2)}, {floor(y2)})"

result = closest_to_center(x_first, y_first, x_second, y_second)
print(result)
