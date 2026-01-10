text = input()
stack = []

for i in range(len(text)):
    if text[i] == "(" or text[i] == "[" or text[i] == "{":
        stack.append(text[i])
    elif text[i] == ")" or text[i] == "]" or text[i] == "}":
        stack.append(text[i])

    if stack[-2:] == ['(', ')'] or stack[-2:] == ['[', ']'] or stack[-2:] == ['{', '}']:
        stack.pop(), stack.pop()

if len(stack) == 0:
    print('YES')
else:
    print('NO')
