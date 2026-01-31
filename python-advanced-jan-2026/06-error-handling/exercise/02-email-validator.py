class NameTooShortError(Exception):
    """This is a custom exception for to short names error."""
    pass


class MustContainAtSymbolError(Exception):
    """This is a custom exception for lack of the '@' symbol."""
    pass


class InvalidDomainError(Exception):
    """This is a custom exception for an invalid domain error."""
    pass


domains = ('.com', '.bg', '.org', '.net')

while (email := input()) != "End":
    if '@' not in email:
        raise MustContainAtSymbolError('Email must contain @')
    elif len(email[:email.index('@')]) <= 4:
        raise NameTooShortError('Name must be more than 4 characters')
    elif email[email.index('.'):] not in domains:
        raise InvalidDomainError('Domain must be one of the following: .com, .bg, .org, .net')

    print('Email is valid')
