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

for row in range(rows):
    lair.append([c for c in input()])

cmd_str = input()
for cmd in cmd_str:
    commands.append(cmd)

pr, pc = get_player_position(rows, cols, lair)
status = None

for cmd in commands:
    nr, nc = move(cmd, pr, pc)

    # Player escapes
    if not in_boundary(nr, nc, rows, cols):
        lair[pr][pc] = '.'
        lair = update_lair(lair, rows, cols)
        status = "won"
        break

    # Player moves into bunny
    if lair[nr][nc] == 'B':
        lair[pr][pc] = '.'
        lair = update_lair(lair, rows, cols)
        pr, pc = nr, nc
        status = "dead"
        break

    # Normal move
    lair[pr][pc] = '.'
    lair[nr][nc] = 'P'
    pr, pc = nr, nc

    # Bunnies spread
    lair = update_lair(lair, rows, cols)

    # Player dies after spread
    if lair[pr][pc] == 'B':
        status = "dead"
        break

for line in lair:
    print(*line, sep='')

print(f"{status}: {pr} {pc}")
