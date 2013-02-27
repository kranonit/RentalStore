package org.kranonit.rentalStore;

public class RegularPrice extends  Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }
}
