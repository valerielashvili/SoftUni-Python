text = input()
for i in range(len(text) - 1):
    if text[i] == ':':
        print(f":{text[i + 1]}")
