import math
from math import pi

shape_type = input()
result = 0

if shape_type == 'square':
    square_side = float(input())
    result = square_side * square_side
elif shape_type == 'rectangle':
    rec_side_a = float(input())
    rec_side_b = float(input())
    result = rec_side_a * rec_side_b
elif shape_type == 'circle':
    radius = float(input())
    result = radius * radius * pi
elif shape_type == 'triangle':
    base = float(input())
    height = float(input())
    result = (base * height) / 2

print(round(result, 3))
