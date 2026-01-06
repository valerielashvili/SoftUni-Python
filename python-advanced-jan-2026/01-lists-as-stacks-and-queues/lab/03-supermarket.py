from collections import deque

queue = deque()
while (command := input()) != 'End':
    if command == 'Paid':
        while len(queue):
            print(queue.popleft())
    else:
        queue.append(command)

print(f"{len(queue)} people remaining.")
