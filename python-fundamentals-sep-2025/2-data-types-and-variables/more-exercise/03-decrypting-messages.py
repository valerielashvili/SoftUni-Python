key = int(input())
n_lines = int(input())

message = ""

for i in range(n_lines):
    char = input()
    message += chr(ord(char) + key)

print(message)