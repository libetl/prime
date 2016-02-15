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
        Database.store (a);
        final List<A> listOfA = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getB (), 2)).and (Matcher.eq (Prime.$ (A.class).getC (), 1)).list ();
        final List<D> listOfD = Prime.<D> select (Prime.$ (a).getD ()).where (Matcher.eq (Prime.$ (D.class).getE (), 2)).list ();
        listOfA.hashCode ();
        listOfD.hashCode ();
    }

}
