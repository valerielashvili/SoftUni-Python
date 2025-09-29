items = input().split('|')
initial_budget = int(input())

items_baught = []
travel_budget = 0
profit = 0

for element in items:
    element = element.split('->')
    item = element[0]
    price = float(element[1])

    if initial_budget >= price:
        if item == 'Clothes' and price <= 50.00:
            initial_budget -= price
            items_baught.append(price)
        elif item == 'Shoes' and price <= 35.00:
            initial_budget -= price
            items_baught.append(price)
        elif item == 'Accessories' and price <= 20.50:
            initial_budget -= price
            items_baught.append(price)

total_old_price = sum(items_baught)
items_baught = [i + i * 0.4 for i in items_baught]
total_new_price = sum(items_baught)

profit = total_new_price - total_old_price
new_budget = total_new_price + initial_budget

[print(' '.join(f"{price:.2f}" for price in items_baught))]
print(f"Profit: {profit:.2f}")

if new_budget >= 150:
    print("Hello, France!")
else:
    print("Not enough money.")
