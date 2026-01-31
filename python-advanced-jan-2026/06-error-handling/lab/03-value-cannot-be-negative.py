class ValueCannotBeNegative(Exception):
    """This is a custom exception for negative numbers error handling."""
    pass

for i in range(5):
    x = int(input())
    if x < 0:
        raise ValueCannotBeNegative()
