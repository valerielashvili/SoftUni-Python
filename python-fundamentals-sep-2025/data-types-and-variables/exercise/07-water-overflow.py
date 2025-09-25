n_lines = int(input())

tank_capacity = 255
used_capacity = 0

for i in range(n_lines):
    liters = int(input())

    if used_capacity + liters <= tank_capacity:
        used_capacity += liters
    else:
        print("Insufficient capacity!")

print(used_capacity)