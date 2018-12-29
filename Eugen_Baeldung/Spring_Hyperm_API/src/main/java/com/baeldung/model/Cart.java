package com.baeldung.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Book> books;

    private boolean purchased;

    public Cart() {
        this.books = new ArrayList<Book>();
    }

    //

    public List<Book> getBooks() {
        return books;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    //

    public final void add(final Book bookToAdd) {
        books.add(bookToAdd);
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((books == null) ? 0 : books.hashCode());
        result = prime * result + (purchased ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (books == null) {
            if (other.books != null)
                return false;
        } else if (!books.equals(other.books))
            return false;
        if (purchased != other.purchased)
            return false;
        return true;
    }

}
