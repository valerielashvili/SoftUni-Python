def get_bunny_position(rows, field):
    # Get bunny's start position
    r, c = next(
        ((r, c) for r in range(rows) for c in range(rows) if field[r][c] == 'B'),
        (-1, -1)
    )
    return r, c


def in_boundary(r, c, rows):
    return 0 <= r < rows and 0 <= c < rows


def scan_direction(r, c, dr, dc, rows, field):
    n_eggs = 0
    positions = []
    nr, nc = r + dr, c + dc

    while in_boundary(nr, nc, rows) and field[nr][nc] != 'X':
        n_eggs += int(field[nr][nc])
        positions.append((nr, nc))
        nr += dr
        nc += dc

    return n_eggs, positions


size = int(input())
matrix = []
direction = ''
bunny_positions = []
max_n_eggs = float('-inf')

for line in range(size):
    matrix.append([s for s in input().split()])

position = get_bunny_position(size, matrix)

directions = [
    ('up', -1, 0),
    ('down', 1, 0),
    ('left', 0, -1),
    ('right', 0, 1)
]

for vector, vect_r, vect_c in directions:
    row, col = position
    num_eggs, b_positions = scan_direction(row, col, vect_r, vect_c, size, matrix)

    if num_eggs > max_n_eggs and b_positions:
        max_n_eggs = num_eggs
        bunny_positions = b_positions
        direction = vector

print(direction)
for pos in bunny_positions:
    print(f"[{pos[0]}, {pos[1]}]")
print(max_n_eggs)
