# Judge test requirement to have a snake_case class name
class sequence_repeat:
    def __init__(self, sequence: str, number: int):
        self.sequence = sequence
        self.number = number
        self.i = -1

    def __iter__(self):
        return self

    def __next__(self):
        if self.i == len(self.sequence) - 1:
            self.i = -1
        if self.number <= 0:
            raise StopIteration

        self.i += 1
        self.number -= 1
        return self.sequence[self.i]


# Test code
result = sequence_repeat('abc', 5)
for item in result:
    print(item, end ='')
