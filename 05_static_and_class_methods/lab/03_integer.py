class Integer:
    def __init__(self, value: int):
        self.value = value

    @classmethod
    def from_float(cls, float_value):
        if isinstance(float_value, float):
            return cls(int(float_value))
        return "value is not a float"

    @classmethod
    def from_roman(cls, value):
        roman_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        total = 0
        prev_num = 0

        for char in reversed(value):
            num = roman_map[char]
            if num < prev_num:
                total -= num
            else:
                total += num
            prev_num = num

        return cls(total)

    @classmethod
    def from_string(cls, value):
        if isinstance(value, str):
            return cls(int(value))
        return "wrong type"


# Test code
first_num = Integer(10)
print(first_num.value)

second_num = Integer.from_roman("IX")
print(second_num.value)

print(Integer.from_float("2.6"))
print(Integer.from_string(2.6))
