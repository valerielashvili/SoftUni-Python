n_lines = int(input())
students = {}

for _ in range(n_lines):
    line = tuple(input().split())
    student, grade = line
    if student not in students:
        students[student] = []
    students[student].append(float(grade))

for name, grades in students.items():
    avg = sum(grades) / len(grades)
    grades_str = " ".join(f"{grade:.2f}" for grade in grades)
    print(f"{name} -> {grades_str} (avg: {avg:.2f})")
