str_seq_first = input().split(', ')
str_seq_second = input().split(', ')

substrings = list(filter(lambda x: any(x in seq for seq in str_seq_second), str_seq_first))
print(substrings)
