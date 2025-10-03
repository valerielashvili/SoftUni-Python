n_lines = int(input())

positives = []
negatives = []

for i in range(n_lines):
    num = int(input())

    if num >= 0:
        positives.append(num)
    else:
        negatives.append(num)

print(positives)
print(negatives)
print(f"Count of positives: {len(positives)}\n"
      f"Sum of negatives: {sum(negatives)}")
