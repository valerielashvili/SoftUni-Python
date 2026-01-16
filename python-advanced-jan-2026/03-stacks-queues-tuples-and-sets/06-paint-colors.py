from collections import deque

color_substr = deque(input().split())
valid_colors = ['red', 'yellow', 'blue']
secondary_colors = ['orange', 'purple', 'green']
found_colors = []

while color_substr:
    if len(color_substr) > 1:
        left_substr = color_substr.popleft()
        right_substr = color_substr.pop()
        test_color = left_substr + '' + right_substr
    else:
        test_color = color_substr.pop()

    if test_color in valid_colors:
        found_colors.append(test_color)
        
    elif test_color in secondary_colors:

        if (test_color == 'orange' and
            ('red' in found_colors and 'yellow' in found_colors)):
            found_colors.append(test_color)

        elif (test_color == 'purple' and
              ('red' in found_colors and 'blue' in found_colors)):
            found_colors.append(test_color)
        
        elif (test_color == 'green' and
              ('yellow' in found_colors and 'blue' in found_colors)):
            found_colors.append(test_color)
    else:
        idx = len(color_substr) // 2
        if len(color_substr) % 2 != 0:
            idx += 1
        
        if left_substr[:-1]:
            color_substr.insert(idx, left_substr[:-1])
        if right_substr[:-1]:
            color_substr.insert(idx + 1, right_substr[:-1])

print(*found_colors)
