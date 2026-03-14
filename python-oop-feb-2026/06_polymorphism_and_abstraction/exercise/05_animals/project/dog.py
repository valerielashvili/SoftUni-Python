from project.animal import Animal


class Dog(Animal):
    SOUND = "Woof!"

    def make_sound(self):
        return self.__class__.SOUND

    def __repr__(self):
        return (f"This is {self.name}. "
                f"{self.name} is a {self.age} year old {self.gender} {self.__class__.__name__}")
