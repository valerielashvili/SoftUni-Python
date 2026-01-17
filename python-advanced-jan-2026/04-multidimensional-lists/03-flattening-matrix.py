rows = int(input())
matrix = []

for row in range(rows):
    matrix.append([int(n) for n in input().split(', ')])

print([e for row in matrix for e in row])
