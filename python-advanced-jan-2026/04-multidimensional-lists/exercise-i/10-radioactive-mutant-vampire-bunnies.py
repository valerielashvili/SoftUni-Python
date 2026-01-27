def get_player_position(lines, cells, field):
    # Get player's start position
    r, c = next(
        ((r, c) for r in range(lines) for c in range(cells) if field[r][c] == 'P'),
        (-1, -1)
    )
    return r, c


def move(cmd, r, c):
    dr, dc = DIRS[cmd]
    return r + dr, c + dc


def in_boundary(r, c, lines, cells):
    return 0 <= r < rows and 0 <= c < cols


def update_lair(lines, cells, field):
    # Spread bunnies
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


DIRS = {
    'U': (-1, 0),
    'D': (1, 0),
    'L': (0, -1),
    'R': (0, 1)
}
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
        lair = update_lair(rows, cols, lair)
        status = "won"
        break

    # Player moves into bunny
    if lair[nr][nc] == 'B':
        lair[pr][pc] = '.'
        lair = update_lair(rows, cols, lair)
        pr, pc = nr, nc
        status = "dead"
        break

    # Normal move
    lair[pr][pc] = '.'
    lair[nr][nc] = 'P'
    pr, pc = nr, nc

    # Bunnies spread
    lair = update_lair(rows, cols, lair)

    # Player dies after spread
    if lair[pr][pc] == 'B':
        status = "dead"
        break

for line in lair:
    print(*line, sep='')

print(f"{status}: {pr} {pc}")
