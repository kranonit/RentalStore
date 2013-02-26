package org.kranonit.rentalStore;

abstract class Price {
    abstract int getPriceCode();
}

class RegularPrice extends Price {
    int getPriceCode(){
        return Movie.REGULAR;
    }
}

class NewReleasePrice extends Price {
    int getPriceCode(){
        return Movie.NEW_RELEASE;
    }
}

class ChildrensPrice extends Price {
    int getPriceCode(){
        return Movie.CHILDRENS;
    }
}
