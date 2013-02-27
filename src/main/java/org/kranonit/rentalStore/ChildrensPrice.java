package org.kranonit.rentalStore;

class ChildrensPrice extends Price {
    @Override
    int getPriceCode(){
        return Movie.CHILDRENS;
    }
}
