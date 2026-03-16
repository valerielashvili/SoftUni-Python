# Judge test requirement to have a snake_case class name
class take_skip:
    def __init__(self, step: int, count: int):
        self.step = step
        self.count = count
        self.i = 0 - self.step

    def __iter__(self):
        return self

    def __next__(self):
        self.i += self.step
        if self.count <= 0:
            raise StopIteration
        self.count -= 1
        return self.i


# Test code
numbers = take_skip(2, 6)
for number in numbers:
    print(number)
