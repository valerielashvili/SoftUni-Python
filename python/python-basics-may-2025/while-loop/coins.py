change = float(input())
cents = int(change * 100)
total_coins = 0

for i in 200, 100, 50, 20, 10, 5, 2, 1:
    if cents >= i:
        coins = 0
        coins += cents // i
        cents -= coins * i
        total_coins += coins

print(int(total_coins))