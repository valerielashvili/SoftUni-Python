from collections import deque


green_duration = int(input())
free_window = int(input())

cars = deque()
passed = 0
crash = False

while (command := input()) != 'END':
    if command != "green":
        cars.append(command)
    else:
        green_light = green_duration

        while cars and green_light > 0:
            car = cars.popleft()

            if len(car) <= green_light:
                green_light -= len(car)
                passed += 1
            else:
                remaining_length = len(car) - green_light

                if remaining_length <= free_window:
                    passed += 1
                    green_light = 0
                else:
                    hit_index = green_light + free_window
                    print("A crash happened!")
                    print(f"{car} was hit at {car[hit_index]}.")
                    crash = True
                    break

        if crash:
            break

if not crash:
    print("Everyone is safe.")
    print(f"{passed} total cars passed the crossroads.")
