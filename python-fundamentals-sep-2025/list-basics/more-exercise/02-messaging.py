numbers = input().split()
text = input()
message = ''

for number in numbers:
    index = 0

    for d in number:
        index += int(d)
    
    while index >= len(text):
        index -= len(text)
    
    message += text[index]
    text = text.replace(text[index], '', 1)

print(message)
