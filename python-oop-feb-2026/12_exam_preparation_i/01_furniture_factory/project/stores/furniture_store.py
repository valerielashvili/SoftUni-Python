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
        return (f"Store: {self.name}, location: {self.location}, available capacity: {self.capacity}\n"
               f"{self.get_estimated_profit()}\n"
               f"**Furniture for sale:" +
                '\n'.join(
                    f"{m}: {len(prdcts)}pcs, average price: {sum(p.price for p in prdcts) / len(prdcts)}"
                    for m, prdcts in product_groups.items()
                ))
