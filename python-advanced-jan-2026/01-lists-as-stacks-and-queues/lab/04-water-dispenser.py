from collections import deque


water_quantity = int(input())
people_queue = deque()

while (name := input()) != 'Start':
    people_queue.append(name)

while (command := input()) != 'End':
    tokens = command.split()
    if tokens[0] == 'refill':
        water_quantity += int(tokens[1])
    else:
        liters = int(tokens[0])
        if liters <= water_quantity:
            person_name = people_queue.popleft()
            water_quantity -= liters
            print(f"{person_name} got water")
        else:
            person_name = people_queue.popleft()
            print(f"{person_name} must wait")

print(f"{water_quantity} liters left")
