def multiply(*args):
    result = args[0]
    for x in args[1:]:
        result *= x
    return result


print(multiply(1, 4, 5))
