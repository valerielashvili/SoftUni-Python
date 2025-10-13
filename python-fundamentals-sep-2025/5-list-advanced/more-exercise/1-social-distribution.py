population = [int(s) for s in input().split(', ')]
minimum_wealth = int(input())

poor_count = sum(map(lambda x: x < minimum_wealth, population))
poor = list(filter(lambda x: x < minimum_wealth, population))
wealth = list(filter(lambda x: x >= minimum_wealth, population))

for i in range(len(poor)):
    wealthiest = max(wealth)
    wealthiest_index = wealth.index(wealthiest)
    wealth_needed = minimum_wealth - poor[i]

    if wealth[wealthiest_index] - wealth_needed >= minimum_wealth:
        poor[i] += wealth_needed
        wealth[wealthiest_index] -= wealth_needed

if any(x < minimum_wealth for x in poor):
    print("No equal distribution possible")
else:
    print(poor + wealth)
