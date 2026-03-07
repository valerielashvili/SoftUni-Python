from math import prod


class Calculator:
    @staticmethod
    def add(*args):
        return sum(args)

    @staticmethod
    def multiply(*args):
        return prod(args)

    @staticmethod
    def divide(*args):
        result = args[0]
        for x in args[1:]:
            result /= x
        return result

    @staticmethod
    def subtract(*args):
        result = args[0]
        for x in args[1:]:
            result -= x
        return result


# Test code
print(Calculator.add(5, 10, 4))
print(Calculator.multiply(1, 2, 3, 5))
print(Calculator.divide(100, 2))
print(Calculator.subtract(90, 20, -50, 43, 7))
