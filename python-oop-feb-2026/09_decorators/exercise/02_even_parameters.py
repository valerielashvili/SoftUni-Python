def even_parameters(func):
    def wrapper(*args):
        if all(isinstance(n, int) and n % 2 == 0 for n in args):
            return func(*args)
        else:
            return "Please use only even numbers!"
    return wrapper


# Test code
@even_parameters
def add(a, b):
    return a + b

print(add(2, 4))
print(add("Peter", 1))
