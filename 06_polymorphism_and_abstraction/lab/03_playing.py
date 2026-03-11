class Guitar:
    def play(self):
        return "Playing the guitar"

def start_playing(instance):
    return instance.play()

class Children:
    def play(self):
        return "Children are playing"

# Duck typing example
guitar = Guitar()
print(start_playing(guitar))

children = Children()
print(start_playing(children))
