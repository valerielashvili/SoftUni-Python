input_line = input()
students = {}

while ':' in input_line:
    name, sid, course = input_line.split(':')
    students.update({name: [sid, course]})

    input_line = input()

filter_course = input_line.replace('_', ' ')
for student, info in students.items():
    if filter_course in info:
        print(f"{student} - {info[0]}")
