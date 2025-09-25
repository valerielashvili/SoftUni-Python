length_cm = int(input())
width_cm = int(input())
height_cm = int(input())
filled_capacity = float(input())

fish_tank_volume = (length_cm * width_cm * height_cm) / 1000
needed_liters = fish_tank_volume * (1 - (filled_capacity / 100))

print(needed_liters)
