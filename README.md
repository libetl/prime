# prime
PRIME stands for 'Pojo Raw In Memory Engine'

### How it works

```java
  select(AClass.class).where($(AClass.class).isFoo()).and($(AClass.class).isBar());
  select($(anObject).getThings()).where($(AClass.class).isFoo()).and($(AClass.class).isBar());

  A a = new A (2, 1, Arrays.asList (new D (1), new D(2)));
  Database.store (a);
  select(A.class).where(eq($(A.class).getB(), 2)).and(eq($(A.class).getC(), 1)).list();
  select($(a).getD ()).where (eq($(D.class).getE (), 2)).list();

```
