from functools import singledispatch

token = input()
argument = input()

if token == 'int':
    argument = int(argument)
elif token == 'real':
    argument = float(argument)
elif token == 'string':
    pass

@singledispatch
def solve(arg):
    return arg

@solve.register
def _(arg: int):
    return arg * 2

@solve.register
def _(arg: float):
    return f"{arg * 1.5:.2f}"

@solve.register
def _(arg: str):
    arg = "$" + arg + "$"
    return arg

result = solve(argument)
print(result)
