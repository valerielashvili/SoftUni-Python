package p02_Book_Shop;

class Book {
    private String author;
    private String title;
    private double price;

    Book(String author, String title, double price) throws IllegalArgumentException {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    private String getAuthor() {
        return this.author;
    }

    private void setAuthor(String authorName) throws IllegalArgumentException {
        if (Character.isDigit(authorName.charAt(authorName.indexOf(" ") + 1))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = authorName;
    }

    private String getTitle() {
        return this.title;
    }

    private void setTitle(String title) throws IllegalArgumentException {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    double getPrice() {
        return this.price;
    }

    private void setPrice(double price) throws IllegalArgumentException {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();

    }
}
