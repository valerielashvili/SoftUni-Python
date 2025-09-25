from math import ceil

series_name = input()
episode_duration_min = int(input())
lunch_break_min = int(input())

time_for_lunch = lunch_break_min / 8
time_for_rest = lunch_break_min / 4
time_left = lunch_break_min - time_for_lunch - time_for_rest

if time_left >= episode_duration_min:
    extra_time = time_left - episode_duration_min
    print(f"You have enough time to watch {series_name} and left with {ceil(extra_time)} minutes free time.")
else:
    time_needed = episode_duration_min - time_left
    print(f"You don't have enough time to watch {series_name}, you need {ceil(time_needed)} more minutes.")
