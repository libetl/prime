package org.toilelibre.libe.prime;

import static org.toilelibre.libe.prime.ClassSelector.$;
import static org.toilelibre.libe.prime.ClassSelector.select;
import static org.toilelibre.libe.prime.Matcher.eq;

import java.util.Arrays;
import java.util.List;

public class Test {

    static class D {
        private int e;
        public D (int e) {
            this.e = e;
        }
        public int getE () {
            return e;
        }
    }
    static class A {
        private int b;
        private int c;
        private List<D> d;
        public A (int b, int c, List<D> d) {
            this.b = b;
            this.c = c;
            this.d = d;
        }
        public int getB () {
            return b;
        }
        public int getC () {
            return c;
        }
        public List<D> getD () {
            return d;
        }
    }
    
    public static void main (String [] args) {
      A a = new A (2, 1, Arrays.asList (new D (1), new D(2)));
      Database.store (a);
      select(A.class).where(eq($(A.class).getB(), 2)).and(eq($(A.class).getC(), 1)).list();
      select($(a).getD ()).where (eq($(D.class).getE (), 2)).list();
    }
    
}
