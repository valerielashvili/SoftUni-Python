from album import *


class Band:
    def __init__(self, name: str):
        self.name = name
        self.albums = []

    def add_album(self, album: Album):
        if album not in self.albums:
            self.albums.append(album)
            return f"Band {self.name} has added their newest album {album.name}."
        else:
            return f"Band {self.name} already has {album.name} in their library."

    def remove_album(self, album_name: str):
        for album in self.albums:
            if album.published:
                return "Album has been published. It cannot be removed."
            elif album.name == album_name:
                self.albums.remove(album)
                return f"Album {album_name} has been removed."

        return f"Album {album_name} is not found."

    def details(self):
        albums_details = '\n'.join(f"{a.details()}" for a in self.albums)
        return f"Band {self.name}\n{albums_details}"
