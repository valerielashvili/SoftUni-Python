num_pages = int(input())
pages_per_hour = int(input())
days = int(input())

num_reading_hours = int((num_pages / pages_per_hour) / days)

print(num_reading_hours)
