queue = int(input())
lift = [int(x) for x in input().split()]
output = ''

while queue != 0:
    if all(x == 4 for x in lift):
        print(f"There isn't enough space! {queue} people in a queue!\n" +
              " ".join(str(w) for w in lift))
        break

    for i in range(len(lift)):
        diff = 4 - lift[i]

        if queue >= diff:
            lift[i] += diff
            queue -= diff
        elif queue < diff:
            lift[i] += queue
            queue -= queue
else:
    if any(x < 4 for x in lift):
        print('The lift has empty spots!\n' +
              ' '.join(str(w) for w in lift))

    elif all(x == 4 for x in lift):
        print(' '.join(str(w) for w in lift))
