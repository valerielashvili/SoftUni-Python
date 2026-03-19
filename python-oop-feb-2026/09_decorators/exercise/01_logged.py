def logged(function):
    def wrapper(*args):
        return (f"you called {function.__name__}{str(args)}\n"
                f"it returned {function(*args)}")

    return wrapper


# Test code
@logged
def func(*args):
    return 3 + len(args)
print(func(4, 4, 4))
