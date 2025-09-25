num_students = int(input())

top_students = 0
good_students = 0
not_so_bad_students = 0
failed_students = 0

average_grade = 0

for i in range(0, num_students):
    grade = float(input())

    if grade >= 5.00:
        top_students += 1
    elif 4.00 <= grade <= 4.99:
        good_students += 1
    elif 3.00 <= grade <= 3.99:
        not_so_bad_students += 1
    elif grade < 3:
        failed_students += 1

    average_grade += grade

average_grade = average_grade / num_students

print(f"Top students: {top_students / num_students * 100:.2f}%\n"
      f"Between 4.00 and 4.99: {good_students / num_students * 100:.2f}%\n"
      f"Between 3.00 and 3.99: {not_so_bad_students / num_students * 100:.2f}%\n"
      f"Fail: {failed_students / num_students * 100:.2f}%\n"
      f"Average: {average_grade:.2f}\n")