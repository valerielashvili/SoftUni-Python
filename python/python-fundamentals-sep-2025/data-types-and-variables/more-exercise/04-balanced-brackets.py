n_lines = int(input())

brackets = ""
balanced = "BALANCED"

for _ in range(n_lines):
    input_string = input()

    if input_string == '(':
        brackets += input_string
    elif input_string == ')':
        brackets += input_string

for i in range(0, len(brackets), +2):
    if brackets[i:i+2] != "()":
        balanced = "UNBALANCED"

print(balanced)