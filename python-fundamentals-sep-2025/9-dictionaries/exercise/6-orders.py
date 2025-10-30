input_line = input()
products = {}

while input_line != 'buy':
    item, price, qnty = input_line.split()
    price, qnty = float(price), int(qnty)

    if item not in products:
        products[item] = [price, qnty]
    else:
        products[item] = [price, products[item][1] + qnty]

    input_line = input()

for product, info in products.items():
    total_price = info[0] * info[1]
    print(f"{product} -> {total_price:.2f}")
