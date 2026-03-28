from project.zones.base_zone import BaseZone
from project.battleships.royal_battleship import RoyalBattleship

class PirateZone(BaseZone):
    def __init__(self, code: str):
        super().__init__(code, volume=8)

    def zone_info(self):
        royalships_count = sum(1 for x in self.ships if isinstance(x, RoyalBattleship))
        info = [
            "@Pirate Zone Statistics@",
            f"Code: {self.code}; Volume: {self.volume}",
            f"Battleships currently in the Pirate Zone: {len(self.ships)}, "
            f"{royalships_count} out of them are Royal Battleships.",
        ]
        if self.ships:
            ship_names = ", ".join(s.name for s in self.get_ships())
            info.append(f"#{ship_names}#")

        return "\n".join(info)
