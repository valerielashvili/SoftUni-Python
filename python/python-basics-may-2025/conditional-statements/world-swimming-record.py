from math import floor

world_record = float(input())
distance_m = float(input())
seconds_per_meter = float(input())

contest_result = seconds_per_meter * distance_m
slow_down_sec = floor((distance_m / 15)) * 12.5
result = contest_result + slow_down_sec

if result < world_record:
    print(f"Yes, he succeeded! The new world record is {result:.2f} seconds.")
else:
    secs_behind = result - world_record
    print(f"No, he failed! He was {secs_behind:.2f} seconds slower.")
