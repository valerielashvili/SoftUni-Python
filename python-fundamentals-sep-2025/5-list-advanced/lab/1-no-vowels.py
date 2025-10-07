text = input()
vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']
no_vowels = ''.join([x for x in text if x not in vowels])
print(no_vowels)
