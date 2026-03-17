from itertools import permutations


def possible_permutations(collection: list):
    result = permutations(collection)
    for permutation in result:
        yield list(permutation)


# Test code
[print(n) for n in possible_permutations([1, 2, 3])]
