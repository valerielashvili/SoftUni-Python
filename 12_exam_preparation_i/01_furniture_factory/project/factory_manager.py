from typing import List
from itertools import groupby
from products.base_product import BaseProduct
from stores.toy_store import ToyStore
from stores.furniture_store import FurnitureStore
from stores.base_store import BaseStore
from products.chair import Chair
from products.hobby_horse import HobbyHorse


class FactoryManager:
    PRODUCT_TYPES = {
        "Chair": Chair,
        "HobbyHorse": HobbyHorse
    }
    STORE_TYPES = {
        "FurnitureStore": FurnitureStore,
        "ToyStore": ToyStore
    }

    def __init__(self, name: str):
        self.name = name
        self.income: float = 0.0
        self.products: List[BaseProduct] = []
        self.stores: List[BaseStore] = []

    def produce_item(self, product_type: str, model: str, price: float):
        if product_type not in self.PRODUCT_TYPES:
            raise Exception("Invalid product type!")

        product = self.PRODUCT_TYPES[product_type](model, price)
        self.products.append(product)
        return f"A product of sub-type {product.sub_type} was produced."

    def register_new_store(self, store_type: str, name: str, location: str):
        if store_type not in self.STORE_TYPES:
            raise Exception(f"{store_type} is an invalid type of store!")

        store = self.STORE_TYPES[store_type](name, location)
        self.stores.append(store)
        return f"A new {store_type} was successfully registered."

    def sell_products_to_store(self, store: BaseStore, *products: BaseProduct):
        if store.capacity <= len(products):
            return f"Store {store.name} has no capacity for this purchase."
        products_filtered = [
            p for p in products
            if (p.sub_type == "Furniture" and store.store_type == "FurnitureStore")
            or (p.sub_type == "Toys" and store.store_type == "ToyStore")
        ]
        if products_filtered:
            store.products += products_filtered
            store.capacity -= len(products_filtered)
            self.income += sum(p.price for p in products_filtered)
            [self.products.remove(p) for p in products_filtered if p in self.products]
            return f"Store {store.name} successfully purchased {len(products_filtered)} items."
        else:
            return "Products do not match in type. Nothing sold."

    def unregister_store(self, store_name: str):
        if not any(s for s in self.stores if s.name == store_name):
            raise Exception("No such store!")

        store = next((s for s in self.stores if s.name == store_name), None)

        if len(store.products):
            return "The store is still having products in stock! Unregistering is inadvisable."
        else:
            self.stores.remove(store)
            return f"Successfully unregistered store {store_name}, location: {store.location}."

    def discount_products(self, product_model: str):
        products_count = 0

        for p in self.products:
            if p.model == product_model:
                p.discount()
                products_count += 1

        return f"Discount applied to {products_count} products with model: {product_model}"

    def request_store_stats(self, store_name: str):
        store = next((s for s in self.stores if s.name == store_name), None)
        if not store:
            return "There is no store registered under this name!"

        return store.store_stats()

    def statistics(self):
        product_groups = {
            k: list(v) for k, v in
            groupby(
                sorted(self.products, key=lambda p: p.model),
                key=lambda p: p.model
            )
        }
        return (
            f"Factory: {self.name}\n"
            f"Income: {self.income:.2f}\n"
            f"***Products Statistics***\n"
            f"Unsold Products: {len(self.products)}. Total net price: {sum(p.price for p in self.products):.2f}\n" +
            '\n'.join(f"{model}: {len(products)}" for model, products in product_groups.items()) +
            f"\n***Partner Stores: {len(self.stores)}***\n" +
            '\n'.join(s.name for s in sorted(self.stores, key=lambda s: s.name))
            )
