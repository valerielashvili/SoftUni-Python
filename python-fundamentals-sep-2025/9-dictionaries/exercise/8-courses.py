courses = {}

while (input_line := input()) != 'end':
    course, name = input_line.split(' : ')
    if course not in courses:
        courses[course] = [name]
    else:
        courses[course].append(name)

for course, students in courses.items():
    print(f"{course}: {len(students)}")
    for student in students:
        print(f"-- {student}")
