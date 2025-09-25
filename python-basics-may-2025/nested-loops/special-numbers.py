n = int(input())

is_special = None

for i in range(1111, 9999):
    for j, d in enumerate(str(i)):
        digit = int(d)
        if digit != 0 and n % digit == 0:
            is_special = True
        elif digit == 0 or n % digit != 0:
            is_special = False
            break

    if is_special:
        print(i, end=" ")