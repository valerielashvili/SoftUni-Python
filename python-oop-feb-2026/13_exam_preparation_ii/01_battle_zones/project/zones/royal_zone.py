from project.zones.base_zone import BaseZone
from project.battleships.pirate_battleship import PirateBattleship


class RoyalZone(BaseZone):
    def __init__(self, code: str):
        super().__init__(code, volume=10)

    def zone_info(self):
        pirateships_count = sum(1 for x in self.ships if isinstance(x, PirateBattleship))
        info = [
            "@Royal Zone Statistics@",
            f"Code: {self.code}; Volume: {self.volume}",
            f"Battleships currently in the Royal Zone: {len(self.ships)}, "
            f"{pirateships_count} out of them are Pirate Battleships.",
        ]
        if self.ships:
            ship_names = ", ".join(s.name for s in self.get_ships())
            info.append(f"#{ship_names}#")

        return "\n".join(info)
