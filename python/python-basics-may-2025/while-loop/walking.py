total_steps = 0

while 10000 >= total_steps:
    action = input()

    if action == "Going home":
        action = int(input())
        total_steps += action
        break
    else:
        total_steps += int(action)

if total_steps >= 10000:
    print(f"Goal reached! Good job!\n"
          f"{total_steps - 10000} steps over the goal!")
else:
    print(f"{10000 - total_steps} more steps to reach goal.")