n_lines = int(input())
longest = []

for _ in range(n_lines):
    first_start, first_end, second_start, second_end = [
        int(x) for n in input().split('-') for x in n.split(',')
    ]

    first_collection, second_collection = set(), set()
    for n in range(first_start, first_end + 1):
        first_collection.add(n)

    for n in range(second_start, second_end + 1):
        second_collection.add(n)

    intersection = list(first_collection & second_collection)
    if len(intersection) > len(longest):
        longest = intersection

print(f"Longest intersection is [{', '.join(map(str, longest))}] with length {len(longest)}")
