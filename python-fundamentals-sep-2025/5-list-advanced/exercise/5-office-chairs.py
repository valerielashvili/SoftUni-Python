n_rooms = int(input())
free_chairs = 0
chairs_needed = 0

for n in range(1, n_rooms + 1):
    tokens = input().split(' ')
    n_chairs = len(tokens[0])
    n_visitors = int(tokens[1])

    if n_chairs < n_visitors:
        print(f"{n_visitors - n_chairs} more chairs needed in room {n}")
        chairs_needed += n_visitors - n_chairs
    else:
        free_chairs += n_chairs - n_visitors

if free_chairs >= chairs_needed:
    print(f"Game On, {free_chairs} free chairs left")
