# Lecture 8
#java course#

## Access modifiers, final, static, packages

В тази лекция ще разгледаме, какво е **енкапсулация (encapsulation)** и как можем
да структорираме нашия код за да е по енкапсулиран.

### Какво са пакети (packages)?

Пакетите представляват йерархична структура сходна на директориите в една операционна система.
На файловата система **пакетите (packages)** са репрезентирани като директории. Но в една програма
те целят да групират логически отделни компоненти (класове) от програмата.

- Примерна структура на един проект

![package-structure](../../../assets/08-lecture/package-structure.png)

Ето как би изглеждал класът `Dog` намиращ се в пакета `animals`

```java
package petshop.animals;

public class Dog {
    
}
```

> Когато един `class` се намира в пакет, то на първия ред на класът трябва да е изписано
името на пакета използвайки ключовата дума `package`. Например за класът `Dog` 
ще е следното `package petshop.animals;`

### Модификатори за достъп (Access Modifiers)

Освен логическото групиране на класове в различни пакети, можем да имаме контрол
над това, коя част от програмата може да достъпва определена част от кода.
Такъв тип контрол можем да постигнем използвайки **модификатори за достъп (access modifiers)**

Модификаторите за достъп представляват ключови думи, които могат да бъдат слагани на определни места в кода.  
Такива места са:

- property (свойство)
- method (метод)
- constructor (конструктор)
- class (клас)

Java има четири модификатора за достъп
- public (публичен)
- protected (защитен)
- *no modifier or package-private* (липсва модификатор)
- private (личен)

Всеки един от модификаторите разрешава различна част от програмата да има достъп до различна част от кода.

|               |Class          |Package        |Subclass (same pkg)|Subclass (diff pkg)|World          |
|---------------|---------------|---------------|-------------------|-------------------|---------------|
|public         |+              |+              |+                  |+                  |+              |           
|protected      |+              |+              |+                  |+                  |               |           
|*no modifier*  |+              |+              |+                  |                   |               |           
|private        |+              |               |                   |                   |               |

> **\+** : достъпно &emsp;&emsp;&emsp;&emsp;&emsp; **празно** : не достъпно

Ето как би изглеждал най-ограничителният модификатор за достъп `private` сложен на различните възможни места:

- property
    
    ```java
    class Car {
    
      private String model;
    }
    ```
    > Ограничаваме достъпа до променливата `model`
    
- method
    
    ```java
    class Car {
    
      String color;
    
      private void changeModel(String newColor) {
        color = newColor;
      }
    }
    ```
    > Ограничаваме достъпа до метода `changeModel`

- constructor
    ```java
    class Car {
    
      private Car() {  
      }
    
    }
    ```
    > Ограничаваме достъпа до конструктора без параметри на `Car`

- class 
    ```java
    private class Car {
      
    }
    ```
    > Ограничаваме достъпа до целия клас `Car`

**Пример, кога бихме ползвали модификатор за достъп**  
Ако моделираме един човек с характеристика години, бихме искали единствено моделировката на 
човек да може да достъпва годините си, като в същото време други части от програмата да нямат достъп
до тези характеристика.


Ето как би изглеждало това
```java
class Person {
    
    private int age;
    
}
```


## Енкапсулация 🏛️

Използвайки пакетите и модификаторите за достъп, ние сме способни да разделим отделни части от кода, така че всяка 
една част да бъде изолирана и независима (до колкото е възможно) от другите.
Това свойство на писане на код се наричана **Енкапсулация**.

Това би позволило писането на модулярен код, който е по лесен за разбиране и поддръжка.  
Една причина, поради която кодът става по лесен за подръжка, е че при добре реализирана **енкапсулация**, по-лесно
могат да бъдат внесени промени в отделните софтуерни компоненти, без да има опасност от това, промените да засегнат
по неочакван начин други части на програмата.

![encapsulation](../../../assets/08-lecture/encapsulation.png)

