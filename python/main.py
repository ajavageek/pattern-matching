from math import pi

class Shape:
    pass


class Rectangle(Shape):
    def __init__(self, length: float, width: float):
        self.length = length
        self.width = width


class Circle(Shape):
    def __init__(self, radius: float):
        self.radius = radius


def get_perimeter(s: Shape) -> float:
    match s:
        case Rectangle(length=l, width=w) if l == w:
            print("Square detected")
            return 4 * l
        case Rectangle(length=l, width=w):
            return 2 * l + 2 * w
        case Circle(radius=r):
            return 2 * pi * r
        case _:
            raise ValueError("Unknown shape")


print(get_perimeter(Rectangle(2.0, 3.0)))
print(get_perimeter(Rectangle(2.0, 2.0)))
print(get_perimeter(Circle(3.0)))
