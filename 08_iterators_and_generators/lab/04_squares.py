from typing import Iterator


def squares(num: int) -> Iterator[int]:
    i = 1
    while i <= num:
        yield i * i
        i += 1


# Test code
print(list(squares(5)))
