# Strange judge test requirement to have snake_case class name
class vowels:
    VOWELS = ['a', 'e', 'i', 'o', 'u', 'y']

    def __init__(self, string: str):
        self.string = string
        self.i = -1

    def __iter__(self):
        return self

    def __next__(self):
        self.i += 1
        if self.i >= len(self.string):
            raise StopIteration
        if self.string[self.i].lower() in vowels.VOWELS:
            return self.string[self.i]
        else:
            return self.__next__()


# Test code
my_string = vowels('Abcedifuty0o')
for char in my_string:
    print(char)
