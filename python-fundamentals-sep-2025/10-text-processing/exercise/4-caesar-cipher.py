text = input()
encrypted_text = ''

for c in text:
    encrypted_text += chr(ord(c) + 3)

print(encrypted_text)
