PUZZLE_PRICE = 2.60
PUPPET_PRICE = 3
BEAR_PRICE = 4.10
MINION_PRICE = 8.20
TRUCK_PRICE = 2

tour_price = float(input())
num_puzzles = int(input())
num_puppets = int(input())
num_bears = int(input())
num_minions = int(input())
num_trucks = int(input())
discount = 0

total_toys = num_puzzles + num_puppets + num_bears + num_minions + num_trucks
total_price = num_puzzles * PUZZLE_PRICE + num_puppets * PUPPET_PRICE + num_bears * BEAR_PRICE + num_minions * MINION_PRICE + num_trucks * TRUCK_PRICE

if total_toys >= 50:
    discount = total_price * 0.25
    total_price -= discount

# 10% shop rent
total_price -= total_price * 0.10

if total_price >= tour_price:
    money_left = total_price - tour_price
    print(f"Yes! {money_left:.2f} lv left.")
else:
    money_needed = tour_price - total_price
    print(f"Not enough money! {money_needed:.2f} lv needed.")
