package org.toilelibre.libe.prime.blackbox;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

        public int getF (final int i) {
            if (this.e == i) {
                return 8;
            }
            return 0;
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
        final Set<A> resultSetOfA = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getB (), 2)).and (Matcher.eq (Prime.$ (A.class).getC (), 1)).result ();
        final Set<D> resultSetOfD = Prime.<D> select (Prime.$ (a).getD ()).where (Matcher.eq (Prime.$ (D.class).getE (), 2)).result ();
        final Set<A> someA = Prime.<A> result ("select " + A.class.getName () + " where attribute[c] != 3");
        Database.remove (a);
        final Set<A> resultSetOfAEmpty = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getB (), 2)).and (Matcher.eq (Prime.$ (A.class).getC (), 1)).result ();
        Assertions.assertThat (resultSetOfA).containsOnly (a);
        Assertions.assertThat (resultSetOfD).containsOnly (new D (2));
        Assertions.assertThat (someA).containsOnly (a, a3);
        Assertions.assertThat (resultSetOfAEmpty).isEmpty ();
    }

    @Before
    public void clearDatabase () {
        Database.clear ();
    }

    @Test
    public void queryParamsWithArgs () {
        final D d1 = new D (1);
        final D d2 = new D (2);
        final D d3 = new D (3);
        Database.store (d1);
        Database.store (d2);
        Database.store (d3);
        final Set<D> resultSetOfD = Prime.select (D.class).where (Matcher.eq (Prime.$ (D.class).getF (2), 8)).saveAs ("resultSet1").result ();
        Assertions.assertThat (resultSetOfD.toArray ()).isNotNull ().isNotEmpty ().containsOnly (d2);
    }

    @Test
    public void resultListAndQueryTest () {
        final A a1 = new A (1, 5, Arrays.asList (new D (7), new D (8)));
        final A a2 = new A (2, 5, Arrays.asList (new D (8), new D (9)));
        final A a3 = new A (3, 5, Arrays.asList (new D (9), new D (10)));
        Database.store (a1);
        Database.store (a2);
        Database.store (a3);
        final Set<A> resultSetOfA = Prime
                .<A> result ("select org.toilelibre.libe.prime.blackbox.PrimeTest$A where getC () == 5 saveAs resultSet1 ; select resultSet['resultSet1'] where getB () == 2");
        Assertions.assertThat (resultSetOfA.toArray ()).isNotNull ().isNotEmpty ().containsOnly (a2);
    }

    @Test
    public void resultListAndQueryTest2 () {
        final A a1 = new A (1, 5, Arrays.asList (new D (7), new D (8)));
        final A a2 = new A (2, 5, Arrays.asList (new D (8), new D (9)));
        final A a3 = new A (3, 5, Arrays.asList (new D (9), new D (10)));
        Database.store (a1);
        Database.store (a2);
        Database.store (a3);
        final Set<A> resultSetOfA = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getC (), 5)).saveAs ("resultSet1").<A> andThenSelect ("resultSet1")
                .where (Matcher.eq (Prime.$ (A.class).getB (), 2)).result ();
        Assertions.assertThat (resultSetOfA.toArray ()).isNotNull ().isNotEmpty ().containsOnly (a2);
    }

    @Test
    public void resultListTest () {
        final A a1 = new A (1, 5, Arrays.asList (new D (7), new D (8)));
        final A a2 = new A (2, 5, Arrays.asList (new D (8), new D (9)));
        final A a3 = new A (3, 5, Arrays.asList (new D (9), new D (10)));
        Database.store (a1);
        Database.store (a2);
        Database.store (a3);
        final Set<A> resultSetOfA1 = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getC (), 5)).saveAs ("resultSet1").result ();
        final Set<A> resultSetOfA2 = Database.getResultSet ("resultSet1");
        Assertions.assertThat (resultSetOfA2.toArray ()).isNotNull ().isNotEmpty ().containsOnly (resultSetOfA1.toArray ());
    }

    @Test
    public void withParentheses () {
        final A a1 = new A (1, 5, Arrays.asList (new D (7), new D (8)));
        final A a2 = new A (2, 5, Arrays.asList (new D (8), new D (9)));
        final A a3 = new A (3, 5, Arrays.asList (new D (9), new D (10)));
        Database.store (a1);
        Database.store (a2);
        Database.store (a3);
        final Set<A> resultSetOfA1 = Prime.select (A.class).where (Matcher.eq (Prime.$ (A.class).getC (), 5))
                .and (Matcher.eq (Prime.$ (A.class).getB (), 2).orEq (Prime.$ (A.class).getB (), 3)).result ();
        Assertions.assertThat (resultSetOfA1.toArray ()).isNotNull ().isNotEmpty ().containsOnly (a2, a3);
    }
}
