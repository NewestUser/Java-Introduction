# Lecture 6
#java course#

## Introduction to Object Oriented Programming

### Какво е ООП?

Обектно ориентираното програмиране е концепция. 
Тя позволява писането на преизползваем, лесен за разбиране и поддръжка код.
В основата на ООП се намират **класовете** и **обектите**.  

Те се изплзват за моделиране на *обекти* от реалния свят. Като *обектите* от реалния
свят споделят две характеристики **състояние (state)** и **поведение (behaviour)**.

- Всеки човек има име, години, пол... (**състояние**)
- Всеки човек може да яде, спи, върви... (**поведение**)
- Мобилния телефон има памет, цвят, може да е включен/изключен (**състояние**)
- Мобилния телефон може да набира други номера, изпраща SMS, да бива включван/изключван (**поведение**)


Класът `class` играе ролята на шаблон, с който описваме един обект.  
Класът описва **свойствата (properties)** на обекта както и неговото **поведение (methods)**

- Всеки човек има `име`, `години`, `пол`, `тегло` и тнт. Ето пример за описане на **свойствата** на *обекта* човек:

    ```java
    class Person {
        String name;
        int age;
        boolean isFemale;
        double weight;
    }
    ```

    > Свойствата на обектите в Java се наричат **properties**. 
    Всяко едно **property** има тип (type) и име (name).

- Всеки човек може да `говори`, да `старее` и тнт. Ето пример за описание на **поведението** на *обекта* човек:

    ```java
    class Person {
        String name;
        int age;
        boolean isFemale;
        double weight;
      
        void speak() {
            System.out.printf("My name is %s and I am %d years old", name, age);
        }
      
        void grow() {
            age++;
        }
    }
    ```

    > Поведението на обектите в Java се представя чрез методи **methods**. 
    Всеки един **method** има тип на резултат (return type), име (name) и параметри (arguments).

#### Какво са обектите?

Ако **класът** `class` е шаблонът, с който описваме нещо от реалния свят, 
то **обектът** `object` е конкретен представител на този шаблон.

Пример: Знаем че една кола може да се характеризира със своята `марка`, то тогава колите
Audi, Nissan, Volvo са **обекти** от типа `Car`.

