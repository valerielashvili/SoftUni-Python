rows = int(input())
matrix = []
coordinates = []

for row in range(rows):
    matrix.append([int(n) for n in input().split()])

coordinates.append([tuple(int(c) for c in pair.split(',')) for pair in input().split()])

for pair in coordinates[0]:
    row, col = pair
    damage = matrix[row][col]

    bombing_area = [
        (row, col),
        (row, col - 1),
        (row - 1, col - 1),
        (row - 1, col),
        (row - 1, col + 1),
        (row, col + 1),
        (row + 1, col + 1),
        (row + 1, col),
        (row + 1, col - 1)
    ]

    # detonate
    for r, c in bombing_area:
        if (0 <= r < rows) and (0 <= c < rows) and not matrix[r][c] <= 0:
            matrix[r][c] -= damage

print(f"Alive cells: {sum(x > 0 for row in matrix for x in row)}")
print(f"Sum: {sum(x for row in matrix for x in row if x > 0)}")

for c in matrix:
    print(*c)
