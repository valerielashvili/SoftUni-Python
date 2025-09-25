flower = input()
num_flowers = int(input())
budget = int(input())

price = 0
discount = 0
extra_charge = 0

if flower == 'Roses':
    price = num_flowers * 5

    if num_flowers > 80:
        discount = price * 0.10
        price -= discount

elif flower == 'Dahlias':
    price = num_flowers * 3.80

    if num_flowers > 90:
        discount = price * 0.15
        price -= discount

elif flower == 'Tulips':
    price = num_flowers * 2.80

    if num_flowers > 80:
        discount = price * 0.15
        price -= discount

elif flower == 'Narcissus':
    price = num_flowers * 3

    if num_flowers < 120:
        extra_charge = price * 0.15
        price += extra_charge

elif flower == 'Gladiolus':
    price = num_flowers * 2.50

    if num_flowers < 80:
        extra_charge = price * 0.20
        price += extra_charge

if budget >= price:
    print(f"Hey, you have a great garden with {num_flowers} {flower} and {budget - price:.2f} leva left.")
else:
    print(f"Not enough money, you need {price - budget:.2f} leva more.")
