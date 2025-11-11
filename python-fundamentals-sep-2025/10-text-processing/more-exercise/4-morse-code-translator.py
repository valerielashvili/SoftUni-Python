MORSE_CODE_DICT = {
    'A':'.-', 'B':'-...',
    'C':'-.-.', 'D':'-..', 'E':'.',
    'F':'..-.', 'G':'--.', 'H':'....',
    'I':'..', 'J':'.---', 'K':'-.-',
    'L':'.-..', 'M':'--', 'N':'-.',
    'O':'---', 'P':'.--.', 'Q':'--.-',
    'R':'.-.', 'S':'...', 'T':'-',
    'U':'..-', 'V':'...-', 'W':'.--',
    'X':'-..-', 'Y':'-.--', 'Z':'--..'
}

deciphered = ''
message = [m for m in input().split(' | ')]

for word in message:
    morse_letters = [w for w in word.split(' ') if w != '']
    for code in morse_letters:
        key = next((key for key, val in MORSE_CODE_DICT.items() if val == code))
        deciphered += key

    deciphered += ' '

print(deciphered)
