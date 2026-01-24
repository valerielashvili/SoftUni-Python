numbers = [[n for n in l.split(' ') if n != ''] for l in input().split('|')]
flattened = [n for l in numbers[::-1] for n in l]

print(*flattened, end=' ')
