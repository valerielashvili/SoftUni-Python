movie_budget = float(input())
destination = input()
season = input()
num_days = int(input())

price_per_day = 0

if season == 'Winter':
    if destination == 'Dubai':
        price_per_day = 45000
    elif destination == 'Sofia':
        price_per_day = 17000
    elif destination == 'London':
        price_per_day = 24000

elif season == 'Summer':
    if destination == 'Dubai':
        price_per_day = 40000
    elif destination == 'Sofia':
        price_per_day = 12500
    elif destination == 'London':
        price_per_day = 20250

if destination == 'Dubai':
    price_per_day -= price_per_day * 0.3
elif destination == 'Sofia':
    price_per_day += price_per_day * 0.25

shooting_costs = num_days * price_per_day

if movie_budget - shooting_costs >= 0:
    print(f"The budget for the movie is enough! We have {movie_budget - shooting_costs:.2f} leva left!")
else:
    print(f"The director needs {shooting_costs - movie_budget:.2f} leva more!")