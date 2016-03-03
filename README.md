# prime
 : stands for 'Pojo Raw In Memory Engine'

### How it works

```java
package mypackage.test;

//...
import java.util.Arrays;

//...
import mypackage.A;
import mypackage.D;

//...
import org.toilelibre.libe.prime.Database;

//...
import static org.toilelibre.libe.prime.Prime.select;
import static org.toilelibre.libe.prime.Prime.$;
import static org.toilelibre.libe.prime.Prime.list;
import static org.toilelibre.libe.prime.Matcher.eq;
//...
public class MyClass {
    // ...
    public static void main (String [] args) {
        // New object
        A a = new A (2, 1, Arrays.asList (new D (1), new D (2)));
        A a2 = new A (2, 1, Arrays.asList (new D (1), new D (2)));
        // Add 'a' in global in-memory database
        Database.store (a);
        A vA = $ (A.class); // virtual A
        D vD = $ (D.class); // virtual D

        // Get any A instance in the database where b = 2 and c = 1
        select (A.class).where (eq (vA.getB (), 2)).and (eq (vA.getC (), 1)).result ();

        // Get any D instance inside the a2.getD  () result where e = 2.
        // No need to add 'a2' in a Database, the object is a database already.
        select ($ (a2).getD ()).where (eq (vD.getE (), 2)).result ();

        // This also works with plain text queries, but hides the usage in your IDE.
        // Can be useful for external queries.
        result ("select mypackage.D where attribute [c] != 3");

        // The language allows to store a temporary list and to use it in another request
        // This example stores in 'list1' all the database A instances where c = 5,
        // and then query 'list1' to filter all the instances having b = 2.
        result ("select mypackage.A where getC () == 5 saveAs set1 ; " + 
              "select resultSet ['set1'] where getB () == 2");
        //The same query, written with a fluent interface
        select (A.class).where (eq (vA.getC (), 5)).saveAs ("set1").
          <A>andThenSelect ("set1").where (eq (vA.getB (), 2)).result ();
    }
    // ...
}
```
