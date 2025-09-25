n_jury = int(input())
presentation = input()

average_grade = 0
total_average = 0
average_counter = 0

while presentation != 'Finish':
    for i in range(0, n_jury):
        grade = float(input())
        average_grade += grade

    average_grade = average_grade / n_jury
    total_average += average_grade
    average_counter += 1
    print(f"{presentation} - {average_grade:.2f}.")

    average_grade = 0
    presentation = input()

print(f"Student's final assessment is {total_average / average_counter:.2f}.")