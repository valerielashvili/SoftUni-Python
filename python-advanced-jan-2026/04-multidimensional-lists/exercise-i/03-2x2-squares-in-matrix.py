rows, cols = [int(n) for n in input().split()]
matrix = []
square_matrices = []

for row in range(rows):
    matrix.append([c for c in input().split()])

for row in range(rows - 1):
    for col in range(cols - 1):
        square_matrices.append([
            matrix[row][col], matrix[row][col + 1],
            matrix[row + 1][col], matrix[row + 1][col + 1]
        ])

identical_cnt = sum(len(set(x)) == 1 for x in square_matrices)
print(identical_cnt)
