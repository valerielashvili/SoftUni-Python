n_words = int(input()) * 2
words = {}

for i in range(0, n_words, 2):
    word, synonym = input(), input()
    if word not in words:
        words.update({word: [synonym]})
    else:
        words[word].append(synonym)

for w, s in words.items():
    print(f"{w} - " + ", ".join(s))
