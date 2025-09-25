strawberry_price = float(input())
banana_kg = float(input())
orange_kg = float(input())
raspberry_kg = float(input())
strawberry_kg = float(input())

raspberry_price = strawberry_price / 2
orange_price = raspberry_price - (raspberry_price * 0.4)
banana_price = raspberry_price - (raspberry_price * 0.8)

strawberry_total_price = strawberry_kg * strawberry_price
banana_total_price = banana_kg * banana_price
orange_total_price = orange_kg * orange_price
raspberry_total_price = raspberry_kg * raspberry_price
total_to_pay = strawberry_total_price + banana_total_price + orange_total_price + raspberry_total_price

print(f"{total_to_pay:.2f}")