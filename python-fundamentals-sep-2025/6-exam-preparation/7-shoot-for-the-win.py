targets = [int(x) for x in input().split()]
token = input()
shot_cnt = 0

while token != 'End':
    if token.isdigit():
        idx = int(token)

    if 0 <= idx < len(targets) and targets[idx] != -1:
        shot_target = targets[idx]
        targets[idx] = -1
        shot_cnt += 1

        targets = [
            t - shot_target if t != -1 and t > shot_target else
            t + shot_target if t != -1 and t <= shot_target else
            t for t in targets
            ]

    token = input()

print(f"Shot targets: {shot_cnt} -> " + " ".join(str(e) for e in targets))
