start, end = ord(input()), ord(input())
string = input()
total_sum = 0

for char in string:
    char_code = ord(char)
    if start < char_code < end:
        total_sum += char_code

print(total_sum)
