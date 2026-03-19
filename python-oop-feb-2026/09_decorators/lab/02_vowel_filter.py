def vowel_filter(function):
    def wrapper():
        vowels = ["a", "e", "i", "o", "u"]
        letters = function()
        return [l for l in letters if l.lower() in vowels]

    return wrapper


# Test code
@vowel_filter
def get_letters():
    return ["a", "b", "c", "d", "e"]

print(get_letters())
