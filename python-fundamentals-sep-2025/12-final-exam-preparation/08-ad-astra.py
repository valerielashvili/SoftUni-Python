import math
import re

text = input()
food_regex = re.compile(
    r'(\||#)(?P<item>[A-Za-z ]+)\1'
    r'(?P<date>\d{2}/\d{2}/\d{2})\1'
    r'(?P<calories>\d{1,5})\1'
)
total_calories = 0
days = 0
food = []

for match in food_regex.finditer(text):
    if match:
        total_calories += int(match.group('calories'))
        food.append((match.group('item'), match.group('date'), match.group('calories')))

days = total_calories / 2000
print(f"You have food to last you for: {math.floor(days)} days!")
for item in food:
    print(f"Item: {item[0]}, Best before: {item[1]}, Nutrition: {item[2]}")
