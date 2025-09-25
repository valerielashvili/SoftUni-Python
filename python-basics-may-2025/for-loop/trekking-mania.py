num_groups = int(input())

total_clmbrs = 0
mousala_clmbrs = 0
monblanc_clmbrs = 0
kilimandzharo_clmbrs = 0
k2_clmbrs = 0
everest_clmbrs = 0

for i in range(0, num_groups):
    num_alpinists = int(input())

    total_clmbrs += num_alpinists

    if num_alpinists <= 5:
        mousala_clmbrs += num_alpinists
    elif 6 <= num_alpinists <= 12:
        monblanc_clmbrs += num_alpinists
    elif 13 <= num_alpinists <= 25:
        kilimandzharo_clmbrs += num_alpinists
    elif 26 <= num_alpinists <= 40:
        k2_clmbrs += num_alpinists
    elif num_alpinists >= 41:
        everest_clmbrs += num_alpinists

for i in mousala_clmbrs, monblanc_clmbrs, kilimandzharo_clmbrs, k2_clmbrs, everest_clmbrs:
    print(f"{i / total_clmbrs * 100:.2f}%")
