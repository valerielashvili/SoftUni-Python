rows, cols = [int(x) for x in input().split()]
matrix = [[] for _ in range(rows)]

for row in range(rows):
    i = 97 + row
    for j in range(i, i + cols):
        matrix[row].append(f"{chr(i)}{chr(j)}{chr(i)}")

for r in matrix:
    print(*r)
