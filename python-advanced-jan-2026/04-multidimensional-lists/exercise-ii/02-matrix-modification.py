def in_boundary(row, col, rows):
    return 0 <= row < rows and 0 <= col < rows


size = int(input())
matrix = []

for r in range(size):
    matrix.append([int(n) for n in input().split()])

while (line := input()) != 'END':
    cmd, r, c, num = line.split()
    r, c, num = int(r), int(c), int(num)

    if in_boundary(r, c, size):
        if cmd == 'Add':
            matrix[r][c] += num
        elif cmd == 'Subtract':
            matrix[r][c] -= num
    else:
        print('Invalid coordinates')

for r in matrix:
    print(*r)
