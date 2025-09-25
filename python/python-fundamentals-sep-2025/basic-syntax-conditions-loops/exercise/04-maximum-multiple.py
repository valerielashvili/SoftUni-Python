devisor = int(input())
boundary = int(input())

largest_devisee = 0

for i in range(boundary, -1, -1):
    if i % devisor == 0:
        largest_devisee = i
        break

if largest_devisee > 0:
    print(largest_devisee)