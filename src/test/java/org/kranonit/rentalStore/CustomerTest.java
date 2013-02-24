package org.kranonit.rentalStore;

import junit.framework.Assert;
import org.junit.Test;

public class CustomerTest {
	@Test
	public void testAddRental() throws Exception {

	}

	@Test
	public void testStatement() throws Exception {
		Movie m1 = new Movie("За двумя зайцами", Movie.REGULAR);
		Movie m2 = new Movie("Всё просто", Movie.NEW_RELEASE);
		Movie m3 = new Movie("Хоббит", Movie.CHILDRENS);
		Movie m4 = new Movie("Альф", Movie.NEW_RELEASE);

		Customer c = new Customer("stokito");
		c.addRental(new Rental(m1, 3));
		c.addRental(new Rental(m2, 4));
		c.addRental(new Rental(m3, 5));
		c.addRental(new Rental(m4, 6));
		String statementResult = c.statement();
		System.out.print(statementResult);
		Assert.assertEquals("Rental Record for stokito\n" +
				"\tЗа двумя зайцами\t3.5\n" +
				"\tВсё просто\t12.0\n" +
				"\tХоббит\t4.5\n" +
				"\tАльф\t18.0\n" +
				"Amount owed is 38.0\n" +
				"You earned 6 frequent renter points", statementResult);
	}

    @Test
    public void testHtmlStatement() throws Exception {
        Movie m1 = new Movie("За двумя зайцами", Movie.REGULAR);
        Movie m2 = new Movie("Всё просто", Movie.NEW_RELEASE);
        Movie m3 = new Movie("Хоббит", Movie.CHILDRENS);
        Movie m4 = new Movie("Альф", Movie.NEW_RELEASE);

        Customer c = new Customer("stokito");
        c.addRental(new Rental(m1, 3));
        c.addRental(new Rental(m2, 4));
        c.addRental(new Rental(m3, 5));
        c.addRental(new Rental(m4, 6));
        String statementResult = c.htmlStatement();
        System.out.print(statementResult);
        Assert.assertEquals("<H1>Rental Record for <EM>stokito</EM></H1><P>\n" +
                "За двумя зайцами: 3.5<BR>\n" +
                "Всё просто: 12.0<BR>\n" +
                "Хоббит: 4.5<BR>\n" +
                "Альф: 18.0<BR>\n" +
                "<P>Amount owed is <EM>38.0</EM><P>\n" +
                "You earned <EM>6</EM> frequent renter points<P>", statementResult);
    }
}
