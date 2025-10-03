fire_cells = input().split('#')
water = int(input())

effort = 0
total_fire_extinguished = 0
fire_cells_extinguished = []

for fire_cell in fire_cells:
    fire_cell = fire_cell.split(' = ')
    type_of_fire = fire_cell[0]
    fire_range = int(fire_cell[1])
    cell_is_valid = False

    if water < fire_range:
        continue

    if type_of_fire == 'High' and 81 <= fire_range <= 125:
        cell_is_valid = True

    elif type_of_fire == 'Medium' and 51 <= fire_range <= 80:
        cell_is_valid = True

    elif type_of_fire == 'Low' and 1 <= fire_range <= 50:
        cell_is_valid = True

    if cell_is_valid:
        water -= fire_range
        effort += fire_range * 0.25
        total_fire_extinguished += fire_range
        fire_cells_extinguished.append(fire_range)

print("Cells:")
[print(f" - {cell}") for cell in fire_cells_extinguished]
print(f"Effort: {effort:.2f}")
print(f"Total Fire: {total_fire_extinguished}")
