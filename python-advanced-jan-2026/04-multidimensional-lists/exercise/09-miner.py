def move(direction, mtrx_size, r, c):
    if direction == 'up':
        r -= 1
    elif direction == 'down':
        r += 1
    elif direction == 'left':
        c -= 1
    elif direction == 'right':
        c += 1
    if 0 <= r <= mtrx_size and 0 <= c <= mtrx_size:
        return r, c
    else:
        return False


size = int(input())
commands = [
    c for c in input().split()
    if c == 'left' or c == 'right'
    or c == 'up' or c == 'down'
]
matrix = []
collected_coal = 0
game_over = False

for row in range(size):
    matrix.append([c for c in input().split()])

current_pos = tuple((r, c) for r in range(size) for c in range(size) if matrix[r][c] == 's')
last_r, last_c = None, None

for cmd in commands:
    if not move(cmd, size, *current_pos):
        continue

    row, col = move(cmd, size, *current_pos)
    last_r, last_c = row, col


    if matrix[row][col] == 'c':
        collected_coal += 1
        matrix[row][col] = '*'
    elif 'c' not in matrix:
        print(f'You collected all coal! ({row}, {col})')
        game_over = True
        break
    elif matrix[row][col] == 'e':
        print(f'Game over! ({row}, {col})')
        game_over = True
        break

remaining_coal = sum(matrix[r][c] == 'c' for r in matrix for c in r)

if not game_over:
    print(f'{remaining_coal} pieces of coal left. ({last_r}, {last_c})')
