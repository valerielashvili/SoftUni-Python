a = int(input())
b = int(input())

tmp_var = 0

print(f"Before: \na = {a} \nb = {b} ")

tmp = a
a = b
b = tmp

print(f"After: \na = {a} \nb = {b} ")