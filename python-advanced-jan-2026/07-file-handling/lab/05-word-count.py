words_file = open('words.txt')
words = []
words_stats = {}

for word in words_file.readline().split():
    words.append(word.strip())

words_file.close()

input_file = open('input.txt')
input_file_lines = input_file.readlines()

for word in words:
    for line in input_file_lines:
        word_lower, line_lower = word.lower(), line.lower()
        if word_lower in line_lower:
            if word not in words_stats:
                words_stats[word] = 0
            words_stats[word] += 1

sorted_words = dict(sorted(words_stats.items(), key=lambda item: item[1], reverse=True))

output_file = open('output.txt', 'w')

for word, count in sorted_words.items():
    output_file.write(f'{word} - {count}\n')

output_file.close()
