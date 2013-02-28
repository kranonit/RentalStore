package org.kranonit.rentalStore;

import junit.framework.Assert;
import org.junit.Test;

public class MovieTest {

    @Test
    public void testGetPriceCode() throws Exception {
        Movie aMovie = new Movie("Die Hard", 2);
        Assert.assertEquals(Movie.CHILDRENS, aMovie.getPriceCode());
    }

    @Test
    public void testGetCharge() throws Exception {
        Movie aMovie = new Movie("Die Hard", Movie.NEW_RELEASE);
        Assert.assertEquals(15d, aMovie.getCharge(5));
    }

    @Test
    public void testGetFrequentRenterPoints() throws Exception {
        Movie aMovie = new Movie("Die Hard", Movie.REGULAR);
        Assert.assertEquals(1, aMovie.getFrequentRenterPoints(6));
    }
}
