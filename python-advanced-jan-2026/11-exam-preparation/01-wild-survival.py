from collections import deque


bee_groups = deque(int(b) for b in input().split(' '))
bee_eaters = [int(e) for e in input().split(' ')]

while bee_groups and bee_eaters:
    bees = bee_groups.popleft()
    attackers = bee_eaters.pop()

    while bees > 0 and attackers > 0:
        if bees >= 7:
            bees -= 7
            attackers -= 1
        else:
            bees = 0

    if bees <= 0 and attackers:
        bee_eaters.append(attackers)
    elif attackers <= 0 and bees:
        bee_groups.append(bees)

print('The final battle is over!')

if not bee_groups and not bee_eaters:
    print('But no one made it out alive!')

if bee_groups:
    print(f"Bee groups left: {', '.join(str(b) for b in bee_groups)}")

if bee_eaters:
    print(f"Bee-eater groups left: {', '.join(str(b) for b in bee_eaters)}")
