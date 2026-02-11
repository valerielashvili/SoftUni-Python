from collections import deque


strength_values = [int(x) for x in input().split()]
accuracy_values = deque(int(x) for x in input().split())
goals = 0

while strength_values and accuracy_values:
    strength = strength_values.pop()
    accuracy = accuracy_values.popleft()
    current_sum = strength + accuracy

    if current_sum == 100:
        goals += 1
    elif current_sum < 100:
        if strength < accuracy:
            accuracy_values.appendleft(accuracy)
        elif strength > accuracy:
            strength_values.append(strength)
        elif strength == accuracy:
            strength_values.append(current_sum)

    elif current_sum > 100:
        strength_values.append(strength - 10)
        accuracy_values.append(accuracy)

if goals > 3:
    print('Paul performed remarkably well!')
elif goals == 3:
    print('Paul scored a hat-trick!')
elif goals == 0:
    print('Paul failed to score a single goal.')
elif 0 < goals < 3:
    print('Paul failed to make a hat-trick.')

if goals:
    print(f'Goals scored: {goals}')

if strength_values:
    print(f"Strength values left: {', '.join(map(str, strength_values))}")
if accuracy_values:
    print(f"Accuracy values left: {', '.join(map(str, accuracy_values))}")
