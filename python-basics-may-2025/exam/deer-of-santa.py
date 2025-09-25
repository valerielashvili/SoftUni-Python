from math import floor, ceil

days_santa_missing = int(input())
left_food_kg = int(input())
first_deer_food_quota = float(input())
second_deer_food_quota = float(input())
third_deer_food_quota = float(input())

total_food_eaten = 0

for day in range(0, days_santa_missing):
    total_food_eaten += first_deer_food_quota + second_deer_food_quota + third_deer_food_quota

if left_food_kg - total_food_eaten >= 0:
    print(f"{floor(left_food_kg - total_food_eaten)} kilos of food left.")
else:
    print(f"{ceil(total_food_eaten - left_food_kg)} more kilos of food are needed.")