num = int(input())

is_prime = None

for i in range(2, num):
    if num % i == 0:
        is_prime = False
        break
else:
    is_prime = True

print(is_prime)