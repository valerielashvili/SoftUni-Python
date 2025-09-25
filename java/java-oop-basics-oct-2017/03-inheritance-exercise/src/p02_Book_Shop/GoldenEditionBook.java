package p02_Book_Shop;

class GoldenEditionBook extends Book {
    GoldenEditionBook(String author, String title, double price) throws IllegalArgumentException {
        super(author, title, price);
    }

    @Override
    double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }
}
