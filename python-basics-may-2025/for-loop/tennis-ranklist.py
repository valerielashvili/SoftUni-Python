from math import floor

num_tournament = int(input())
points = int(input())

current_points = 0
win_counter = 0

for i in range(0, num_tournament):
    stage = input()

    if stage == 'W':
        current_points += 2000
        win_counter += 1
    elif stage == 'F':
        current_points += 1200
    elif stage == 'SF':
        current_points += 720

points += current_points
average_points = current_points / num_tournament

print(f"Final points: {points}")
print(f"Average points: {floor(average_points)}")
print(f"{win_counter / num_tournament * 100:.2f}%")
