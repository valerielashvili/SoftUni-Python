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


DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

rows, cols = [int(x) for x in input().split(', ')]
matrix = []
time = 16
defuse_time = 4
defusing = False
bomb_defused = False
bomb_exploded = False
counter_t_killed = False

for _ in range(rows):
    matrix.append(list(input()))

row, col = get_position(rows, cols, matrix, 'C')
nr, nc = 0, 0

while time > 0:
    command = input()

    if command == 'defuse': # Not working
        if matrix[nr][nc] != 'B':
            time -= 2
            continue
        else:
            # Defuse bomb
            defusing = True
            time -= 4
            if time >= 0:
                matrix[nr][nc] = 'D'
                bomb_defused = True
                break
            else:
                matrix[nr][nc] = 'X'
                bomb_exploded = True
                break

    nr, nc = move(row, col, command, rows, cols)

    if matrix[nr][nc] == 'B':
        continue
    elif matrix[nr][nc] == 'T':
        matrix[nr][nc] = '*'
        counter_t_killed = True
        break

    row, col = nr, nc
    time -= 1

if time == 0:
    bomb_exploded = True
    # br, bc = get_position(rows, cols, matrix, 'B')
    # matrix[br][bc] = 'X'

if bomb_exploded:
    print(f'Terrorists win!\n'
          f'Bomb was not defused successfully!')
    if not defusing:
        time = 0
    print(f'Time needed: {abs(time)} second/s.')

elif bomb_defused:
    print(f'Counter-terrorist wins!\n'
          f'Bomb has been defused: {time} second/s remaining.')

elif counter_t_killed:
    print('Terrorists win!')

for row in matrix:
    print(' '.join(map(str, row)))
