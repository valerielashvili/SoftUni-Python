hours = int(input())
minutes = int(input())

minutes += 15

if (minutes >= 60):
    hours += minutes // 60
    minutes = minutes % 60

if (hours >= 24):
    hours = hours % 24

print(f"{hours}:{minutes:02d}")
