budget = int(input())
season = input()
num_fisherman = int(input())

price = 0

if season == 'Spring':
    price = 3000
elif season == 'Summer' or season == 'Autumn':
    price = 4200
elif season == 'Winter':
    price = 2600

if num_fisherman <= 6:
    price -= price * 0.10
elif 7 <= num_fisherman <= 11:
    price -= price * 0.15
elif num_fisherman >= 12:
    price -= price * 0.25

if num_fisherman % 2 == 0 and season != 'Autumn':
    price -= price * 0.05

if budget >= price:
    print(f"Yes! You have {budget - price:.2f} leva left.")
else:
    print(f"Not enough money! You need {price - budget:.2f} leva.")
