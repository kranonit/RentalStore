package org.kranonit.rentalStore;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String getRentedMovies() {
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental rentedItem = rentals.nextElement();
            result += rentedItem.getNameAndPriceAsString();
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf(getRentSum()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints())
                + " frequent renter points";
        return result;
    }

    private int getFrequentRenterPoints(){
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            frequentRenterPoints++;
            if (each.isRentNewReleaseTwoDays()) frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    public double getRentSum(){
        double totalAmount = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rentedItem = rentals.nextElement();
            totalAmount += rentedItem.getCharge();
        }
        return totalAmount;
    }


}