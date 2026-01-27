def get_knights_positions(rows, field):
    # Get all knights positions
    k_positions = [
        (r, c) for r in range(rows) for c in range(rows) if field[r][c] == 'K'
    ]
    return k_positions


def in_boundary(r, c, rows):
    return 0 <= r < rows and 0 <= c < rows


def move_vert(r, c, rows):
    for dr in (-2, 2):
        for dc in (-1, 1):
            nr, nc = r + dr, c + dc
            if in_boundary(nr, nc, rows):
                yield nr, nc


def move_hor(r, c, rows):
    for dr in (-1, 1):
        for dc in (-2, 2):
            nr, nc = r + dr, c + dc
            if in_boundary(nr, nc, rows):
                yield nr, nc


def count_hits(pos, rows):
    r, c = pos
    hits = 0
    for nr_vert, nc_vert in move_vert(r, c, rows):
        if board[nr_vert][nc_vert] == 'K':
            hits += 1

    for nr_hor, nc_hor in move_hor(r, c, rows):
        if board[nr_hor][nc_hor] == 'K':
            hits += 1

    return hits


size = int(input())
board = []
knights_positions = []
n_knights_to_remove = 0

for row in range(size):
    board.append([s for s in input()])

knights_positions = get_knights_positions(size, board)

while knights_positions:
    max_k_hits = 0
    strongest_knight = ()

    for k_pos in knights_positions:
        # Account N-knights who can attack the greatest N of other knights
        k_hits = count_hits(k_pos, size)
        if k_hits > max_k_hits:
            max_k_hits = k_hits
            strongest_knight = k_pos

    if not strongest_knight:
        break
    else:
        knights_positions.remove(strongest_knight)
        row, col = strongest_knight
        board[row][col] = 0
        n_knights_to_remove += 1

print(n_knights_to_remove)
