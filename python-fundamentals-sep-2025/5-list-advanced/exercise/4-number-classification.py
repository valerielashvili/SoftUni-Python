numbers = [int(x) for x in input().split(', ')]

positives = ", ".join(map(str, [n for n in numbers if n >= 0]))
negatives = ", ".join(map(str, [n for n in numbers if n < 0]))
evens = ", ".join(map(str, [n for n in numbers if n % 2 == 0]))
odds = ", ".join(map(str, [n for n in numbers if n % 2 != 0]))

print(f"Positive: {positives}\n"
      f"Negative: {negatives}\n"
      f"Even: {evens}\n"
      f"Odd: {odds}")
