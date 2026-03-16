# Judge test requirement to have a snake_case class name
class dictionary_iter:
    def __init__(self, dictionary: dict):
        self.items = list(dictionary.items())

    def __iter__(self):
        return self

    def __next__(self):
        if not self.items:
            raise StopIteration
        return self.items.pop(0)


# Test code
result = dictionary_iter({"name": "Peter", "age": 24})
for x in result:
    print(x)
