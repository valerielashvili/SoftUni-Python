num_persons = int(input())
elevator_capacity = int(input())

num_courses = 0

if num_persons <= elevator_capacity:
    num_courses = 1
else:
    num_courses = num_persons // elevator_capacity
    if num_persons % elevator_capacity != 0:
        num_courses += 1

print(num_courses)