import re

emoji_regex = re.compile(r'(:{2}|\*{2})(?P<emoji>[A-Z][a-z]{2,})\1')
text = input()
emojis_num = 0
cool_emojis = []

digits = re.findall(r'\d', text)
cool_threshold = int(digits[0])
for digit in digits[1:]:
    cool_threshold *= int(digit)

for emoji in emoji_regex.finditer(text):
    emojis_num += 1
    if sum(ord(e) for e in emoji.group('emoji')) > cool_threshold:
        cool_emojis.append(emoji.group(0))

output = f"Cool threshold: {cool_threshold}\n" + \
         f"{emojis_num} emojis found in the text. The cool ones are:\n" + \
         "\n".join(cool_emojis)

print(output)
