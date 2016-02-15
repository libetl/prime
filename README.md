# prime
PRIME stands for 'Pojo Raw In Memory Engine'

### How it works

```java
  import static org.toilelibre.libe.prime.Prime.select;
  import static org.toilelibre.libe.prime.Prime.$;
  import static org.toilelibre.libe.prime.Matcher.eq;
  
  //...
  public void method () {
    select(AClass.class).where($(AClass.class).isFoo()).and($(AClass.class).isBar());
    select($(anObject).getThings()).where($(AClass.class).isFoo()).and($(AClass.class).isBar());

    A a = new A (2, 1, Arrays.asList (new D (1), new D(2)));
    //Add a in global database
    Database.store (a);
  
    //Get any A instance in the database where b = 2 and c = 1
    select(A.class).where(eq($(A.class).getB(), 2)).and(eq($(A.class).getC(), 1)).list();
  
    //Get any D instance inside A.getD () where e = 2
    select($(a).getD ()).where (eq($(D.class).getE (), 2)).list();
  }
  
  //...

```
