from collections import deque
import operator

ops = {
    '+': operator.add,
    '-': operator.sub,
    '*': operator.mul,
    '/': operator.truediv
}

bees = deque([int(b) for b in input().split()])
total_nectar = [int(n) for n in input().split()]
operators = deque([o for o in input().split()])
honey = 0

while bees and total_nectar:
    bee = bees.popleft()
    nectar = total_nectar.pop()
    operation = operators.popleft()

    if nectar >= bee:
        if operation == '/' and nectar == 0:
            continue
        honey += abs(ops[operation](bee, nectar))
    else:
        bees.appendleft(bee)
        operators.appendleft(operation)

print(f"Total honey made: {honey}")
if bees:
    print(f"Bees left: {', '.join(map(str, bees))}")
if total_nectar:
    print(f"Nectar left: {', '.join(map(str, total_nectar))}")
