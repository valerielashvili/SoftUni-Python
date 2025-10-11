numbers = [int(x) for x in input().split(', ')]
group = 10


while len(numbers) != 0:
    filtered = list(filter(lambda n: n <= group, numbers))

    for num in numbers[:]:
        if num <= group:
            numbers.remove(num)

    print(f"Group of {group}'s: {filtered}")
    group += 10
