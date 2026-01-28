def sum_numbers(num1, num2):
    return num1 + num2


def multiply_numbers(num1, num2):
    return num1 * num2


def func_executor(*args):
    results = []
    for func in args:
        result = f'{func[0].__name__} - {func[0](*func[1])}'
        results.append(result)
    return '\n'.join(results) if results else None


print(func_executor(
    (sum_numbers, (1, 2)),
    (multiply_numbers, (2, 4))
))
