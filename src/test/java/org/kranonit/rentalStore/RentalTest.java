package org.kranonit.rentalStore;

import junit.framework.Assert;
import org.junit.Test;

public class RentalTest {

    @Test
    public void testGetDaysRented() throws Exception {
        Movie aMovie = new Movie("Die Hard", Movie.REGULAR);
        Rental aRental = new Rental(aMovie, 4);
        Assert.assertEquals(4, aRental.getDaysRented());
    }

    @Test
    public void testGetCharge() throws Exception {
        Movie aMovie = new Movie("Life of Pi", Movie.NEW_RELEASE);
        Rental aRental = new Rental(aMovie, 2);
        Assert.assertEquals(6d, aRental.getCharge());
    }

    @Test
    public void testFrequentRenterPoints() throws Exception {
        Movie aMovie = new Movie("Panda Kung-Fu", Movie.CHILDRENS);
        Rental aRental = new Rental(aMovie, 3);
        Assert.assertEquals(1, aRental.getFrequentRenterPoints());
    }
}
