movie_budget = float(input())
num_mass_actors = int(input())
costume_price = float(input())

decor_price = movie_budget * 0.10
total_costume_price = num_mass_actors * costume_price

if num_mass_actors > 150:
    total_costume_price -= total_costume_price * 0.10

movie_price = total_costume_price + decor_price

if movie_price > movie_budget:
    money_needed = movie_price - movie_budget
    print(f"Not enough money!\nWingard needs {money_needed:.2f} leva more.")
else:
    money_left = movie_budget - movie_price
    print(f"Action!\nWingard starts filming with {money_left:.2f} leva left.")
