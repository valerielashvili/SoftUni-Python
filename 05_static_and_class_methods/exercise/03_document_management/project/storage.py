from project.category import Category
from project.topic import Topic
from project.document import Document


class Storage:
    def __init__(self):
        self.categories = []
        self.topics = []
        self.documents = []

    def add_category(self, category: Category):
        if category not in self.categories:
            self.categories.append(category)

    def add_topic(self, topic: Topic):
        if topic not in self.topics:
            self.topics.append(topic)

    def add_document(self, document: Document):
        if document not in self.documents:
            self.documents.append(document)

    def edit_category(self, category_id: int, new_name: str):
        category = self.find_object(category_id, self.categories)
        if category:
            category.edit(new_name)

    def edit_topic(self, topic_id: int, new_topic: str, new_storage_folder: str):
        topic = self.find_object(topic_id, self.topics)
        if topic:
            topic.edit(new_topic, new_storage_folder)

    def edit_document(self, document_id: int, new_file_name: str):
        document = self.find_object(document_id, self.documents)
        if document:
            document.edit(new_file_name)

    def delete_category(self, category_id):
        self.categories.remove(self.find_object(category_id, self.categories))

    def delete_topic(self, topic_id):
        self.topics.remove(self.find_object(topic_id, self.topics))

    def delete_document(self, document_id):
        self.documents.remove(self.find_object(document_id, self.documents))

    def get_document(self, document_id):
        return self.find_object(document_id, self.documents)

    @staticmethod
    def find_object(obj_id: int, obj_list: list) -> Category | Topic | Document:
        return next((o for o in obj_list if o.id == obj_id), None)

    def __repr__(self):
        return '\n'.join(repr(doc) for doc in self.documents)
