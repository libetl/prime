package org.toilelibre.libe.prime.blackbox;

import static org.toilelibre.libe.prime.Matcher.eq;
import static org.toilelibre.libe.prime.Prime.select;

import java.util.Arrays;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.toilelibre.libe.prime.Database;
import org.toilelibre.libe.prime.Matcher;
import org.toilelibre.libe.prime.Prime;

public class PrimeTest {

    static class A {
        private final int     b;
        private final int     c;
        private final List<D> d;

        public A (final int b, final int c, final List<D> d) {
            this.b = b;
            this.c = c;
            this.d = d;
        }

        @Override
        public boolean equals (final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (this.getClass () != obj.getClass ()) {
                return false;
            }
            final A other = (A) obj;
            if (this.b != other.b) {
                return false;
            }
            if (this.c != other.c) {
                return false;
            }
            if (this.d == null) {
                if (other.d != null) {
                    return false;
                }
            } else if (!this.d.equals (other.d)) {
                return false;
            }
            return true;
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

        @Override
        public int hashCode () {
            final int prime = 31;
            int result = 1;
            result = (prime * result) + this.b;
            result = (prime * result) + this.c;
            result = (prime * result) + ( (this.d == null) ? 0 : this.d.hashCode ());
            return result;
        }

    }

    static class D {
        private final int e;

        public D (final int e) {
            this.e = e;
        }

        @Override
        public boolean equals (final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (this.getClass () != obj.getClass ()) {
                return false;
            }
            final D other = (D) obj;
            if (this.e != other.e) {
                return false;
            }
            return true;
        }

        public int getE () {
            return this.e;
        }

        @Override
        public int hashCode () {
            final int prime = 31;
            int result = 1;
            result = (prime * result) + this.e;
            return result;
        }

    }

    @Test
    public void blackboxTest1 () {
        final A a = new A (2, 1, Arrays.asList (new D (1), new D (2)));
        final A a2 = new A (2, 3, Arrays.asList (new D (3), new D (4)));
        final A a3 = new A (2, 4, Arrays.asList (new D (5), new D (6)));
        Database.store (a);
        Database.store (a2);
        Database.store (a3);
        final List<A> listOfA = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getB (), 2)).and (Matcher.eq (Prime.$ (A.class).getC (), 1)).list ();
        final List<D> listOfD = Prime.<D> select (Prime.$ (a).getD ()).where (Matcher.eq (Prime.$ (D.class).getE (), 2)).list ();
        final List<A> someA = Prime.<A> list ("select " + A.class.getName () + " where attribute[c] != 3");
        Database.remove (a);
        final List<A> listOfAEmpty = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getB (), 2)).and (Matcher.eq (Prime.$ (A.class).getC (), 1)).list ();
        Assertions.assertThat (listOfA).containsExactly (a);
        Assertions.assertThat (listOfD).containsExactly (new D (2));
        Assertions.assertThat (someA).containsExactly (a, a3);
        Assertions.assertThat (listOfAEmpty).isEmpty ();
    }

    @Before
    public void clearDatabase () {
        Database.clear ();
    }

    @Test
    public void resultListTest () {
        final A a1 = new A (1, 5, Arrays.asList (new D (7), new D (8)));
        final A a2 = new A (2, 5, Arrays.asList (new D (8), new D (9)));
        final A a3 = new A (3, 5, Arrays.asList (new D (9), new D (10)));
        Database.store (a1);
        Database.store (a2);
        Database.store (a3);
        final List<A> listOfA1 = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getC (), 5)).saveAs ("list1").list ();
        final List<A> listOfA2 = Database.getResultList ("list1");
        Assertions.assertThat (listOfA2.toArray ()).isNotNull ().isNotEmpty ().containsOnly (listOfA1.toArray ());
    }
    
    @Test
    public void resultListAndQueryTest () {
        final A a1 = new A (1, 5, Arrays.asList (new D (7), new D (8)));
        final A a2 = new A (2, 5, Arrays.asList (new D (8), new D (9)));
        final A a3 = new A (3, 5, Arrays.asList (new D (9), new D (10)));
        Database.store (a1);
        Database.store (a2);
        Database.store (a3);
        final List<A> listOfA = Prime.<A>list ("select org.toilelibre.libe.prime.blackbox.PrimeTest$A where getC () == 5 saveAs list1 ; select resultList['list1'] where getB () == 2");
        Assertions.assertThat (listOfA.toArray ()).isNotNull ().isNotEmpty ().containsOnly (a2);
    }
    
    @Test
    public void resultListAndQueryTest2 () {
        final A a1 = new A (1, 5, Arrays.asList (new D (7), new D (8)));
        final A a2 = new A (2, 5, Arrays.asList (new D (8), new D (9)));
        final A a3 = new A (3, 5, Arrays.asList (new D (9), new D (10)));
        Database.store (a1);
        Database.store (a2);
        Database.store (a3);
        final List<A> listOfA = select (A.class).where (eq (Prime.$ (A.class).getC (), 5)).saveAs ("list1").
                <A>andThenSelect ("list1").where (eq (Prime.$ (A.class).getB (), 2)).list ();
        Assertions.assertThat (listOfA.toArray ()).isNotNull ().isNotEmpty ().containsOnly (a2);
    }

}
