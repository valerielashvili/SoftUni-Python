import re

phone_nums = input()
pattern = r'\+359([ -])2\1\d{3}\1\d{4}\b'
matches = re.finditer(pattern, phone_nums)
print(', '.join(g.group() for g in matches))
