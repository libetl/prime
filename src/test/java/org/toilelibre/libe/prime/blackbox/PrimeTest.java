package org.toilelibre.libe.prime.blackbox;

import java.util.Arrays;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.toilelibre.libe.prime.Database;
import org.toilelibre.libe.prime.Matcher;
import org.toilelibre.libe.prime.Prime;

public class PrimeTest {

	static class A {
		private final int b;
		private final int c;
		private final List<D> d;

		public A(final int b, final int c, final List<D> d) {
			this.b = b;
			this.c = c;
			this.d = d;
		}

		public int getB() {
			return this.b;
		}

		public int getC() {
			return this.c;
		}

		public List<D> getD() {
			return this.d;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + b;
			result = prime * result + c;
			result = prime * result + ((d == null) ? 0 : d.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			A other = (A) obj;
			if (b != other.b)
				return false;
			if (c != other.c)
				return false;
			if (d == null) {
				if (other.d != null)
					return false;
			} else if (!d.equals(other.d))
				return false;
			return true;
		}

	}

	static class D {
		private final int e;

		public D(final int e) {
			this.e = e;
		}

		public int getE() {
			return this.e;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + e;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			D other = (D) obj;
			if (e != other.e)
				return false;
			return true;
		}

	}

	@Test
	public void blackboxTest1() {
		final A a = new A(2, 1, Arrays.asList(new D(1), new D(2)));
		final A a2 = new A(2, 3, Arrays.asList(new D(3), new D(4)));
		final A a3 = new A(2, 4, Arrays.asList(new D(5), new D(6)));
		Database.store(a);
		Database.store(a2);
		Database.store(a3);
		final List<A> listOfA = Prime.select(A.class).where(Matcher.eq(Prime.$(A.class).getB(), 2)).and(Matcher.eq(Prime.$(A.class).getC(), 1)).list();
		final List<D> listOfD = Prime.<D> select(Prime.$(a).getD()).where(Matcher.eq(Prime.$(D.class).getE(), 2)).list();
		final List<A> someA = Prime.<A> list("select " + A.class.getName() + " where attribute[c] != 3");
		Database.remove(a);
		final List<A> listOfAEmpty = Prime.select(A.class).where(Matcher.eq(Prime.$(A.class).getB(), 2)).and(Matcher.eq(Prime.$(A.class).getC(), 1)).list();
		listOfA.hashCode();
		listOfD.hashCode();
		someA.hashCode();
		listOfAEmpty.hashCode();
		Assertions.assertThat(listOfA).containsExactly(a);
		Assertions.assertThat(listOfD).containsExactly(new D(2));
		Assertions.assertThat(someA).containsExactly(a, a3);
		Assertions.assertThat(listOfAEmpty).isEmpty();
	}

}
