class PasswordTooShortError(Exception):
    """This is a custom exception for too short passwords."""
    pass


class PasswordTooCommonError(Exception):
    """This is a custom exception for lack of special characters' combination."""
    pass


class PasswordNoSpecialCharactersError(Exception):
    """This is a custom exception for lack of at least 1 special char."""
    pass


class PasswordContainsSpacesError(Exception):
    """This is a custom exception for empty spaces in the password."""
    pass


special_chars = ('@', '*', '&', '%')

while (password := input()) != 'Done':
    if len(password) < 8:
        raise PasswordTooShortError('Password must contain at least 8 characters')
    elif password.isnumeric() or password.isalpha() or all(s in password for s in special_chars):
        raise PasswordTooCommonError('Password must be a combination of digits, letters, and special characters')
    elif not any(s in password for s in special_chars):
        raise PasswordNoSpecialCharactersError('Password must contain at least 1 special character')
    elif ' ' in password:
        raise PasswordContainsSpacesError('Password must not contain empty spaces')

    print('Password is valid')
