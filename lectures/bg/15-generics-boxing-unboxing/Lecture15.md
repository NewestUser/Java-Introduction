# Lecture 15
#java course#

## Boxing/Unboxing & Generics

### Autoboxing & Unboxing

В Java всеки примитивен тип има свой референтен (сложен) аналог. Това е направено за да може примитивните 
типове да бъдат моделирани, като обекти.  Тези класове също се наричат **wrapper (обвиващи)** класове. 
По този начин тези данни могат да имат методи в съответните класове, което прави работата с тях по-лесна.

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


- Пример за използването на референтен тип.

```java
Integer x = 8;
Integer y = new Integer(5);

x++;
y++;

x += 2;
y += 2;
```

**Autoboxing** представлява автоматичното конвертиране, което Java компилатора прави м/у примитивните типове и тяхните 
референтни wrapper класове. Например конвертирането на `int` към `Integer`, `double` към `Double` и тнт. 
Ако конвертирането е в обратен ред то тогава се нарича **Unboxing**. Например `Double` към `double`.

Ето един пример на autoboxing:

```java
Character ch = 'a';
```

> Не е използван примитивния тип `char` а референтния `Character`.

![boxing_unboxing](http://i.imgur.com/tuNnNbs.png)


Нека разгледаме следния пример:

```java
List<Integer> list = new ArrayList<>();

for (int i = 1; i < 50; i += 2) {
    list.add(i);
}
```

Въпреки че добавяме `int` стойности, като примитивни типове, вместо `Integer` обекти в списъка `list`, кода се компилира.
На пръв поглед `int` и `Integer` са различни типове и компилатора трябва да покаже грешка свързана с типовете.

Причината да се компилира този код е че компилатора конвертира `int` към `Integer` автоматично.
И горния код бива сведен до следното по време на изпълнение на програмата:

```java
List<Integer> list = new ArrayList<>();

for (int i = 1; i < 50; i += 2) {
    list.add(Integer.valueOf(i));
}
```

> Компилаторът добавя `Integer.valueOf(i)` за да компилира примитивния тип до референтен тип.

Конвертирането на примитивен тип (например `int`) в съответния wrapper клас (`Integer`) се нарича **autoboxing**.

Компилаторът прилага **autoboxing** на примитивна стойност в следните случаи:

- Когато примитивата е подадена на метод очакващ референтен wrapper еквивалент.
- Когато примитивата е назначена на променлива от тип кореспондиращ на нейяният wrapper клас.


Нека разгледаме следния пример:

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

Бихме очаквали операторите за остатък (`%`) и събиране (`+=`) да не могат да бъдат прилагани на референтни типове,
като `Integer` и Java компилатора да изведе грешка, по време на компилиране. Това не се случва, 
защото компилатора използва `intValue` метода на `Integer` за да конвертира wrapper класът `Integer` към `int`.

Горния пример бива сведен до следното по време на изпълнение на програмата:

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

> Използван е `Integer.intValue()` метода за да се конвертира `Integer` към `int`.

В този случай компилаторът прилага **unboxing**.

#### Какво още трябва да знаем за boxing/unboxing?

- Boxing позволява използването на референти типове, като примитиви и обратното.

- Референтните типове могат да хвърлят `NullPointerException`, докато примитивите не могат.

- Конвертирането на типовете не бива да се използва на места където е важно да имаме бързодействие.
Например използването на **boxing/unboxing**  в цикли може да доведе до забавяне на изпълнението.

- Референтните типове могат да се използват в Generics, за разлика от примитивните.

ℹ️ За повече информация относно **boxing/unboxing** вижте това [youtube видео](https://www.youtube.com/watch?v=BKhuXqJyYGc).

### Generics

**Generics** е свойството на Java да прави парче код, независимо от типовете данни.
Например представете си, че сме измислили нов алгоритъм за сортиране. Един алгоритъм за сортиране не се интересеува от
това какви данни се сортират. Той се интересува от това, дали конкретен елемент е по-голям,
по-малък или равен на друг елемент.

Ако искаме да имплементираме този алгоритъм така че той да сортира числа бихме написали следното:

```java
public void sort(Integer[] numbers) {
    // нашата сложна логика за сортиране
}
```

Ако искаме да приложим същия този алгоритъм, обаче за да сортираме текст тогава бихме написали следното:

```java
public void sort(String[] text) {
    // отновно същата логика за сортиране
}
```

Забележете, как се налага да се имплементира едно и също нещо няколко пъти, с тази разлика, че типовете са различни.  
Тука вече се намесват **Generics**. Java поддържа концепцията за генерализиране на кода, като по този начин
може да се избегне дуплицирането на код, както и много друго.

```java
public <T> void sort(T[] elements) {
    // логиката за сортиране
}
```

> Използваме `<T>` преди return типът на метода за да упоменем, че това е generic метод. Параметърът на метода е от тип
`T[] elements`. По този начин упоменаваме, че пгорамата приема като аргумент масив, от какъв да е тип.

```java
Integer[] numbers = {2, 3, 1};
String[] text = {"foo", "bar", "zar"};

sort(numbers);
sort(text);
```

> Можем да използваме метода `sort` с масиви от тип `Integer[]`, както и с масиви от тип `String[]`.

Всичките структури от данни в `Collection` и `Map` йерархията поддържат generics.
Това позволява преизползването на структурите от данни без да има значение, какъв ще е типът на данните.

- Пример

```java
List<String> textList = new ArrayList<>();

Set<Integer> numberSet = new HashSet<>();
```

> `textList` е списък от `String`, а `numberSet` е списък от `Integer`.

Generics ни предпазват от това да смесваме различни по-тип данни или с други думи, те ни дават **type safety**.
Тоест веднъж обявен типът с който работи конкретния клас или метод, то не може да приема друг тип. Тази проверка се извършва
по време на компилация. Затова често се среща като **compile time type safety**.  

- Пример

```java
List<Integer> numbers = new ArrayList<>();

numbers.add(1);
numbers.add(2);
numbers.add(-10);

numbers.add("Пешо"); // няма да компилира, тъй като списъкът е само за <Integer>
```

От друга страна, ако не използваме generics ние ще можем да слагаме всякакъв тип данни във въпросните колекции.  
Това от своя страна обаче ще усложни обработката на тези данни, тъй като ние няма да занем какви са те.

- Пример

```java
List everything = new ArrayList();

everything.add(1);
everything.add(true);
everything.add("Пешо");
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

> По време на итерация на елементите се налага да се проверява типът на елемента и да се каства (cast),
към съответния тип.  
В този пример не са използване generics и се приема, че типът е най-високото ниво на абстракция `Object`.  
Това е същото, като `List<Object> everything = new ArrayList<>();`

#### Къде могат да бъдат използвани Generics?

- Generics могат да бъдат подавани, като параметри на методи или конструктори.

- return типът на даден метод може да е generic.

- Един клас може да има property, което е generic.

#### Пример с моделиране на чаша.

Ако искаме да моделираме, чаша и това че една чаша може да съдържа в себе си определени течности или предмети
бихме написали следния клас.

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

Тъй като съдържанието на чашата (`content`) е от тип `Object` ние не знаем, какво точно има в нея и какво и как кодът
използва този клас за да пълни (`fill`) чашата. На едно място в кода може да се слага, вода, на друго кола на трето бонбони.

За да направим този клас Generic ние можем да използваме следния синтаксис.

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

Ако искаме да лимитираме чашата да може да бъде използвана само за течности тога, можем да сложим 
**горна граница (upper bound)** на generic типът `T`. Това става чрез следния синтаксис.

`class name<T1 extends Foo> { /* ... */ }`

В случая бихме си дефинирали интерфейс `Fluid`, 
който да репрезентира течности и ще бъде използван за горна граница на `T`.


```java
interface Fluid {
}

public class Cup<T extends Fluid> {

    private T content;

    public void fill(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}
```

По този начин класът `Cup`, няма да може да бъде използван за нещо различно от течности.

![generic_cup](https://data.earthli.com/news/attachments/entry/3166/cupt.jpg)

ℹ️ За повече информация относно **Generics** вижте [това](https://www.youtube.com/watch?v=_dy9JnEXekU) 
и [това youtube видео](https://www.youtube.com/watch?v=DjJRWroA168).