![Class vs Object](https://i.stack.imgur.com/lNUAA.png)

> Всеки един от трите **обекта** в примера е представител на **класът** Car, 
като има различна стойност записана в свойството `марка`.

- Пример използващ по-горе създадения `class` за създаването на конкретен `object`.

    ```java
    public class Main {
        
        public static void main(String[] args) {
            
          Person john = new Person();
          john.name = "John";
          john.age = 30;
          john.isFemale = false;
          john.weight = 75;
        
          john.speak();
          john.grow();
        }
    }
    ```

#### Какво друго трябва да знаем за класовете?

###### референтни типове (reference types)
Класовете са референтни типове. Това означава, че те са сложни типове данни,
които обикновенно са създадени от други примитивни типове данни.

###### стойности по подразбиране (default values)
**Свойствата (properties)** на класовете, могат да имат стойности по подразбирани,
като тези стойности зависят от типа на свойството.  
Default стойността на **property** от сложен тип е `null`

###### инстанции (instances)
Думата **инстанция (instance)** може да я разглеждаме като синоним на конкретен **object**.
Като Audi, Nissan, Volvo.

###### инстанциране на обекти
Инстанцирането (създаването) на обекти става с ключовата дума `new`. Пример `new Person()`

###### пакети (packages)
Класовете могат да бъдат групирани логически в директории или по-точно **пакети**.


### Exercises State

#### Task 1

```text
Моделирайте обекта кола (car). Всяка една кола има следните характеристики:
• модел (model)
• максимална скорост (max speed)
• текуща предавка (current gear)
• цвят (color)
• текуща скорост (current speed)

- Създайте програма с входна точка (main), която създава 2 инстанции на колата
  и записва стойности във всяка една от инстанциите.
```

#### Task 2

```text
Моделирайте обекта човек (person). Всеки един човек има следните характеристики:
• име (name)
• години (age)

- Използвайки решението от предишната задача, модифицирайте така колата, че да може
  да и се назначава собственик (owner).

- Инстанцирайте един човек и го назначете като собственик на една от колите.

- Принтирайте собственика на първата кола и собственика на втората кола.
```

#### Task 3

```text
Използвайки решението от предишната задача, модифицирайте така човека (person), че да може
на всеки човек да се назначава приятел (friend). Приятелят да е също от тип човек (person).

- Назначете приятел на човека от предишната задача.
```

### Exercises Behaviour

#### Task 4

```text
Използвайки решението от Task 1 моделирайте способността на колата да:

- Сменя скорости. Скоростите могат да бъдат сменяни с по една нагоре (shift up)
  или една надолу (shift down), като максималната скорост е 5.
  
- Да ускорява (speed up). Като всяко едно ускорение трябва да увеличава 
  текущата скорост с 10. Максималната скорост не може да бъде превишавана.
  
- Да намалява (speed down). Като всяко едно намаляне трябва да намалява
  текущата скорост с 10. Минималната скорост е 0.
  
- Да спира. При текуща скорост равна на 0 колата е спряла.
```

- solution

    - Person.java
    
    ```java
    public class Person {
    
        String name;
        int age;
    
        Person friend;
    }
    ```

    - Car.java
    
    ```java
    public class Car {
    
        String model;
        String color;
        int currentGear;
        int maxSpeed;
        int currentSpeed;
    
        Person owner;
    
        /**
         * Този метод моделира качването на предавка, като максималната възможна предавка е 5.
         * Всеки път когато се вдигне предавка скоростта се увеличава.
         */
        void shiftUp() {
            if (currentGear < 5) {
                currentGear++;
    
                speedUp(); // увеличи скоростта
            }
        }
    
        /**
         * Този метод моделира смъкването на предавка, като минималната възможна предавка е 0.
         * При всяко смъкване на предавка се намалява скоростта.
         */
        void shiftDown() {
            if (currentGear == 0) {
                return; // не дей да правиш нищо защото вече сме на нулева предавка.
            }
    
            currentGear--;
            speedDown(); // намали скоростта
        }
    
        /**
         * Този метод моделира намаляването на текущата скорост. При извикването на метода текущата скорост
         * се намалява с 10 до достигането на нулева скорост.
         */
        void speedDown() {
            int nextSpeed = currentSpeed - 10;
    
            if (nextSpeed >= 0) {
                currentSpeed = nextSpeed;
            }
        }
    
        /**
         * Този метод моделира увеличаването на скоростта, като към текущата скорост добавя 10.
         * Ако сме на 0-ва предавка превключваме на 1-ва.
         */
        void speedUp() {
            if (currentGear == 0) {
                currentGear = 1; // ако сме биле на нулева предавка, превключи на 1-ва.
            }
    
            int nextSpeed = currentSpeed + 10;
    
            if (nextSpeed < maxSpeed) {
                currentSpeed = nextSpeed; // запиши новата скорост
            }
        }
    
        /**
         * Този метод моделира спирането на колата, като за currentSpeed записва 0.
         * Aко сме на по висока предавка намаляме предавката всеки път докато стигнем 0-ва предавка.
         */
        void stop() {
            for (int i = currentGear; i >= 0; i--) { // смъкни от текущата до нулева предавка
                shiftDown(); // смъкни предавка
            }
    
            currentSpeed = 0; // занули остатъчната скорост
        }
    }
    ```

    - Main.java
    
    ```java
    public class Main {
    
        public static void main(String[] args) {
            Car peugeot = new Car(); // Инстанциране на Car
    
            peugeot.model = "Peugeot";
            peugeot.color = "Green";
            peugeot.currentGear = 0;
            peugeot.currentSpeed = 0;
            peugeot.maxSpeed = 220;
    
            Person gosho = new Person(); // Инстанциране на Person
            gosho.name = "Gosho";
            gosho.age = 30;
    
            Person pesho = new Person(); // Инстанциране на Person
            pesho.name = "Pesho";
            pesho.age = 40;
    
            gosho.friend = pesho;
    
            peugeot.owner = gosho;
    
            System.out.printf("Приятелят на %s с име %s има %s с цвят %s и максимална скорост %d\n",
                    peugeot.owner.friend.name,
                    peugeot.owner.name,
                    peugeot.model,
                    peugeot.color,
                    peugeot.maxSpeed
            );
    
            System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);
            peugeot.speedUp();
            peugeot.speedUp();
            System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);
    
            peugeot.shiftUp();
            peugeot.shiftUp();
            System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);
    
            peugeot.speedDown();
            System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);
    
            peugeot.stop();
            System.out.printf("Текуща предавка: %d, текуща скорост: %d\n", peugeot.currentGear, peugeot.currentSpeed);
        }
    }
    ```