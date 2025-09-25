trip_price = float(input())
budget = float(input())

spending_counter = 0
days_counter = 0

while budget < trip_price and spending_counter < 5:
    action = input()
    daily_money = float(input())
    days_counter += 1

    if action == 'save':
        budget += daily_money
        spending_counter = 0
    elif action == 'spend':
        budget -= daily_money
        spending_counter += 1
        if budget < 0:
            budget = 0

if spending_counter == 5:
    print(f"You can't save the money.\n"
          f"{days_counter}")

if budget >= trip_price:
    print(f"You saved the money for {days_counter} days.")