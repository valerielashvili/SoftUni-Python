number = int(input())

def solve_tribonacci(num):
    sequence = [1]
    for i in range(1, num):
        if len(sequence) < 3:
            sequence.append(i)
        else:
            sequence.append(sum(sequence[-3:]))
    return sequence

tribonacci_seq = solve_tribonacci(number)
print(*tribonacci_seq)
