def create_sequence(cnt):
    fibonacci_seq = [0, 1]
    for i in range(cnt - 2):
        fibonacci_seq.append(fibonacci_seq[-1] + fibonacci_seq[-2])
    return fibonacci_seq


def locate_number(num, sequence):
    if num in sequence:
        return f'The number - {num} is at index {sequence.index(num)}'
    else:
        return f'The number {num} is not in the sequence'
