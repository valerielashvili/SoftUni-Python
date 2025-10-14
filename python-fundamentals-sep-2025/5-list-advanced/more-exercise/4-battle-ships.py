n_rows = int(input())
field = []

for _ in range(n_rows):
    field.append([int(x) for x in input().split()])

targets = [[int(x) for x in x.split('-')] for x in input().split()]
destroyed_ships = 0

for t in targets:
    r, c = t[0], t[1]

    if field[r][c] > 0:
        field[r][c] -= 1
        if field[r][c] == 0:
            destroyed_ships += 1

print(destroyed_ships)
