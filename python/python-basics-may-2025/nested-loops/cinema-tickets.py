movie_name = input()

total_standard = 0
total_student = 0
total_kids = 0
total_tickets = 0

while movie_name != 'Finish':
    total_free_places = int(input())

    standard_cnt = 0
    student_cnt = 0
    kids_cnt = 0
    current_tickets = 0

    for i in range(0, total_free_places):
        ticket_type = input()

        if ticket_type == 'standard':
            standard_cnt += 1
        elif ticket_type == 'student':
            student_cnt += 1
        elif ticket_type == 'kid':
            kids_cnt += 1
        elif ticket_type == "End":
            break

    total_standard += standard_cnt
    total_student += student_cnt
    total_kids += kids_cnt
    current_tickets = standard_cnt + student_cnt + kids_cnt
    total_tickets = total_standard + total_student + total_kids
    print(f"{movie_name} - {current_tickets / total_free_places * 100:.2f}% full.")

    movie_name = input()

print(f"Total tickets: {total_tickets}\n"
      f"{total_student / total_tickets * 100:.2f}% student tickets.\n"
      f"{total_standard / total_tickets * 100:.2f}% standard tickets.\n"
      f"{total_kids / total_tickets * 100:.2f}% kids tickets.\n")