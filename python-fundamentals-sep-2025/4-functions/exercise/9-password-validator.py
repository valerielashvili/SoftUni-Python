password = input()

def validate_length(secret):
    if 6 <= len(secret) <= 10:
        return True
    else:
        return False

def validate_chars(secret):
    for c in secret:
        if 48 <= ord(c) <= 57:
            continue
        elif 65 <= ord(c) <= 90:
            continue
        elif 97 <= ord(c) <= 122:
            continue
        else:
            return False

    return True

def validate_digits(secrets):
    digits_count = 0
    for c in secrets:
        if 48 <= ord(c) <= 57:
            digits_count += 1
            if digits_count == 2:
                return True

    return False

valid_length = validate_length(password)
valid_chars = validate_chars(password)
valid_digits = validate_digits(password)

if valid_length and valid_chars and valid_digits:
    print("Password is valid")
else:
    if not valid_length:
        print("Password must be between 6 and 10 characters")
    if not valid_chars:
        print("Password must consist only of letters and digits")
    if not valid_digits:
        print("Password must have at least 2 digits")