Естествено за да се получи добре енкапсулиран код, не е достатъчно да се използват само `packages` и `access modifiers`.
Когато една програма бива писана програмиста трябва добре да обмисля, кои части от програмата трябва 
да взаимодействат помежду си и кои не.

- Пример за погрешно моделирана комуникация м/у отделни компоненти  
    - Човек иска на друг човек заем от 5лв. Втория дава на първия портмонето си за да може първия да си вземе 5лв.

- Пример за правилно моделирана комуникация м/у отделни компоненти
    - Човек иска на друг човек заем от 5лв. Втория вади портмонето си и дава 5лв на първия.

> В първия случай портмонето на човека не е енкапсулирано в процеса на обмяната на пари 👛

Липсата на **правилна енкапсулация** често води до лошо структуриран код особенно в по големи
по размер проекти.

![spaghetti-classes](../../../assets/08-lecture/spaggeti-code.png)
> Името за оплетен код е `спагети код` 🍝


![software-architecture](../../../assets/08-lecture/software-architecture.png)
> Знаехте ли че различните стилове на писане на код си имат име? Такива например са спагети-ориентиран код, лазаня-ориентиран код
и равиоли-ориентиран код. 👨‍🍳

## Ключовата дума final (финален)

Ако искаме да зададем стойност на една променлива, която никога повече да не може да бъде променена,
можем да използваме ключовата дума `final`, пред името на съответното `property`. Така тази ключова дума намира
често приложение, там където искаме да моделираме нещо неподлежащо на промяна.

Ключвоата дума `final` също като модификаторите за достъп, може да бъде слагана на няколко места.
Такива са:

- property (свойство)
- method (метод)
- class (клас)

Ето как би изглеждала употребата на ключовата дума `final` в отделните случаи:

- property
    
    ```java
    class Person {
    
      private final String name = "John";
    }
    ```
    > Името има начална стойност `John`, което не може да бъде променяно
    
- method
    
    ```java
    class Person {
    
      String name;
    
      final void changeName(String newName) {
        name = newName;
      }
    }
    ```
    > Методът `changeName` е финален и той не може да бъде променян (това ще го видим в лекцията за наследяване)

- class 
    ```java
    final class Person {
      
    }
    ```
    > Класът `Person` е финален и той не може да бъде променян (това ще го видим в лекцията за наследяване)


Нещо което е характерно за ключовата дума **final**, когато бива използвана при **property**, е че задължително трябва да бъде
дадена стойност на това property. 


**Примр**  
Ако приемем че един човек не може да сменя името си това би означавало че полето име може да бъде обозначено с `final`.

```java
class Person {
    
    final String name = "John Doe";
    
}
```

Обаче така моделиран класът означава, че всеки път, когато извикаме `new Person()` ще бъде създаван нов човек с име `John Doe`,
което не може да бъде променяно.  
Ако все пак искаме да запазим способността човека да не си сменя името и въпреки това всеки човек да е с различно име,
тогава стойността на името трябва да бъде предавана през конструктора.
```java
class Person {
    final String name;
    
    Person(String newName) {
        name = newName;
    }
}
```
> Така могат да бъдат инстанцирани нови хора на които имената няма да могат да бъдат сменяни `new Person("Ivan Asen")`


## Ключовата дума static (статичен)

Ключовата дума `static` служи за обозначение на различни части на един клас (методи, свойства),
че не принадлежат към инстанцираните обекти, а принадлежат на самия клас.

С други думи ако до сега разглеждахме едно `property` или един `method`, като част от вече инстанциран обект,
то добавяйки ключовата дума `static` пред дефиницията на това `property` или `method` то той започва
да принадлежи на самия клас. 
Това означава че това `property` или `method` може да бъде достъпвано директно от класът без да бъде инстанциран.

- **Не** статично property
![non-static-class-example](../../../assets/08-lecture/non-static-class-example.png)
> Класът Car има **не** статичено property model, което позволява всяка 
инстанция да има отделна стойност за това property

