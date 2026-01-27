def get_santa_position(rows, field):
    r, c = next(
        ((r, c) for r in range(rows) for c in range(rows) if field[r][c] == 'S'),
        (None, None)
    )
    return r, c


def cnt_nice_kids(field):
    return sum(r.count('V') for r in field)


def move(cmd, r, c):
    dr, dc = DIRS[cmd]
    return r + dr, c + dc


def in_boundary(r, c, rows):
    return 0 <= r < rows and 0 <= c < rows


def update_matrix(r, c, next_r, next_c, field):
    field[r][c] = '-'
    field[next_r][next_c] = 'S'
    return field


def giveaway_cookies(cr, cc, field, n_gifts, glad_kids):
    for dr, dc in DIRS.values():
        next_r, next_c = cr + dr, cc + dc

        if not in_boundary(next_r, next_c, len(field)):
            continue

        if field[next_r][next_c] in ('V', 'X'):
            n_gifts -= 1
            if field[next_r][next_c] == 'V':
                glad_kids += 1
            field[next_r][next_c] = '-'

            if n_gifts == 0:
                break

    return field, n_gifts, glad_kids


DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}
n_presents = int(input())
size = int(input())
matrix = []
happy_kids = 0

for line in range(size):
    matrix.append([c for c in input().split()])

total_nice_kids = cnt_nice_kids(matrix)
row, col = get_santa_position(size, matrix)

while (command := input()) != 'Christmas morning':
    nr, nc = move(command, row, col)

    if in_boundary(nr, nc, size):
        # Nice kid case
        if matrix[nr][nc] == 'V':
            n_presents -= 1
            happy_kids += 1

        # Stepped on a cookie
        if matrix[nr][nc] == 'C':
            matrix, n_presents, happy_kids = giveaway_cookies(nr, nc, matrix, n_presents, happy_kids)

        matrix = update_matrix(row, col, nr, nc, matrix)
        row, col = nr, nc

    if n_presents == 0:
        break

num_nice_kids = cnt_nice_kids(matrix)

if n_presents == 0 and num_nice_kids > 0:
    print('Santa ran out of presents!')

for line in matrix:
    print(*line, sep=' ')

if happy_kids == total_nice_kids:
    print(f'Good job, Santa! {happy_kids} happy nice kid/s.')
else:
    print(f'No presents for {num_nice_kids} nice kid/s.')
