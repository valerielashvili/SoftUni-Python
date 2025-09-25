age = int(input())
washing_machine_price = float(input())
toy_price = int(input())

money = 0
toys = 0

for i in range(1, age + 1):
    if i == 2:
        money += 9
    elif i % 2 == 0:
        money += i / 2 * 10 - 1
    else:
        toys += 1

money += toys * toy_price

if money >= washing_machine_price:
    print(f"Yes! {money - washing_machine_price:.2f}")
else:
    print(f"No! {washing_machine_price - money:.2f}")
