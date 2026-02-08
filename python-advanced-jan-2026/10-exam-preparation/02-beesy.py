def get_bee_position(rows, field):
    r, c = next(
        ((r, c) for r in range(rows) for c in range(rows) if field[r][c] == 'B'),
        (None, None)
    )
    return r, c


def move(cmd, r, c, bees_energy):
    dr, dc = DIRS[cmd]
    nr, nc = r + dr, c + dc

    if nr < 0:
        nr = size - 1
    elif nr > size - 1:
        nr = 0

    if nc < 0:
        nc = size - 1
    elif nc > size - 1:
        nc = 0

    matrix[r][c] = '-'
    bees_energy -= 1
    return nr, nc, bees_energy


DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

size = int(input())
matrix = []
energy = 15
nectar = 0
restored_energy = False

for _ in range(size):
    matrix.append(list(input()))

row, col = get_bee_position(size, matrix)

while energy > 0:
    command = input()
    nxt_r, nxt_c, energy = move(command, row, col, energy)

    if matrix[nxt_r][nxt_c].isdigit():
            nectar += int(matrix[nxt_r][nxt_c])

    if energy <= 0 and not restored_energy and nectar >= 30:
        restored_energy = True
        energy += nectar - 30
        nectar = 30

    row, col = nxt_r, nxt_c

    if matrix[nxt_r][nxt_c] == 'H':
        if nectar >= 30:
            print(f'Great job, Beesy! The hive is full. Energy left: {energy}')
        else:
            print(f'Beesy did not manage to collect enough nectar.')
        break

    if energy <= 0:
        print("This is the end! Beesy ran out of energy.")
        break

matrix[row][col] = 'B'
for row in matrix:
    print(''.join(row))
