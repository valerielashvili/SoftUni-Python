pupil_name = input()
grades = 1
total_grades = 0
excluded = 0

while grades <= 12:
    grade = float(input())

    if grade < 4:
        excluded += 1
        if excluded == 2:
            break
        continue

    total_grades += grade
    grades += 1

if excluded == 2:
    print(f"{pupil_name} has been excluded at {grades} grade")
else:
    print(f"{pupil_name} graduated. Average grade: {total_grades / (grades - 1):.2f}")