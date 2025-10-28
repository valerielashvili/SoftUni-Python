products = input().split()
bakery_stock = {}

for i in range(0, len(products), 2):
    product = products[i]
    quantity = products[i + 1]

    bakery_stock[product] = int(quantity)

print(bakery_stock)
