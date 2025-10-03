card_deck = input().split()
faro_shuffles = int(input())

split_index = int(len(card_deck) // 2)

for shuffle in range(faro_shuffles):
    left_deck = card_deck[:split_index]
    right_deck = card_deck[split_index:]
    card_deck = []
    
    for i in range(len(left_deck)):
        card_deck.append(left_deck[i])
        card_deck.append(right_deck[i])

print(card_deck)
