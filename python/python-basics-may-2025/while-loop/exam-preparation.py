num_low_grades_allowed = int(input())

problem_name = ""
num_low_grades = 0
total_grades = 0
num_problems_solved = 0
last_problem = ''

while num_low_grades < num_low_grades_allowed:
    problem_name = input()
    if problem_name == "Enough":
        break

    grade = int(input())
    if grade <= 4:
        num_low_grades += 1

    total_grades += grade
    num_problems_solved += 1
    last_problem = problem_name

if problem_name == "Enough":
    print(f"Average score: {total_grades / num_problems_solved:.2f}\n"
          f"Number of problems: {num_problems_solved}\n"
          f"Last problem: {last_problem}")
elif num_low_grades == num_low_grades_allowed:
    print(f"You need a break, {num_low_grades} poor grades.")