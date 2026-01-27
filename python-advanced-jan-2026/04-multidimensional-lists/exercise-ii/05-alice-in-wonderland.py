def get_alice_position(rows, field):
    # Get Alice's start position
    r, c = next(
        ((r, c) for r in range(rows) for c in range(rows) if field[r][c] == 'A'),
        (-1, -1)
    )
    return r, c


def move(cmd, r, c):
    dr, dc = DIRS[cmd]
    return r + dr, c + dc


def in_boundary(r, c, rows):
    return 0 <= r < rows and 0 <= c < rows


def update_field(r, c, field):
    field[r][c] = '*'
    return field


size = int(input())
wonderland = []
tea_bags = 0
DIRS = {
    'up': (-1, 0),
    'down': (1, 0),
    'left': (0, -1),
    'right': (0, 1)
}

for line in range(size):
    wonderland.append([c for c in input().split()])

row, col = get_alice_position(size, wonderland)

while True:
    command = input()
    nr, nc = move(command, row, col)
    wonderland = update_field(row, col, wonderland)

    # Alice went out of the Wonderland
    if not in_boundary(nr, nc, size):
        wonderland = update_field(row, col, wonderland)
        break

    # Alice stepped into the rabbit hole
    if wonderland[nr][nc] == 'R':
        wonderland = update_field(nr, nc, wonderland)
        break

    # Collect a tea bag if stepped on a number
    if wonderland[nr][nc].isdigit():
        tea_bags += int(wonderland[nr][nc])
        wonderland = update_field(nr, nc, wonderland)

    if tea_bags >= 10:
        break

    wonderland = update_field(nr, nc, wonderland)
    row, col = nr, nc

if tea_bags >= 10:
    print("She did it! She went to the party.")
else:
    print("Alice didn't make it to the tea party.")

for line in wonderland:
    print(*line, sep=' ')
