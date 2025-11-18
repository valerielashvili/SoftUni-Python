import re

text = input()
mirror_regex = re.compile(r'([@#])(?P<first>[A-Za-z]{3,})\1{2}(?P<second>[A-Za-z]{3,})\1')
word_pairs_cnt = len(mirror_regex.findall(text))
mirror_words = {}

for pair in mirror_regex.finditer(text):
    if pair:
        first = pair.group('first')
        second = pair.group('second')

        if first == second[::-1]:
            if first not in mirror_words:
                mirror_words[first] = second

result = ''
if word_pairs_cnt == 0:
    result = 'No word pairs found!\n'
else:
    result = f"{word_pairs_cnt} word pairs found!\n"

if not mirror_words:
    result += 'No mirror words!'
else:
    result += 'The mirror words are:\n'
    result += ', '.join(f"{k} <=> {v}" for k,v in mirror_words.items())

print(result)
