n_lines = int(input())
students = {}

for n in range(n_lines):
    name, grade = input(), float(input())
    grades = students.get(name, [])
    grades.append(grade)
    students[name] = grades

filtered_students = {
    k: average
    for k, v in students.items()
    if v and (average := sum(v) / len(v)) >= 4.50
}

for name, avg_grade in filtered_students.items():
    print(f"{name} -> {avg_grade:.2f}")
