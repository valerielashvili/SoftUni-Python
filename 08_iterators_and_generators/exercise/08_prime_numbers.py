def get_primes(numbers: list):
    numbers = [x for x in numbers if x > 1 ]

    for n in numbers:
        for i in range(2, n):
            if n % i == 0:
                break
        else:
            yield n


# Test code
print(list(get_primes([2, 4, 3, 5, 6, 9, 1, 0])))
