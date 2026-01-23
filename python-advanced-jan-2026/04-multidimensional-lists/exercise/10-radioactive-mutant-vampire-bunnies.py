def get_player_position(lines, cells, field):
    # get player's start position
    r, c = next(
        ((r, c) for r in range(lines) for c in range(cells) if field[r][c] == 'P'),
        (-1, -1)
    )
    return r, c


def move(direction, pr, pc):
    nr, nc = pr, pc
    if direction == 'U':
        nr -= 1
    elif direction == 'D':
        nr += 1
    elif direction == 'L':
        nc -= 1
    elif direction == 'R':
        nc += 1
    return nr, nc


def in_boundary(r, c, lines, cells):
    return 0 <= r < rows and 0 <= c < cols


def update_lair(field, lines, cells):
    # spread bunnies
    bunnies = [(r, c) for r in range(lines) for c in range(cells) if field[r][c] == 'B']

    for bunny in bunnies:
        r, c = bunny
        for dr in (-1, 1):
            nr = r + dr
            if in_boundary(nr, c, lines, cells):
                field[nr][c] = 'B'
        for dc in (-1, 1):
            nc = c + dc
            if in_boundary(r, nc, lines, cells):
                field[r][nc] = 'B'

    return field

rows, cols = [int(n) for n in input().split()]
lair = []
commands = []
p_row, p_col = None, None
last_r, last_c = None, None
win = None

for row in range(rows):
    lair.append([c for c in input()])

cmd_str = input()
for cmd in cmd_str:
    commands.append(cmd)

for cmd in commands:
    p_row, p_col = get_player_position(rows, cols, lair)

    if p_row >= 0 and p_col >= 0:
        last_r, last_c = p_row, p_col

    p_row, p_col = move(cmd, p_row, p_col)

    if in_boundary(p_row, p_col, rows, cols):
        if lair[p_row][p_col] == 'B':
            lair = update_lair(lair, rows, cols)
            last_r, last_c = p_row, p_col
            win = False
            break
        else:
            lair[last_r][last_c] = '.'
            lair[p_row][p_col] = 'P'
            last_r, last_c = p_row, p_col
    else:
        if lair[last_r][last_c] != 'B':
            lair[last_r][last_c] = '.'
            lair = update_lair(lair, rows, cols)
            win = True
            break
        else:
            win = False
            break

    lair = update_lair(lair, rows, cols)

for line in lair:
    print(*line, sep='')

if win:
    print(f"won: {last_r} {last_c}")
else:
    print(f"dead: {last_r} {last_c}")
