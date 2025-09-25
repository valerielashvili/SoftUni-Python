num_snowballs = int(input())

snowball_weight = 0
snowball_time = 0
snowball_quality = 0
snowball_value = 0

for i in range(num_snowballs):
    weight = int(input())
    time = int(input())
    quality = int(input())

    value = (weight / time) ** quality

    if value > snowball_value:
        snowball_value = int(value)
        snowball_weight = weight
        snowball_time = time
        snowball_quality = quality

print(f"{snowball_weight} : {snowball_time} = {snowball_value} ({snowball_quality})")