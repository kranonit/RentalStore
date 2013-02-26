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

    public String statement() {
   		Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf( each.getCharge() ) + "\n";
        }
        // add footer lines
        result += "Amount owed is " + String.valueOf( getTotalCharge() ) + "\n";
        result += "You earned " + String.valueOf( getTotalFrequentRenterPoints() )
                + " frequent renter points";
        return result;
    }

    private double getTotalCharge(){
        double totalCharge = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalCharge += each.getCharge();
        }
        return totalCharge;
    }

    private int getTotalFrequentRenterPoints(){
        int totalPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            totalPoints += each.getFrequentRenterPoints();
        }
        return totalPoints;
    }
}