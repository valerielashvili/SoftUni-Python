from collections import deque


children = deque(input().split())
toss_num = int(input())

while len(children) != 1:
    for i in range(toss_num):
        children.append(children.popleft())
    print(f"Removed {children.pop()}")

print(f"Last is {children[0]}")
