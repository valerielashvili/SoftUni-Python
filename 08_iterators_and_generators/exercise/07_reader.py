def read_next(*args):
    for sequence in args:
        sequence = list(sequence)
        while sequence:
            yield sequence.pop(0)


# Test code
for item in read_next("string", (2,), {"d": 1, "i": 2, "c": 3, "t": 4}):
    print(item, end='')
