from collections import deque


cups = deque([int(c) for c in input().split()])
bottles = ([int(b) for b in input().split()])

wasted_water = 0

while cups and bottles:
    bottle = bottles.pop()
    cup = cups.popleft()

    if cup > bottle:
        cup -= bottle
        cups.appendleft(cup)
    else:
        wasted_water += bottle - cup

if not cups:
    print(f"Bottles: {' '.join(map(str, bottles[::-1]))}")
elif not bottles:
    print(f"Cups: {' '.join(map(str, cups))}")

print(f"Wasted litters of water: {wasted_water}")
