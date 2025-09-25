from pyexpat.errors import messages

exam_hour = int(input())
exam_minute = int(input())
hour_of_arrival = int(input())
minute_of_arrival = int(input())

total_exam_mins = exam_hour * 60 + exam_minute
total_mins_of_arrival = hour_of_arrival * 60 + minute_of_arrival

difference = 0
hh = 0
mm = 0
status = ""
message = ""

if total_exam_mins == total_mins_of_arrival:
    status = "On time"
elif total_exam_mins > total_mins_of_arrival:
    difference = total_exam_mins - total_mins_of_arrival
    hh = difference // 60
    mm = difference % 60

    if difference <= 30:
        status = "On time"
        message = "minutes before the start"
    elif 30 < difference < 60:
        status = "Early"
        message = "minutes before the start"
    elif difference >= 60:
        status = "Early"
        message = "hours before the start"

elif total_mins_of_arrival > total_exam_mins:
    difference = total_mins_of_arrival - total_exam_mins
    hh = difference // 60
    mm = difference % 60

    if difference < 60:
        status = "Late"
        message = "minutes after the start"
    elif difference >= 60:
        status = "Late"
        message = "hours after the start"

if hh == 0:
    print(f"{status}\n"
          f"{mm} {message}")
else:
    print(f"{status}\n"
          f"{hh}:{mm:02d} {message}")
