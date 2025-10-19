days_of_adventure = int(input())
adventurers_n = int(input())
group_energy = float(input())
water_person_day = float(input())
food_person_day = float(input())

total_food = days_of_adventure * food_person_day * adventurers_n
total_water = days_of_adventure * water_person_day * adventurers_n

for day in range(1, days_of_adventure + 1):
    daily_energy_loss = float(input())

    group_energy -= daily_energy_loss
    if group_energy <= 0:
        break

    if day % 2 == 0:
        group_energy += group_energy * 0.05
        total_water -= total_water * 0.3

    if day % 3 == 0:
        group_energy += group_energy * 0.1
        total_food -= total_food / adventurers_n

if group_energy > 0:
    print(f"You are ready for the quest. You will be left with {group_energy:.2f} energy!")
else:
    print(f"You will run out of energy. You will be left with {total_food:.2f} food and {total_water:.2f} water.")
