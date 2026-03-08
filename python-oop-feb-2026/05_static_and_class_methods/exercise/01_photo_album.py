class PhotoAlbum:
    def __init__(self, pages: int):
        self.pages = pages
        self.photos = []
        for row in range(pages):
            self.photos.append([])

    @classmethod
    def from_photos_count(cls, photos_count: int):
        num_pages = photos_count // 4 + photos_count % 4
        return cls(num_pages)

    def add_photo(self, label: str):
        for i, r in enumerate(self.photos):
            if len(r) < 4:
                r.append(label)
                return f"{label} photo added successfully on page {i + 1} slot {len(r)}"
        return "No more free slots"

    def display(self):
        output = ""
        for r in self.photos:
            output += (f"-----------\n"
                       f"{'[] ' * len(r)}".rstrip() + "\n")
            if len(r) == 0:
                output += "\n"
        output += "-----------"
        return output


# Test code
album = PhotoAlbum(2)

print(album.add_photo("baby"))
print(album.add_photo("first grade"))
print(album.add_photo("eight grade"))
print(album.add_photo("party with friends"))
print(album.photos)
print(album.add_photo("prom"))
print(album.add_photo("wedding"))

print(album.display())
