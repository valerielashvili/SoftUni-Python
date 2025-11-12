import re

string = input()
pattern = r'\b(?<![_.-])[a-z0-9]+[_.-]?[a-z0-9]+@(?:[a-z-]+\.)+[a-z]{2,}\b'
for email in re.findall(pattern, string):
    print(email)
