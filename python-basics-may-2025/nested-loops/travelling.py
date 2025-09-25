while True:
    destination = input()
    if destination == 'End':
        break
    travel_cost = float(input())

    total_saved_money = 0

    while total_saved_money < travel_cost:
        saved_money = float(input())
        total_saved_money += saved_money

    print(f"Going to {destination}!")