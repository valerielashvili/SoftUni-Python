input_line = input()
students = {}

while ':' in input_line:
    name, sid, course = input_line.split(':')
    if course not in students:
        students.update({course: {}})
    students[course].update({name: sid})

    input_line = input()

filter_course = input_line.replace('_', ' ')
for course, student in students.items():
    for name, sid in student.items():
        if filter_course == course:
            print(f"{name} - {sid}")
