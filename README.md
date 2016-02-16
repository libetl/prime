# prime
PRIME stands for 'Pojo Raw In Memory Engine'

### How it works

```java
  package mypackage.test;
  //...
  import mypackage.A;
  import mypackage.D;
  import org.toilelibre.libe.prime.Database;
  //...
  import static org.toilelibre.libe.prime.Prime.select;
  import static org.toilelibre.libe.prime.Prime.$;
  import static org.toilelibre.libe.prime.Prime.list;
  import static org.toilelibre.libe.prime.Matcher.eq;
  //...
  public class MyClass {
    //...
    public void method () {
      //New object
      A a = new A (2, 1, Arrays.asList (new D (1), new D (2)));
      //Add a in global database
      Database.store (a);
      A vA = $ (A.class); // virtual A
      D vD = $ (D.class); // virtual D
  
      //Get any A instance in the database where b = 2 and c = 1
      select (A.class).where (eq (vA.getB (), 2)).and (eq (vA.getC (), 1)).list ();
  
      //Get any D instance inside the a.getD () result where e = 2
      select ($(a).getD ()).where (eq (vD.getE (), 2)).list ();

      //this also works with plain text requests, but hides the usage in your IDE.
      //Can be useful for external queries.
      list ("select mypackage.D where attribute[c] != 3");
    }
    //...
  }
  //...

```
