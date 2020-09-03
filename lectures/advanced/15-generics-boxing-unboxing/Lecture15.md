# Lecture 15
#java course#

## Boxing/Unboxing & Generics

### Autoboxing & Unboxing

Java has a two-part type system. It supports primitive types and reference types.
Each primitive type has its own corresponding reference wrapper type.

|Primitive type |Reference type |
|:-------------:|:-------------:|
|byte           |Byte           |
|short          |Short          |
|int            |Integer        |
|long           |Long           |
|float          |Float          |
|double         |Double         |
|char           |Character      |
|boolean        |Boolean        |

Although these wrapper types are introduced so they can be used in conjunction with primitive types inorder to reduce
verbosity, there are some differences between the two.

The wrapper types support all possible values that a primitive can have plus one more. A wrapper type can be `null`.
Wrapper types can be used in classes or methods that use generics while primitive types can't. 


- Example reference type.

```java
Integer x = 8;
Integer y = new Integer(5);

x++;
y++;

x += 2;
y += 2;
```

![boxing_unboxing](http://i.imgur.com/tuNnNbs.png)

We say that we have **Autoboxing** when the Java compiler automatically converts a primitive type to its corresponding reference typ.
For example `int` to `Integer`, `double` to `Double` etc... 
If the conversion is in the opposite direction, from a wrapper type to a primitive type then we have **unboxing**.
For example `Integer` to `int`, `Double` to `double` etc...

Here is an example of *autoboxing*:

```java
Character ch = 'a';
```
> We do not declare the variable as the primitive type `char` instead we use `Character`.

Let's look at another example.

```java
List<Integer> list = new ArrayList<>();

for (int i = 1; i < 50; i += 2) {
    list.add(i);
}
```

In the example above the variable `i` is defined as a primitive `int` and is used in the method `add(i)`.
The method however accepts a reference type. Usually this code wouldn't compile but here the compiler performs autoboxing on `i`.

This code snippet resembles the code that will get executed after compilation.

```java
List<Integer> list = new ArrayList<>();

for (int i = 1; i < 50; i += 2) {
    list.add(Integer.valueOf(i));
}
```

> The compiler has added `Integer.valueOf(i)` so that the primitive type can be converted to its wrapper type.

Here is an example of *unboxing*.

```java
public static int sumEven(List<Integer> li) {
    int sum = 0;
    for (Integer i : li) {
        if (i % 2 == 0) {
            sum += i;
        }
    }
    return sum;
}
```

We know that the mod operator `%` along with `+=` can't be used on reference types. 
Nonetheless, the code compiles without errors. This is due to the fact that `i` variable is *unboxed* to its primitive type.

This code snippet resembles the code that will get executed after compilation.

```java
public static int sumEven(List<Integer> numbers) {
    int sum = 0;
    for (Integer n : numbers) {
        if (n.intValue() % 2 == 0) {
            sum += n.intValue();
        }
    }
    return sum;
}
```

> The compiler has added `Integer.intValue()` inorder to convert the `Integer` variable `i` to its primitive equivalent `int`.

##### Caveats

Although autoboxing tends to reduce code verbosity there are cases that it can cause more bad than good. 

- Let's look at an example.

```java
class Foo {
    private Intager x;

    public boolean bar() {
        return x == 42;
    } 
}
```

If we invoke `new Foo().bar()` the program would throw `NullPointerException`. The reason being is 
that `x == 42` requires *unboxing*. At the same time the default value of `x` is `null` and this causes the exception. 

- Let's look at another example.

```java
static long intSum() {
    Long sum = 0L;
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
        sum += i;
    }
    return sum;
}
```

The method sums all the positive `int` values. At a first glance there is nothing wrong with the method. 
Actually it computes the result without any errors. The problem with this method is that it is slower than it should be.    
The variable `sum` is defined as `Long`. This causes about 2^31 Long instances to be constructed from autoboxing.
The simple fix is to change the `Long` to `long`.  
On my machine using `Long` the method runs about ~8 seconds in comparison to ~1 second when using `long`.

- Another troublesome example would involve comparing numbers. 
Consider the following code.

```java
Integer x = 700;
Integer y = 700;

System.out.println(x == y);
```

Usually we would expect when comparing the same numbers the result to be `true`. However, the above code prints `false`.
This is because when using the equality operator `==` on reference types it is applied on the references and not on their values.
We should always use `equals()` when checking for equality on reference types.

To summarize this. Whenever you can prefer primitive types to wrapper types. They are simpler and more efficient.  
This doesn't however mean wrapper types should be avoided on all costs. There are legitimate cases for them as well,
some already mentioned. Wrapper classes can be used in parametrized methods and classes that use generics. 
They are often used as keys in Maps and other data structures from the Collections hierarchy. 
There are also cases where you can benefit from the nullability of the wrapper types.

ℹ️ For more information regarding **boxing/unboxing** watch this [youtube video](https://www.youtube.com/watch?v=BKhuXqJyYGc).

### Generics

**Generics** is Java's ability to make a piece of code independent of the types of the data.
Generics are an extension of Java's type system that allows methods or objects to operate on various types while providing
compile-time type safety. 

For example imagine we have come up with a new sorting algorithm. Sorting algorithms are not interested of the type of
the data they sort. Such algorithms only need to know if a given element is bigger, smaller or equal to another element. 

If we are to implement this algorithm so that it can sort numbers we would write a method signature like this:

```java
public void sort(Integer[] numbers) {
    // some funky sorting logic
}
```

If we want to apply this algorithm to strings then we would need to re-implement it this time for strings.

```java
public void sort(String[] text) {
    // again the same funky logic
}
```

Note how we end up duplicating the sorting logic with the only difference being the data types.
Here is where **Generics** come into play. Java supports the concept of generalizing a piece of code.
Using generics we can reduce such code duplications and much more.   

```java
public <T> void sort(T[] elements) {
    // funky sorting logic applied to any type
}
```

> We use `<T>` before the return type of the method to indicate that it is a generic method. The type of the parameter
is `T[]` where `T` can be of any type.  
>
>This example is simplified. While it is possible to pass arrays with any types, the `T` parameter does not contain
any information on how to compare it with another `T`. More on this later.

```java
Integer[] numbers = {2, 3, 1};
String[] text = {"foo", "bar", "zar"};

sort(numbers);
sort(text);
```

> We can use the method `sort` with arrays of type `Integer[]` and `String[]`.

All data structures from the `Collection` and `Map` hierarchy support generics.
This allows reusing the data structures without having to care what the actual data types are.

- Example

```java
List<String> textList = new ArrayList<>();

Set<Integer> numberSet = new HashSet<>();
```

> `textList` is a list of `String` and `numberSet` is a list of `Integer`.

Generics were actually added in Java 6. Before that the language still had Collections and Maps. 
It was still possible to sort different data types without having to re-write the algorithms. This is possible due to **casting**.

Let's have a look at an example that **does not use** generics.

```java
List textList = new ArrayList();
textList.add("foo");

String firstItem = (String) textList.get(0); // we need to cast to String as the List does not have any type information about it's elements
```

When declaring the list as `List` we do not provide any type information. For this reason each element in the list is
treated as an `Object`. This forces us to cast the elements when retrieving them from the list.

This is a simplified version of the `List` interface definition without generics.

```java
interface List {
    boolean add(Object element);

    Object get(int index);
}
```

Let's have a look at an example that **incorrectly** retrieves elements from the list.

```java
List items = new ArrayList();
items.add(20);

String firstItem = (String) items.get(0); // will throw ClassCastException when executed
```

The code makes a wrong assumption that the element at index 0 is a String, so it casts the retrieved element to String.
The first element however is the integer 20. The code compiles. However, when executed it throws a **ClassCastException**.

Generics solve exactly this problem. They enforce a compile-time type check, that would prevent us from making 
wrong assumptions about the data types.

- Example

```java
List<Integer> numbers = new ArrayList<>();

numbers.add(1);
numbers.add(2);
numbers.add(-10);

Integer firstElement = numbers.get(0);
String element = numbers.get(0); // won't compile as the list is only for integers

numbers.add("pizza"); // won't compile as the list is only for integers
```

Via `List<Integer>` we tell the compiler that this list is expected to contain only integers. 

Here is another simplified version of the List interface this time using generics.

```java
interface List<E> {
    boolean add(E element);

    E get(int index);
}
```

> When declaring the interface we use a placeholder `<E>` to indicate that this is a generic interface. Whether we use
`<E>`, `<T>` or `<FOO>` is up to conventions, it is just a placeholder.
When we declare a variable like `List<Integer> numbers = new ArrayList<>()` you can imagine that all the `E` placeholders
get substituted by `Integer`.

One might say that by using generics on collections we loose flexibility because we can only put a single type 
in the collection. This is not true. Usually when we store some data in a collection we would like to read that data back.
Without generics, we would be able to mix different data types in a single collection.
When we read data back we would have to perform type checks in order to be sure what is the data type of the retrieved element.

- Example

```java
List everything = new ArrayList(); // a list without generics

everything.add(1);
everything.add(true);
everything.add("pizza");
everything.add(new Object());

for (Object element : everything) {
    if (element instanceof Integer) {
        Integer item = (Integer) element;
        
    } else if (element instanceof Boolean) {
        Boolean item = (Boolean) element;
        
    } else if (element instanceof String) {
        String item = (String) element;
        
    } else {
        // ....
    }
}
```

> While iterating the elements we perform type checks via `instanceof`. If the type is as expected we perform a cast.

#### Type erasure

As mentioned earlier generics were added in Java 6. By that time the Java ecosystem had grown. 
A lot of classes like `List`, `Map`, `Set` were implemented by operating with the class 
`Object` (the common ancestor of all classes in the hierarchy tree). This enforced some constraints 
on the generics type system. The code that was using generics needed to be backwards compatible with the pre Java 6 code.
For this reason the Java maintainers decided to implement generics via **type erasure**.

Type erasure refers to having more information about the data types in the precompiled code compared to its compiled version. 

Let's look at an example.

```java
List<String> strings = new ArrayList<>();
...

String firstItem = strings.get(0);
```

When compiling the code above the compiler strips off the generics information. We get a version that looks like:

```java
List strings = new ArrayList();

String firstItem = (String) strings.get(0);
```

The `<String>` constraint is removed and when retrieving items from the list the compiler automatically inserts a 
cast `(String) strings.get(0)`.
Basically the compiler knows that if the List is defined as `List<String>` that list can't contain elements other than strings.
For this reason it is safe to automatically insert a cast.

##### Caveats

Its worth mentioning that the Generics type system isn't perfect and there are cases that can go wrong. 

Here is one example:

```java
List<String> myStrings = new ArrayList<>();
myStrings.add("hello");

List myObjects = myStrings;
myObjects.add(10);

String secondElement = myStrings.get(1); // throws a ClassCastException at runtime
```

In the code above we first initialize `List<String> myStrings`. 
Using this variable the compiler can guarantee that all the elements added and retrieve from it will be strings.
However, we assign the variable to `List myObjects` that does not have any generics constraints.
Using the variable `myObjecs` we can now add elements that are of different type like the integer `10`.  
The compiler will generate a warning but will still compile.  
After that we read the second element using the variable `myStrings`. 
The variable contains a generic constraint, so we can assign the result to `String secondElement`.  
When we run the program we get a ClassCastException.
Remember that after compilation the compiler removes all generics information and inserts casts where ever applicable.  
Luckily there is a simple rule that if applied eliminates such errors. 
Always provide the type of a class that supports generics. 

Another caveat is that Arrays and Generics don't mix well.
The reason being is that arrays are **covariant** and generics are **invariant**.

Let's look at an example that illustrates this difference:

```java
String[] stringArray = new String[2];
Object[] objectArray = stringArray; // compiles

List<String> stringList = new ArrayList<>();
List<Object> objectList = stringList; // does not compile
```

Note that in this example `String` extends `Object`. 
Arrays can be assigned to variables that are of a super type while generics can't and trying to do so generates compile time error.

Another major difference between arrays and generics is that arrays are **reified**. 
Meaning that arrays retain their type information at runtime. Remember that generics are implemented via *type erasure*.
This introduces some differences when using arrays and generics.

Here is an example that illustrates this:

```java
Object[] objectArray = new Long[1];
objectArray[0] = "pizza"; // throws ArrayStoreException at runtime

List<Long> numberList = new ArrayList<Long>();
List objectList = numberList;
objectList.add("pizza"); // does not throw an exception
```

#### Where can we apply Generics?

- Generics can be applied on parameters of methods and constructors.

- The return type of methods can be generic.

- A generic class can have a generic property.

Let's go through an example of making a class generic.
The example models a cup that can hold different liquids.

![generic_cup](https://data.earthli.com/news/attachments/entry/3166/cupt.jpg)

```java
public class Cup {

    private Object content;

    public void fill(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return this.content;
    }
}
```

Here is how we would use this class:

```java
Cup cup = new Cup();
cup.fill(new Cola()) // we fill in Cola 

Object content = cup.getContent(); // we don't know what is the type of the content
```

Because the content of the cup is of type `Object` we can fill it with any type. The problem here is when retrieving 
the content of the cup. We don't know what kind of data to expect.

To make this class generic we use the following syntax.

`class name<T1, T2, ..., Tn> { /* ... */ }`

```java
public class Cup<T> {

    private T content;

    public void fill(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}
```

Here is how we would use this class:

```java
Cup<Cola> colaCup = new Cup<>();
colaCup.fill(new Cola()); // we fill in Cola
Cola cola = colaCup.getContent(); // we know that the content is Colla

Cup<Candy> candyCup = new Cup<>();
candyCup.fill(new Candy()); // we fill in Candy 
Candy candy = candyCup.getContent(); // we know that the content is Candy
```

In this version of the Cup we have added made the content generic. 
This gives us the type information of the content of the cup at compile time.
However, there is nothing preventing us from using the cup with Animals, People and etc...

We can use an **upper bound** to constrain on `T` so that the cup can only contain certain type hierarchy. 
For example, we might want to use our cup only with Fluids. 
This would allow us to write some fluid specific code in the Cup class and retain type information at compile time.

Here is the syntax for **upper bound** constraints:
`class name<T extends Foo> { /* ... */ }`

```java
interface Fluid {
    int getMilliliters();
}

public class Cup<T extends Fluid> {
    private T content;

    public void fill(T content) {
        if(content.getMilliliters() > 500) {
            throw new IllegalArgumentException("Too much fluid");
        }
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}
```

Here is how the client code would look like:

```java
Cup<Cola> colaCup = new Cup<>();
colaCup.fill(new Cola()); // colla implements Fluid so this code compiles
Cola cola = colaCup.getContent(); // we know that the content is Colla

Cup<Candy> candyCup = new Cup<>();
candyCup.fill(new Candy()); // candy does not implement Fluid so this code doesn't compile 
```

Assuming the class `Cola` implements `Fluid` we can define `Cup<Cola> colaCup` and pass in a Cola Fluid.
At the same time when retrieving the content we know that the cup contains `Cola`.
Assuming the class `Candy` doesn't implement `Fluid` we get compile time error.

ℹ️ For more information about **Generics** watch [this](https://www.youtube.com/watch?v=_dy9JnEXekU) 
and [this youtube video](https://www.youtube.com/watch?v=DjJRWroA168).
