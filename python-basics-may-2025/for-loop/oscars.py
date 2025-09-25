actor_name = input()
points = float(input())
num_judges = int(input())

for i in range(0, num_judges):
    name = input()
    judge_points = float(input())

    points += len(name) * judge_points / 2

    if points >= 1250.5:
        print(f"Congratulations, {actor_name} got a nominee for leading role with {points:.1f}!")
        break

if points < 1250.5:
    print(f"Sorry, {actor_name} you need {1250.5 - points:.1f} more!")
