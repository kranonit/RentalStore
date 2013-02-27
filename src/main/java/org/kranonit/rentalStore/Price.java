package org.kranonit.rentalStore;

abstract class Price {
    abstract int getPriceCode();
    abstract double getCharge(int daysRented);
}
