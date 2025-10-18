from math import ceil

students_num = int(input())
lectures_num = int(input())
bonus = int(input())
max_bonus = 0
student_attendances = 0

for s in range(students_num):
    attendances_cnt = int(input())
    total_bonus = attendances_cnt / lectures_num * (5 + bonus)

    if total_bonus > max_bonus:
        max_bonus = total_bonus
        student_attendances = attendances_cnt

print(f"Max Bonus: {ceil(max_bonus)}.\n"
      f"The student has attended {student_attendances} lectures.")
