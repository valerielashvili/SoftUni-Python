# Strange judge test requirement to have snake_case class name
class reverse_iter:
    def __init__(self, iterable: list):
        self.iterator = iterable
        self.i = len(iterable)

    def __iter__(self):
        return self

    def __next__(self):
        self.i -= 1
        if self.i >= 0:
            return self.iterator[self.i]
        else:
            raise StopIteration


# Test code
reversed_list = reverse_iter([1, 2, 3, 4])
for item in reversed_list:
    print(item)
