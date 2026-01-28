import operator


def operate(op, *args):
    result = args[0]
    for num in args[1:]:
        result = OPERATIONS[op](result, num)
    return result

OPERATIONS = {
    '+': operator.add,
    '-': operator.sub,
    '*': operator.mul,
    '/': operator.truediv,
}

print(operate("+", 1, 2, 3))
