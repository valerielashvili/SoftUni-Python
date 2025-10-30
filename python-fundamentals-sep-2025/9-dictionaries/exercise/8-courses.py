courses = {}
input_line = input()

while input_line != 'end':
    course, name = input_line.split(' : ')
    if course not in courses:
        courses[course] = [name]
    else:
        courses[course].append(name)

    input_line = input()

for course, students in courses.items():
    print(f"{course}: {len(students)}")
    for student in students:
        print(f"-- {student}")
