x = int(input())
y = int(input())
operator = input()

result = 0
num_character = ""

if operator == '+':
    result = x + y
    if result % 2 == 0:
        num_character = 'even'
    else:
        num_character = 'odd'
    print(f"{x} {operator} {y} = {result} - {num_character}")
elif operator == '-':
    result = x - y
    if result % 2 == 0:
        num_character = 'even'
    else:
        num_character = 'odd'
    print(f"{x} {operator} {y} = {result} - {num_character}")
elif operator == '*':
    result = x * y
    if result % 2 == 0:
        num_character = 'even'
    else:
        num_character = 'odd'
    print(f"{x} {operator} {y} = {result} - {num_character}")
elif operator == '/':
    if y == 0:
        print(f"Cannot divide {x} by zero")
    else:
        result = x / y
        print(f"{x} / {y} = {result:.2f}")
elif operator == '%':
    if y == 0:
        print(f"Cannot divide {x} by zero")
    else:
        result = x % y
        print(f"{x} % {y} = {result}")
