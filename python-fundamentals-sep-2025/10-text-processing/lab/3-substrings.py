substr = input()
string = input()

while substr in string:
    string = string.replace(substr, '')

print(string)
