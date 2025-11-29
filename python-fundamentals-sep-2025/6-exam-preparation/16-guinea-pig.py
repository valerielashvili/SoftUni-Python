def calc_kg(qnty: float) -> float:
    """Calculate kilograms."""
    return qnty / 1000


food_qnty = float(input()) * 1000
hay = float(input())  * 1000
cover = float(input()) * 1000
pig_weight = float(input()) * 1000
no_food = False

for day in range(1, 31):
    food_qnty -= 300
    if day % 2 == 0:
        hay -= food_qnty * 0.05

    if day % 3 == 0:
        cover -= pig_weight / 3

    if food_qnty <= 0 or hay <= 0 or cover <= 0:
        no_food = True
        break

if no_food:
    print("Merry must go to the pet store!")
else:
    print(f"Everything is fine! Puppy is happy! "
          f"Food: {calc_kg(food_qnty):.2f}, Hay: {calc_kg(hay):.2f}, Cover: {calc_kg(cover):.2f}.")
