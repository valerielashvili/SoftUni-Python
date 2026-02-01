import os, string


ABSOLUTE_PATH = os.path.abspath(__file__)
DIR_PATH = os.path.dirname(ABSOLUTE_PATH)
TEXT_FILE_PATH = os.path.join(DIR_PATH, 'text.txt')
OUTPUT_FILE = os.path.join(DIR_PATH, 'output.txt')

content = open(TEXT_FILE_PATH).readlines()
output = ''

for line in content:
    letter_count = sum(1 for char in line if char.isalpha())
    punctuation_count = sum(1 for char in line if char in string.punctuation)
    line = line.replace('\n', '')
    output += f'{line} ({letter_count})({punctuation_count})\n'

open(OUTPUT_FILE, 'w').write(output)
