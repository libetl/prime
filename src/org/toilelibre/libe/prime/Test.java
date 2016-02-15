package org.toilelibre.libe.prime;

import java.util.Arrays;
import java.util.List;

public class Test {

    static class A {
        private final int     b;
        private final int     c;
        private final List<D> d;

        public A (final int b, final int c, final List<D> d) {
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public int getB () {
            return this.b;
        }

        public int getC () {
            return this.c;
        }

        public List<D> getD () {
            return this.d;
        }
    }

    static class D {
        private final int e;

        public D (final int e) {
            this.e = e;
        }

        public int getE () {
            return this.e;
        }
    }

    public static void main (final String [] args) {
        final A a = new A (2, 1, Arrays.asList (new D (1), new D (2)));
        final A a2 = new A (2, 3, Arrays.asList (new D (3), new D (4)));
        final A a3 = new A (2, 4, Arrays.asList (new D (5), new D (6)));
        Database.store (a);
        Database.store (a2);
        Database.store (a3);
        final List<A> listOfA = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getB (), 2)).and (Matcher.eq (Prime.$ (A.class).getC (), 1)).list ();
        final List<D> listOfD = Prime.<D> select (Prime.$ (a).getD ()).where (Matcher.eq (Prime.$ (D.class).getE (), 2)).list ();
        final List<A> someA = Prime.<A>list ("select " + A.class.getName () + " where attribute[c] != 3");
        listOfA.hashCode ();
        listOfD.hashCode ();
        someA.hashCode ();
    }

}
