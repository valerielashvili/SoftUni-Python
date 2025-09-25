num_days = int(input())
food_amount = float(input())

total_eaten_biscuits = 0
total_eaten_by_dog = 0
total_eaten_by_cat = 0

for day in range(1, num_days + 1):
    food_eaten_by_dog = int(input())
    food_eaten_by_cat = int(input())

    total_eaten_by_dog += food_eaten_by_dog
    total_eaten_by_cat += food_eaten_by_cat

    if day % 3 == 0:
        total_eaten_biscuits += (food_eaten_by_dog + food_eaten_by_cat) * 0.1

total_food_percentage_eaten = (total_eaten_by_dog + total_eaten_by_cat) / food_amount * 100
percentage_eaten_by_dog = total_eaten_by_dog / (total_eaten_by_dog + total_eaten_by_cat) * 100
percentage_eaten_by_cat = total_eaten_by_cat / (total_eaten_by_dog + total_eaten_by_cat) * 100

print(f"Total eaten biscuits: {round(total_eaten_biscuits)}gr.\n"
      f"{total_food_percentage_eaten:.2f}% of the food has been eaten.\n"
      f"{percentage_eaten_by_dog:.2f}% eaten from the dog.\n"
      f"{percentage_eaten_by_cat:.2f}% eaten from the cat.")