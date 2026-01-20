def neighbors(x, y, rows, cols):
    for dr in (-1, 0, 1):
        for dc in (-1, 0, 1):
            nr, nc = x + dr, y + dc
            if 0 <= nr < rows and 0 <= nc < cols:
                yield nr, nc


size = int(input())
matrix = []

for row in range(size):
    matrix.append([int(n) for n in input().split()])

coordinates = [tuple(int(c) for c in pair.split(',')) for pair in input().split()]

for row, col in coordinates:
    if matrix[row][col] <= 0:
        continue

    damage = matrix[row][col]

    # detonate
    for r, c in neighbors(row, col, size, size):
        if matrix[r][c] > 0:
            matrix[r][c] -= damage

print(f"Alive cells: {sum(x > 0 for row in matrix for x in row)}")
print(f"Sum: {sum(x for row in matrix for x in row if x > 0)}")

for c in matrix:
    print(*c)
