energy = int(input())
win_cnt = 0

while True:
    token = input()
    distance = 0

    if token == "End of battle":
        print(f"Won battles: {win_cnt}. Energy left: {energy}")
        break
    elif token.isdigit():
        distance = int(token)

    if energy >= distance:
        win_cnt += 1
        energy -= distance
    else:
        print(f"Not enough energy! Game ends with {win_cnt} won battles and {energy} energy")
        break

    if win_cnt % 3 == 0:
        energy += win_cnt
