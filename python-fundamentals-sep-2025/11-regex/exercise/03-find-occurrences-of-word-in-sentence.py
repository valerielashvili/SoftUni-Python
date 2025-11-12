import re

string = input()
word = input()
matches = re.findall(f"\\b{word}\\b", string, flags=re.IGNORECASE)
print(len(matches))
