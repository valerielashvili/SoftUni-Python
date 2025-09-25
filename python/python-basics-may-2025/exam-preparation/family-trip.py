budget = float(input())
num_days = int(input())
price_per_day = float(input())
additional_costs = int(input())

budget -= budget * additional_costs / 100

if num_days > 7:
    price_per_day -= price_per_day * 0.05

accommodation_price = num_days * price_per_day

if budget - accommodation_price >= 0:
    print(f"Ivanovi will be left with {budget - accommodation_price:.2f} leva after vacation.")
else:
    print(f"{accommodation_price - budget:.2f} leva needed.")