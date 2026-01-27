def get_shooter_position(rows, field):
    # Get Shooter's start position
    r, c = next(
        ((r, c) for r in range(rows) for c in range(rows) if field[r][c] == 'A'),
        (None, None)
    )
    return r, c


def move(way, r, c, distance, rows, field):
    dr, dc = DIRS[way]
    nr = r + dr * distance
    nc = c + dc * distance

    if in_boundary(nr, nc, rows) and field[nr][nc] == '.':
        field[r][c] = '.'
        field[nr][nc] = 'A'
        return field, nr, nc

    return field, r, c


def in_boundary(r, c, rows):
    return 0 <= r < rows and 0 <= c < rows


def update_field(r, c, field):
    field[r][c] = '*'
    return field


def shoot(way, r, c, rows, field):
    dr, dc = DIRS[way]
    nr, nc = r + dr, c + dc
    shot_target = None

    while in_boundary(nr, nc, rows):
        if field[nr][nc] == 'x':
            shot_target = (nr, nc)
            field[nr][nc] = '.'
            break
        nr += dr
        nc += dc

    return field, shot_target


size = 5
shooting_range = []
shot_targets = []
DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

for line in range(size):
    shooting_range.append([c for c in input().split()])

row, col = get_shooter_position(size, shooting_range)
n_commands = int(input())

for _ in range(n_commands):
    tokens = input().split()
    cmd, direction, steps = tokens[0], tokens[1], int(tokens[2]) if len(tokens) > 2 else None
    current_target = None

    if cmd == 'move':
        shooting_range, row, col = move(direction, row, col, steps, size, shooting_range)
    elif cmd == 'shoot':
        shooting_range, current_target = shoot(direction, row, col, size, shooting_range)

        if current_target:
            shot_targets.append(current_target)

    if not any('x' in line for line in shooting_range):
        break

remaining_targets = sum(row.count('x') for row in shooting_range)

if not remaining_targets:
    print(f'Training completed! All {len(shot_targets)} targets hit.')
else:
    print(f'Training not completed! {remaining_targets} targets left.')

for target in shot_targets:
    print(f"[{target[0]}, {target[1]}]")
