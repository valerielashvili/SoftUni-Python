string_of_ints = input().split(', ')
beggars = int(input())

all_offers = [int(x) for x in string_of_ints]
beggars_offers = [0] * beggars

while len(all_offers) != 0:
    for i in range(len(all_offers)):
        beggars_offers[i] += all_offers[i]

        if i == len(beggars_offers) - 1:
            break

        if len(all_offers) == 1:
            break

    del all_offers[0:beggars]

print(beggars_offers)
