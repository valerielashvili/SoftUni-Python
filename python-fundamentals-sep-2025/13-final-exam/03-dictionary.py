definitions = input().split(' | ')
test_words = input().split(' | ')
cmd = input()
notebook = {}

for entry in definitions:
    word, definition = entry.split(': ')
    if word not in notebook:
        notebook[word] = [definition]
    else:
        notebook[word].append(definition)

if cmd == 'Test':
    for test_word in test_words:
        if test_word in notebook:
            print(f"{test_word}:")
            for definition in notebook[test_word]:
                print(f" -{definition}")

elif cmd == 'Hand Over':
    print(' '.join(notebook.keys()))
