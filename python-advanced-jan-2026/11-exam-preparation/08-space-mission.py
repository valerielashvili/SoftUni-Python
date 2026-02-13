def get_position(rows, field, ship_pos):
    r, c = next(
        ((r, c) for r in range(rows) for c in range(rows) if field[r][c] == ship_pos),
        (None, None)
    )
    return r, c


def move(r, c, cmd):
    dr, dc = DIRS[cmd]
    return r + dr, c + dc


def in_boundary(r, c, rows):
    return 0 <= r < rows and 0 <= c < rows


def validate_move(resources, r, c, nxt_r, nxt_c, field, rows):
    status = ''
    if in_boundary(nxt_r, nxt_c, rows):
        if field[nxt_r][nxt_c] == 'R': # space station
            resources += 10
            if resources > 100:
                resources = 100

        elif field[nxt_r][nxt_c] == 'M': # meteorite
            resources -= 5
            field[nxt_r][nxt_c] = '.'

        elif field[nxt_r][nxt_c] == 'P': # planet B
            status = 'accomplished'
    else:
        field[r][c] = 'S'
        status = 'lost_in_space'

    return status, resources, field

DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

size = int(input())
matrix = []
ship_resources = 100
mission_status = ''

for _ in range(size):
    matrix.append(list(input().split()))

row, col = get_position(size, matrix, 'S')
matrix[row][col] = '.'

while True:
    command = input()
    nr, nc = move(row, col, command)
    ship_resources -= 5
    mission_status, ship_resources, matrix = validate_move(ship_resources, row, col, nr, nc, matrix, size)

    if mission_status == 'accomplished' or mission_status == 'lost_in_space':
        break
    elif ship_resources < 5:
        matrix[nr][nc] = 'S'
        mission_status = 'stranded_in_space'
        break

    row, col = nr, nc

if mission_status == 'accomplished':
    print(f"Mission accomplished! The spaceship reached Planet B with {ship_resources} resources left.")
elif mission_status == 'stranded_in_space':
    print("Mission failed! The spaceship was stranded in space.")
elif mission_status == 'lost_in_space':
    print("Mission failed! The spaceship was lost in space.")

for row in matrix:
    print(' '.join(row))
