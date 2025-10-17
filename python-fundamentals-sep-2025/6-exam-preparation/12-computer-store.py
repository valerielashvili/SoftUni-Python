price_total = 0

while True:
    input_str = input().strip()
    price = 0

    if input_str == 'special' or input_str == 'regular':
        break
    else:
        price = float(input_str)

    if price <= 0:
        print("Invalid price!")
        continue

    price_total += price

taxes_total = price_total * 0.2
price_after_tax = price_total + taxes_total

if input_str == 'special':
    price_after_tax -= price_after_tax * 0.1

if price_total == 0:
    print("Invalid order!")
else:
    print(f"Congratulations you've just bought a new computer!\n"
          f"Price without taxes: {price_total:.2f}$\n"
          f"Taxes: {taxes_total:.2f}$\n"
          f"-----------\n"
          f"Total price: {price_after_tax:.2f}$")
