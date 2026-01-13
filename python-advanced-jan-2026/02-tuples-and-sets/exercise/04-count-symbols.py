text = [t for t in input()]
unique_chars = set({s for s in text})

for char in sorted(unique_chars):
    print(f"{char}: {text.count(char)} time/s")
