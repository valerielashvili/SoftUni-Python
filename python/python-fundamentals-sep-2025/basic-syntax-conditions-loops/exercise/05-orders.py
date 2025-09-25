n_orders = int(input())
total_price = 0

for i in range(0, n_orders):
    price_per_capsule = float(input())
    days = int(input())
    capsules_per_day = int(input())

    if not (0.01 <= price_per_capsule <= 100.00):
        continue
    elif not (1 <= days <= 31):
        continue
    elif not (1 <= capsules_per_day <= 2000):
        continue

    daily_coffee_price = capsules_per_day * days * price_per_capsule
    total_price += daily_coffee_price
    print(f"The price for the coffee is: ${daily_coffee_price:.2f}")

print(f"Total: ${total_price:.2f}")