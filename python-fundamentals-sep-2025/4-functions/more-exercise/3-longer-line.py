from math import floor

x1 = float(input())
y1 = float(input())
x2 = float(input())
y2 = float(input())
x3 = float(input())
y3 = float(input())
x4 = float(input())
y4 = float(input())

def longer_line(a1, b1, a2, b2, a3, b3, a4, b4):
    # Squared lengths of the lines
    length1 = (a2 - a1) ** 2 + (b2 - b1) ** 2
    length2 = (a4 - a3) ** 2 + (b4 - b3) ** 2

    if length1 >= length2:
        # Line 1 is longer or equal
        dist1 = a1 ** 2 + b1 ** 2
        dist2 = a2 ** 2 + b2 ** 2

        if dist1 <= dist2:
            return f"({floor(a1)}, {floor(b1)})({floor(a2)}, {floor(b2)})"
        else:
            return f"({floor(a2)}, {floor(b2)})({floor(a1)}, {floor(b1)})"
    else:
        # Line 2 is longer
        dist3 = a3 ** 2 + b3 ** 2
        dist4 = a4 ** 2 + b4 ** 2

        if dist3 <= dist4:
            return f"({floor(a3)}, {floor(b3)})({floor(a4)}, {floor(b4)})"
        else:
            return f"({floor(a4)}, {floor(b4)})({floor(a3)}, {floor(b3)})"

result = longer_line(x1, y1, x2, y2, x3, y3, x4, y4)
print(result)
