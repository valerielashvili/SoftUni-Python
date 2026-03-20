def make_bold(func):
    def wrap(*args):
        return f"<b>{func(*args)}</b>"
    return wrap


def make_italic(func):
    def wrap(*args):
        return f"<i>{func(*args)}</i>"
    return wrap


def make_underline(func):
    def wrap(*args):
        return f"<u>{func(*args)}</u>"
    return wrap


# Test code
@make_bold
@make_italic
@make_underline
def greet(name):
    return f"Hello, {name}"

print(greet("Peter"))

@make_bold
@make_italic
@make_underline
def greet_all(*args):
    return f"Hello, {', '.join(args)}"

print(greet_all("Peter", "George"))
