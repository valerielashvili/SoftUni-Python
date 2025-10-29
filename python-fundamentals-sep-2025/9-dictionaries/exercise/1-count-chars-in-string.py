words = input().split()
chars = {}

for word in words:
    for c in word:
        if c not in chars:
            chars[c] = 1
        else:
            chars[c] += 1

for char, occurrence in chars.items():
    print(f"{char} -> {occurrence}")
