package org.toilelibre.libe.prime;

public class PrimeException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 6811659669764048426L;

    public PrimeException (final String arg0) {
        super (arg0);
    }

    public PrimeException (final String arg0, final Throwable arg1) {
        super (arg0, arg1);
    }

}
