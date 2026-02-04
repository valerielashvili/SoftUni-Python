OPS = {
    '/': lambda a, b: a / b,
    '*': lambda a, b: a * b,
    '-': lambda a, b: b - a,
    '+': lambda a, b: a + b,
    '^': lambda a, b: a ** b
}

def calculate(num1, num2, op):
    print(f"{OPS[op](num1, num2):.2f}")
