def get_position(lines, cells, field, item):
    r, c = next(
        ((r, c) for r in range(lines) for c in range(cells) if field[r][c] == item),
        (None, None)
    )
    return r, c


def move(r, c, cmd):
    dr, dc = DIRS[cmd]
    return r + dr, c + dc


def in_boundary(r, c, lines, cells):
    return 0 <= r < lines and 0 <= c < cells


def defuse_bomb(defuse_time, r, c, field):
    defuse_state = {
        'skip': False,
        'defused': False,
        'exploded': False,
        'ct_killed': False
    }

    if field[r][c] != 'B':
        defuse_time -= 2
        defuse_state['skip'] = True
        return defuse_time, defuse_state

    # Defuse bomb
    if field[r][c] == 'B':
        defuse_time -= 4

        if defuse_time >= 0:
            field[r][c] = 'D'
            defuse_state['defused'] = True
            return defuse_time, defuse_state
        else:
            field[r][c] = 'X'
            defuse_state['exploded'] = True
            return defuse_time, defuse_state

    return defuse_time, defuse_state

DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

rows, cols = [int(x) for x in input().split(', ')]
matrix = []
time = 16
defuse_progress = {
    'skip': False,
    'defused': False,
    'exploded': False,
    'ct_killed': False
    }

for _ in range(rows):
    matrix.append(list(input()))

row, col = get_position(rows, cols, matrix, 'C')
nr, nc = 0, 0

while time > 0:
    command = input()

    if command == 'defuse':
        time, defuse_progress = defuse_bomb(time, row, col, matrix)

        if defuse_progress['skip']:
            continue
        if defuse_progress['defused'] or defuse_progress['exploded']:
            break

    nr, nc = move(row, col, command)
    if not in_boundary(nr, nc, rows, cols):
        nr, nc = row, col
        time -= 1
        continue

    if matrix[nr][nc] == 'T':
        matrix[nr][nc] = '*'
        defuse_progress['ct_killed'] = True
        break

    row, col = nr, nc
    time -= 1

if time <= 0 and not defuse_progress['defused'] and not defuse_progress['ct_killed']:
    defuse_progress['exploded'] = True

if defuse_progress['exploded']:
    print(f'Terrorists win!\n'
          f'Bomb was not defused successfully!')
    print(f'Time needed: {abs(time)} second/s.')

elif defuse_progress['defused']:
    print(f'Counter-terrorist wins!\n'
          f'Bomb has been defused: {time} second/s remaining.')

elif defuse_progress['ct_killed']:
    print('Terrorists win!')

for row in matrix:
    print(''.join(row))
