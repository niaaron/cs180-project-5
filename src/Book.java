public class Book {
    /**
     * The name of the book
     */
    private String name;

    /**
     * The store selling the book.
     */
    private Store store;

    /**
     * The genre of the book
     */
    private String genre; // TODO: Convert to genre class?

    /**
     * The description of the book
     */
    private String description;

    /**
     * The price of the book
     */
    private double price;

    public Book(String name, Store store, String genre, String description, double price) {
        this.name = name;
        this.store = store;
        this.genre = genre;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "name='" + name + '\'' + ", store='" + store + '\'' + ", genre='" + genre + '\'' + ", " +
                "description='" + description + '\'' + ", price=" + price + '}';
    }
}

