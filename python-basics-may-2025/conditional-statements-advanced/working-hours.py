hour = int(input())
day = input()

working_status = 'closed'

if 10 <= hour <= 18 and (day == 'Monday' or day =='Tuesday' or day =='Wednesday' or day =='Thursday' or day =='Friday'
                         or day =='Saturday'):
        working_status = 'open'

print(working_status)
