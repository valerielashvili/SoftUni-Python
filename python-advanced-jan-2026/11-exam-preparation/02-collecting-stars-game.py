def get_player_position(rows, field):
    r, c = next(
        ((r, c) for r in range(rows) for c in range(rows) if field[r][c] == 'P'),
        (None, None)
    )
    return r, c


def move(r, c, cmd, rows):
    dr, dc = DIRS[cmd]
    nr, nc = r + dr, c + dc

    if in_boundary(nr, nc, rows):
        return nr, nc
    else:
        return 0, 0


def in_boundary(r, c, rows):
    return 0 <= r < rows and 0 <= c < rows


def validate_move(r, c, nr, nc, stars, field):
    if field[nr][nc] == '#':
        stars -= 1
        field[r][c] = 'P'
        return r, c, stars, field
    elif field[nr][nc] == '*':
        stars += 1

    field[r][c] = '.'
    field[nr][nc] = 'P'
    return nr, nc, stars, field


DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

size = int(input())
matrix = []
stars_total = 2

for _ in range(size):
    matrix.append([x for x in input().split()])

row, col = get_player_position(size, matrix)

while stars_total != 10 and stars_total != 0:
    command = input()
    nxt_r, nxt_c = move(row, col, command, size)
    row, col, stars_total, matrix = validate_move(row, col, nxt_r, nxt_c, stars_total, matrix)

if stars_total == 10:
    print('You won! You have collected 10 stars.')
elif stars_total == 0:
    print('Game over! You are out of any stars.')

print(f'Your final position is [{row}, {col}]')

for line in matrix:
    print(' '.join(map(str, line)))
