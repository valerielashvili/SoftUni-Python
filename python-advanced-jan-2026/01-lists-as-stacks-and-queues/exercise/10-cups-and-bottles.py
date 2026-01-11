from collections import deque


cups = deque([int(c) for c in input().split()])
bottles = ([int(b) for b in input().split()])

wasted_water = 0

while cups and bottles:
    last_bottle = bottles.pop()
    first_cup = cups.popleft()

    if first_cup > last_bottle:
        first_cup -= last_bottle
        cups.appendleft(first_cup)
    else:
        wasted_water += last_bottle - first_cup

if not cups:
    print(f"Bottles: {' '.join(map(str, bottles[::-1]))}")
elif not bottles:
    print(f"Cups: {' '.join(map(str, cups))}")

print(f"Wasted litters of water: {wasted_water}")
