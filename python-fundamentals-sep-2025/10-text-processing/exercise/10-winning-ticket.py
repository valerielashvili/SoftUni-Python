tickets = [t.strip() for t in input().split(', ')]
winning_chars = ['@', '#', '$', '^']

for ticket in tickets:
    if len(ticket) == 20:
        idx = int(len(ticket) / 2)
        first_half = ticket[:idx]
        second_half = ticket[idx:]
        output = ''

        for char in winning_chars:
            for match_len in range(6, 11):
                pattern = char * match_len
                if pattern in first_half and pattern in second_half:
                    output = f"ticket \"{ticket}\" - {match_len}{char}"

                if match_len == 10:
                    if pattern in first_half and pattern in second_half:
                        output = f"ticket \"{ticket}\" - {match_len}{char} Jackpot!"
        if output:
            print(output)
        else:
            print(f"ticket \"{ticket}\" - no match")
    else:
        print("invalid ticket")
