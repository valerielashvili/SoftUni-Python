num_as_str = input()

def odd_even_sum(num_str):
    even_sum, odd_sum = 0, 0

    for n in num_str:
        n = int(n)

        if n % 2 == 0:
            even_sum += n
        elif n % 2 == 1:
            odd_sum += n

    return f"Odd sum = {odd_sum}, Even sum = {even_sum}"

result = odd_even_sum(num_as_str)
print(result)
