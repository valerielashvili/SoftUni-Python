rows, cols = [int(n) for n in input().split()]
matrix = []
max_square_mtrx = None
max_sum = float('-inf')

for row in range(rows):
    matrix.append([int(c) for c in input().split()])

for row in range(rows - 2):
    for col in range(cols - 2):
        current_mtrx = [
            [matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]],
            [matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]],
            [matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]]
        ]
        current_mtrx_sum = sum(num for row in current_mtrx for num in row)

        if current_mtrx_sum > max_sum:
            max_sum = current_mtrx_sum
            max_square_mtrx = current_mtrx

print(f"Sum = {max_sum}")
for row in max_square_mtrx:
    print(*row)
