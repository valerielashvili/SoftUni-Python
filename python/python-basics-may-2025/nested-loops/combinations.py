n = int(input())
num_combinations = 0

for i in range(0, n + 1):
    for j in range(0, n + 1):
        for k in range(0, n + 1):
            if i + j + k == n:
                num_combinations += 1

print(num_combinations)