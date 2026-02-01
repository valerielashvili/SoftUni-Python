import os


ABSOLUTE_PATH = os.path.abspath(__file__)
DIR_PATH = os.path.dirname(ABSOLUTE_PATH)
TEXT_FILE = os.path.join(DIR_PATH, 'text.txt')

content = open(TEXT_FILE).readlines()
reversed_lines = []

for i, line in enumerate(content):
    if i % 2 == 0:
        for c in ('-', ',', '.', '!', '?'):
            line = line.replace(c, '@')

        split_line = line.split()
        joined_line = ''

        while split_line:
            joined_line += split_line.pop() + ' '

        joined_line = joined_line.strip()
        reversed_lines.append(joined_line)


print('\n'.join(reversed_lines))
