num_floors = int(input())
num_apart_per_floor = int(input())

for i in range(num_floors, 0, -1):
    for j in range(0, num_apart_per_floor):

        if i % 2 == 0 and i != num_floors:
            print(f"O{i}{j} ", end="")
        elif i % 2 == 1 and i != num_floors:
            print(f"A{i}{j} ", end="")
        elif i == num_floors or num_floors == 1:
            print(f"L{i}{j} ", end="")

    print()