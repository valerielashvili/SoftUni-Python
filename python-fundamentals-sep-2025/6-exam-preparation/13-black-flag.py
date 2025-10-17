days_of_pirating = int(input())
daily_plunder = int(input())
target_plunder = float(input())
total_plunder = 0

for day in range(1, days_of_pirating + 1):
    total_plunder += daily_plunder

    if day % 3 == 0:
        total_plunder += daily_plunder * 0.5
    if day % 5 == 0:
        total_plunder -= total_plunder * 0.3

if total_plunder >= target_plunder:
    print(f"Ahoy! {total_plunder:.2f} plunder gained.")
elif total_plunder < target_plunder:
    percentage = total_plunder / target_plunder * 100
    print(f"Collected only {percentage:.2f}% of the plunder.")
