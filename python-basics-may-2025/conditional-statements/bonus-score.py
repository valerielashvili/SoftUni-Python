num = int(input())
bonus_points = 0

if num <= 100:
    bonus_points += 5
elif 100 < num <= 1000:
    bonus_points += num * 0.2
elif num > 1000:
    bonus_points += num * 0.1

if num % 2 == 0:
    bonus_points += 1
elif num % 10 == 5:
    bonus_points += 2

print(bonus_points)
print(bonus_points + num)
