import re

string = input()
matches = re.findall(r'(?<=\b_)[A-Za-z0-9]+\b', string)
print(','.join(matches))
