input_str = input()
occurrences = 0

env_elements = ["sand", "water", "fish", "sun"]

for i in range(len(env_elements)):
    sbstr = env_elements[i]

    for j in range(len(input_str)):
        if input_str[j:j+len(sbstr)].lower() == sbstr:
            occurrences += 1

print(occurrences)