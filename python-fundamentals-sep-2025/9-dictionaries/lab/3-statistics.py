input_line = input()
stock = {}

while input_line != 'statistics':
    prod, qty = input_line.split(':')

    if prod not in stock:
        stock[prod] = int(qty)
    else:
        stock[prod] += int(qty)

    input_line = input()

print("Products in stock:")
for p, q in stock.items():
    print(f"- {p}: {q}")

print(f"Total Products: {len(stock)}\n"
      f"Total Quantity: {sum(stock.values())}")
