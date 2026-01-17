rows, cols = [int(x) for x in input().split(', ')]
matrix = []

for row in range(rows):
    matrix.append([int(n) for n in input().split()])

for col in range(cols):
    col_sum = 0
    for row in range(rows):
        col_sum += matrix[row][col]
    print(col_sum)