- Статично property
![static-class-example](../../../assets/08-lecture/static-class-example.png)
> Класът Car има статично property model, което означава, че това property ще е споделено
м/у всички инстанции

- Пример

```java
class Car {
    
    static String model;
    
    static void changeModel(String newModel) {
        model = newModel;
    }
}
```

> Класът Car има статична променлива `model` и статичен метод `changeModel`.

```java
Car.model = "Audi"; // можем да достъпим директно свойството защото е статично

Car first = new Car(); // колата има Audi за модел понеже model е статично свойство
Car second = new Car(); // колата има Audi за модел понеже model е статично свойство
Car third = new Car(); // колата има Audi за модел понеже model е статично свойство

Car.changeModel("BMW"); // можем да достъпим директно метода защото е статичен (това ще промени и модела на колите по-горе)
```

> Понеже и свойството и метода са статични те могат да бъдат извиквани без да се инстанцира кола. Тези методи 
и свойства, които са статични са споеделени м/у всички инстанции.


---


### Exercises

#### Task 1

Създайте клас `Car` който се характеризира с:
- свойства
    - модел (model) (задължително поле)
    - година на производство (year) (задължително поле)
    - дали е автоматик (is automatic) (задължително поле)
    - цвят (color)
    - максимална скорост (max speed)

- методи
    - смяна на цвят (change color), като методът приема новия цвят на колата и го записва
    в свойството цвят
    - принтиране на детайлите на колата (print details)

- конструктори
    - първият да приема само задължителните полета **model**, **year** и **isAutomatic**
    - вторият да приема всички полета

- Нека всички полета на този клас да бъдат видими само вътре в класът (`private`).

- Нека полета **model**, **year** и **isAutomatic** да бъдат `final`

- Инстанцирайте 2 коли с различни параметри и принтирайте детайлите им след всяко инстанциране и 
всяка промяна на цвета
    - Пробвайте същото обаче добавяйки ключовата дума `static` на полето за цвят и отново принтирайте.
    Обърнете внимание на това как промяната на цвета на едната кола афектира цвета на другата кола.
     
<br/><details><summary><b>Solution</b> 👀</summary> 
<p>

- Car.java

```java
public class Car {

    // полета които са final (не могат да бъдат променяни)
    private final String model;
    private final int year;
    private final boolean isAutomatic;

    // полета които могат да бъдат променяни след инстанцирането
    private int maxSpeed;
    private static String color; // пробвайте със и без ключовата дума static

    Car(String model, int year, boolean isAutomatic) { // конструктор със задължителните полета
        this.model = model;
        this.year = year;
        this.isAutomatic = isAutomatic;
    }

    Car(String model, int year, boolean isAutomatic, int maxSpeed, String color) { // конструктор с всички полета
        this.model = model;
        this.year = year;
        this.isAutomatic = isAutomatic;
        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    /**
     * Методът примеа новия цвят на колата и го записва в property-то за цвят.
     * @param color новия цвят на колата
     */
    void changeColor(String color) {
        this.color = color;
    }

    /**
     * Този метод принтира детайлите на колата.
     * Като добавя отстояние на полето color, за да може по лесно да се наблюдава.
     */
    void printCarDetails() {
        System.out.println("===============");
        System.out.println("model: " + model);
        System.out.println("year: " + year);
        System.out.println("isAutomatic: " + isAutomatic);
        System.out.println("maxSpeed: " + maxSpeed);
        System.out.println("color: " + color);
    }
}
```

- CarDemo.java

```java
public class CarDemo {

    public static void main(String[] args) {

        // използваме конструктора със задължителните полета
        Car bmw = new Car("BMW", 2010, true);

        bmw.printCarDetails();

        // използваме конструктора с всички полета
        Car ford = new Car("Ford", 2000, false, 220, "Green");
        ford.printCarDetails();

        bmw.changeColor("Red"); // сменяме цвета на bmw

        bmw.printCarDetails();
        ford.printCarDetails();
    }
}
```
</p>
</details>
