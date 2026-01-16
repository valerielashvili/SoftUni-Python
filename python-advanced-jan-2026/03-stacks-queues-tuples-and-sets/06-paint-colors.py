from collections import deque

substrings = deque(input().split())

primary = {"red", "yellow", "blue"}
secondary = {
    "orange": {"red", "yellow"},
    "purple": {"red", "blue"},
    "green": {"yellow", "blue"}
}

found_colors = []

while substrings:
    if len(substrings) == 1:
        word = substrings.pop()
        if word in primary or word in secondary:
            found_colors.append(word)
        break

    left = substrings.popleft()
    right = substrings.pop()

    combined = left + right
    reversed_combined = right + left

    if combined in primary or combined in secondary:
        found_colors.append(combined)
    elif reversed_combined in primary or reversed_combined in secondary:
        found_colors.append(reversed_combined)
    else:
        left = left[:-1]
        right = right[:-1]

        mid = len(substrings) // 2
        if left:
            substrings.insert(mid, left)
        if right:
            substrings.insert(mid, right)

result = []
for color in found_colors:
    if color in secondary:
        if secondary[color].issubset(found_colors):
            result.append(color)
    else:
        result.append(color)

print(result)
