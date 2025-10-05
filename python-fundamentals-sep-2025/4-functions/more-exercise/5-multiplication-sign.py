a = int(input())
b = int(input())
c = int(input())

def multiplication_sign(d, e, f):
    zero = None
    negative_count = 0
    for n in d, e, f:
        if n == 0:
            zero = True
            break
        elif n < 0:
            negative_count += 1

    if negative_count == 1 or negative_count == 3:
        return 'negative'
    elif zero:
        return 'zero'
    else:
        return 'positive'

sign = multiplication_sign(a, b, c)
print(sign)
