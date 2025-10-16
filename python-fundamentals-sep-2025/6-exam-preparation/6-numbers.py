from itertools import islice

numbers = [int(x) for x in input().split()]
average = sum(numbers) / len(numbers)
top_five = list(islice(sorted(filter(lambda n: n > average, numbers), reverse=True), 5))

if top_five:
    print(" ".join(str(e) for e in top_five))
else:
    print("No")
