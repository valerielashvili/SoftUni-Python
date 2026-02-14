def get_position(field):
    r, c = next(
        ((r, c) for r in range(len(field)) for c in range(len(field[r])) if field[r][c] == 'P'),
        (None, None)
    )
    return r, c


def move(r, c, cmd):
    dr, dc = DIRS[cmd]
    nxt_r, nxt_c = r + dr, c + dc

    if nxt_r < 0:
        nxt_r = size - 1
    elif nxt_r > size - 1:
        nxt_r = 0

    if nxt_c < 0:
        nxt_c = size - 1
    elif nxt_c > size - 1:
        nxt_c = 0

    return nxt_r, nxt_c


def validate_move(r, c, nxt_r, nxt_c, health, stars, immunity, field):
    if field[nxt_r][nxt_c] == '-': # skip the move
        field[r][c] = '-'
        field[nxt_r][nxt_c] = 'P'
        pass

    elif field[nxt_r][nxt_c] == '*': # collect stars
        field[r][c] = '-'
        field[nxt_r][nxt_c] = 'P'
        stars -= 1

    elif field[nxt_r][nxt_c] == 'G': # hit a ghost
        if not immunity:
            health -= 50
        immunity = False
        field[r][c] = '-'
        field[nxt_r][nxt_c] = 'P'

    elif field[nxt_r][nxt_c] == 'F': # freeze
        immunity = True
        field[r][c] = '-'
        field[nxt_r][nxt_c] = 'P'

    return nxt_r, nxt_c, health, stars, immunity, field

DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

size = int(input())
matrix = []
p_health = 100
p_immunity = False

for _ in range(size):
    matrix.append(list(input()))

left_stars = sum(line.count('*') for line in matrix)
row, col = get_position(matrix)
matrix[row][col] = '-'

while (command := input()) != 'end':
    nr, nc = move(row, col, command)
    nr, nc, p_health, left_stars, p_immunity, matrix = validate_move(row, col, nr, nc, p_health, left_stars, p_immunity, matrix)

    if left_stars <= 0 or p_health <= 0:
        break

    row, col = nr, nc

row, col = get_position(matrix)
if p_health <= 0:
    print(f"Game over! Pacman last coordinates [{row},{col}]")
elif left_stars <= 0:
    print(f"Pacman wins! All the stars are collected.")
elif p_health > 0 and left_stars:
    print(f"Pacman failed to collect all the stars.")

print(f"Health: {p_health}")

if left_stars:
    print(f"Uncollected stars: {left_stars}")

for row in matrix:
    print(''.join(row))
