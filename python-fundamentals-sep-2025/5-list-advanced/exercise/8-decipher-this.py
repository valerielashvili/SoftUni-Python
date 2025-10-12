secret_messages = input().split()
deciphered_message = ''

for message in secret_messages:
    char_code = ''.join(filter(lambda c: c.isdigit(), message))
    message = message.replace(char_code, '', 1)
    first_letter = chr(int(char_code))
    last_letter = message[0]

    if len(message) > 1:
        second_letter = message[-1]
        middle_letters = message[1:-1]
        new_word = first_letter + second_letter + middle_letters + last_letter
    else:
        new_word = first_letter + last_letter

    deciphered_message += new_word + ' '

print(deciphered_message.strip())
