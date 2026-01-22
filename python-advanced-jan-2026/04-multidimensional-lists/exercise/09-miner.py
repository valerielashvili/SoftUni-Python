import sys


def move(direction, mtrx_size, r, c):
    last_r, last_c = r, c
    if direction == 'up':
        r -= 1
    elif direction == 'down':
        r += 1
    elif direction == 'left':
        c -= 1
    elif direction == 'right':
        c += 1
    if 0 <= r < mtrx_size and 0 <= c < mtrx_size:
        return r, c
    else:
        return last_r, last_c

size = int(input())
commands = [
    c for c in input().split()
    if c == 'left' or c == 'right'
    or c == 'up' or c == 'down'
]
matrix = []
collected_coal = 0
game_over = False

for r in range(size):
    matrix.append([c for c in input().split()])

row, col = next(
    ((r, c) for r in range(size) for c in range(size) if matrix[r][c] == 's'),
    None
)

for cmd in commands:
    row, col = move(cmd, size, row, col)

    if matrix[row][col] == 'c':
        matrix[row][col] = '*'
    elif matrix[row][col] == 'e':
        print(f'Game over! ({row}, {col})')
        sys.exit()

coal = sum(col == 'c' for row in matrix for col in row)

if not coal:
    print(f'You collected all coal! ({row}, {col})')
else:
    print(f'{coal} pieces of coal left. ({row}, {col})')
