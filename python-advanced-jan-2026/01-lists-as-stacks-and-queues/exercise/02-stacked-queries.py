n_lines = int(input())
stack = []

for n in range(n_lines):
    tokens = input().split()
    cmd, num = tokens[0], 0

    if cmd == '1':
        num = int(tokens[1])
        stack.append(num)

    if len(stack):
        if cmd == '2':
            stack.pop()
        elif cmd == '3':
            print(max(stack))
        elif cmd == '4':
            print(min(stack))

print(', '.join(str(item) for item in stack[::-1]))
