from itertools import groupby
from project.stores.base_store import BaseStore


class FurnitureStore(BaseStore):
    CAPACITY = 50

    def __init__(self, name: str, location: str):
        super().__init__(name, location, self.CAPACITY)

    @property
    def store_type(self):
        return "FurnitureStore"

    def store_stats(self):
        product_groups = {
            k: list(v) for k, v in
            groupby(
                sorted(self.products, key=lambda p: p.model),
                key=lambda p: p.model
            )
        }
        stats = [
            f"Store: {self.name}, location: {self.location}, available capacity: {self.capacity}",
            self.get_estimated_profit(),
            "**Furniture for sale:"
        ]
        for m, prods in product_groups.items():
            avg_price = sum(p.price for p in prods) / len(prods)
            stats.append(f"{m}: {len(prods)}pcs, average price: {avg_price:.2f}")

        return "\n".join(stats).strip()
