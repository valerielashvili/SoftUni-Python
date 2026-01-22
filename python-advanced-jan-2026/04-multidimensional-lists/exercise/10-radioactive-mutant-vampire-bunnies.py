def move(direction, r, c):
    nr, nc = r, c
    if direction == 'U':
        nr -= 1
    elif direction == 'D':
        nr += 1
    elif direction == 'L':
        nc -= 1
    elif direction == 'R':
        nc += 1
    return nr, nc, r, c


def check_boundary(r, c, lines, cells):
    if 0 <= r < lines and 0 <= c < cells:
        return True
    else:
        return False


def update_lair(field, lines, cells):
    # spread bunnies
    for dr in (-1, 1):
        for dc in (-1, 1):
            nr, nc = r + dr, c + dc
            if check_boundary(nr, nc, lines, cells):
                field[nr][nc] = 'B'
    # TODO: find all bunnies and bubble them

rows, cols = [int(n) for n in input().split()]
lair = []
commands = []
win = None

for r in range(rows):
    lair.append([c for c in input()])

cmd_str = input()
for cmd in cmd_str:
    commands.append(cmd)

# get player's start position
p_row, p_col = next(
    ((r, c) for r in range(rows) for c in range(cols) if lair[r][c] == 'P'),
    None
)
last_r, last_c = None, None

for cmd in commands:
    row, col, last_r, last_c = move(cmd, p_row, p_col)

    if check_boundary(row, col, rows, cols):
        lair[last_r][last_c] = '.'
        if lair[row][col] != 'B':
            lair[row][col] = 'P'
        else:
            lair = update_lair(lair, rows, cols)
            win = False
            break
    else:
        lair = update_lair(lair, rows, cols)
        win = True
        break

# TODO: print the result
