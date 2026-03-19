def number_increment(numbers):
    def increase():
        for i in range(len(numbers)):
            numbers[i] += 1
        return numbers
    
    return increase()


# Test code
print(number_increment([1, 2, 3]))
