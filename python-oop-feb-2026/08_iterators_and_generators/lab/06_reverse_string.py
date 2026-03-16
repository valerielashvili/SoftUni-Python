from typing import Iterator


def reverse_text(string: str) -> Iterator[str]:
    i = len(string) - 1
    while i >= 0:
        yield string[i]
        i -= 1


# Test code
for char in reverse_text("step"):
    print(char, end='')
