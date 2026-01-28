def sum_positives(positives):
    return sum(n for n in positives if n > 0)


def sum_negatives(negatives):
    return sum(n for n in negatives if n < 0)


numbers = [int(n) for n in input().split()]
sum_of_positives = sum_positives(numbers)
sum_of_negatives = sum_negatives(numbers)

print(sum_of_negatives)
print(sum_of_positives)

if abs(sum_of_negatives) > sum_of_positives:
    print(f'The negatives are stronger than the positives')
else:
    print(f'The positives are stronger than the negatives')
