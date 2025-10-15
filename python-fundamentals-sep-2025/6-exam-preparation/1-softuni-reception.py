wrkr_a = int(input())
wrkr_b = int(input())
wrkr_c = int(input())
students_count = int(input())

wrkr_efficiency = wrkr_a + wrkr_b + wrkr_c
processed_students = 0
total_hours = 0

while processed_students < students_count:
    total_hours += 1
    if total_hours % 4 == 0:
        # Break hour — not working with students
        continue
    processed_students += wrkr_efficiency

print(f"Time needed: {total_hours}h.")
