input_line = input().split()
words = {}

for word in input_line:
    word_lower = word.lower()

    if word_lower not in words:
        words[word_lower] = 0
    words[word_lower] += 1

for k, v in words.items():
    if v % 2 != 0:
        print(k, end=' ')
