clothes = [int(c) for c in input().split()]
rack_capacity = int(input())

n_racks = 1
current_sum = 0

while clothes:
    cloth_value = clothes.pop()

    if current_sum + cloth_value <= rack_capacity:
        current_sum += cloth_value
    else:
        n_racks += 1
        current_sum = cloth_value

print(n_racks)
