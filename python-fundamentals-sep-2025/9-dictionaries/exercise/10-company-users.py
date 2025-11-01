company_employees = {}

while (input_line := input()) != 'End':
    company, employee = input_line.split(' -> ')

    if company not in company_employees:
        company_employees[company] = [employee]

    if employee not in company_employees[company]:
        company_employees[company].append(employee)

for c, empl in company_employees.items():
    print(f"{c}")
    for e in empl:
        print(f"-- {e}")
