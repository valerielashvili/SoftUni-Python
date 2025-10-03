char_first = input()
char_second = input()

def chars_in_range(c_first, c_second):
    char_string = ""

    for c in range(ord(c_first) + 1, ord(c_second)):
        char_string += chr(c) + ' '

    char_string = char_string.rstrip()
    return char_string

characters_str = chars_in_range(char_first, char_second)
print(characters_str)
