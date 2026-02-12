def get_position(lines, cells, field, item):
    r, c = next(
        ((r, c) for r in range(lines) for c in range(cells) if field[r][c] == item),
        (None, None)
    )
    return r, c


def move(r, c, cmd, lines, cells):
    dr, dc = DIRS[cmd]
    if in_boundary(r + dr, c + dc, lines, cells):
        return r + dr, c + dc
    else:
        return r, c


def in_boundary(r, c, lines, cells):
    return 0 <= r < lines and 0 <= c < cells


def defuse_bomb(defuse_time, r, c, field):
    defuse_state = {
        'skip': False,
        'defusing': False,
        'defused': False,
        'exploded': False
    }

    if field[r][c] != 'B':
        defuse_time -= 2
        defuse_state['skip_move'] = True
        return defuse_time, defuse_state

    # Defuse bomb
    if field[r][c] == 'B':
        defuse_state['defusing_bomb'] = True
        defuse_time -= 4

        if defuse_time >= 0:
            field[r][c] = 'D'
            defuse_state['bomb_defused'] = True
            return defuse_time, defuse_state
        else:
            field[r][c] = 'X'
            defuse_state['bomb_exploded'] = True
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
        'defusing': False,
        'defused': False,
        'exploded': False
    }
counter_t_killed = False

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

    nr, nc = move(row, col, command, rows, cols)

    if matrix[nr][nc] == 'T':
        matrix[nr][nc] = '*'
        counter_t_killed = True
        break

    row, col = nr, nc
    time -= 1

if time == 0:
    exploded = True
    # br, bc = get_position(rows, cols, matrix, 'B')
    # matrix[br][bc] = 'X'

if defuse_progress['exploded']:
    print(f'Terrorists win!\n'
          f'Bomb was not defused successfully!')
    if not defuse_progress['defusing']:
        time = 0
    print(f'Time needed: {abs(time)} second/s.')

elif defuse_progress['exploded']:
    print(f'Counter-terrorist wins!\n'
          f'Bomb has been defused: {time} second/s remaining.')

elif counter_t_killed:
    print('Terrorists win!')

for row in matrix:
    print(' '.join(map(str, row)))
