number = int(input())

def loading_bar(num):
    progress_bar = "[" + "%" * (num // 10) + "." * ((100 - num) // 10) + "]\n"
    if num < 100:
        progress_bar = f"{num}% " + progress_bar + "Still loading..."
    else:
        progress_bar = f"{num}% Complete!\n" + progress_bar.rstrip()

    return progress_bar

print(loading_bar(number))
