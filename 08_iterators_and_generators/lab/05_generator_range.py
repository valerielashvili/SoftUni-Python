from typing import Iterator


def genrange(start: int, end: int) -> Iterator[int]:
    while start <= end:
        yield start
        start += 1


# Test code
print(list(genrange(1, 10)))