deposit_amount = float(input())
deposit_term = int(input())
deposit_rate = float(input()) / 100

deposit_sum = deposit_amount + deposit_term * ((deposit_amount * deposit_rate) / 12)
print(deposit_sum)