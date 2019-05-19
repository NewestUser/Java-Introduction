# Homework Lecture 6
#java course#

## Introduction to Object Oriented Programming

### Task 2

Създайте клас Computer, който представя компютър. Класът да има следните полета:

- `year` – числова стойност, показваща годината на производство
- `price` – числова стойност (не е задължително да е цяло число), показваща цената на компютъра
- `isNotebook` – булева стойност – дали компютърът е преносим или не 
- `hardDiskMemory` – числова стойност за размера на хард диска
- `freeMemory` – числова стойност, показваща размера на свободната памет 
- `operatingSystem` – текстово поле за операционната система на компютъра


Класът да дефинира следните методи:

- метод `void changeOperatingSystem(String newOperatingSystem)`,
който сменя стойността на полето `operatingSystem` със стойността, подадена като параметър.
- метод `void useMemory(double memory)`, който намалява 
свободната памет `freeMemory` със стойността, подадена като аргумент  
Ако стойността на аргумента е по-голяма от свободната памет, извежда съобщение `"Not enough free memory!"`

Да се създаде клас `ComputerDemo`, с `main` метод.

- В рамките на main метода да се създадат 2 обекта от тип `Computer`.
- Да се зададат стойности на свойствата на всеки един от компютрите:
    - `year`
    - `price`
    - `hardDiskMemory`
    - `freeMemory`
    - `operationSystem`
- Нека единият компютър да е лаптоп. 
- На единия от двата компютъра да се задели памет 100 (чрез метода `useMemory`)
- На другия да се смени операционната система (чрез метода `changeOperationSystem`)
- Да се изведат на екрана всички полета на двата компютъра 💻

###### solution
```java
class Computer {

    int year;
    int price;
    boolean isNotebook;
    long hardDiskMemory;
    long freeMemory;
    String operatingSystem;

    void changeOperatingSystem(String newOperatingSystem) {
        operatingSystem = newOperatingSystem;
    }

    void useMemory(long memory) {
        if (freeMemory < memory) {
            System.out.println("Not enough memory!");
        } else {
            freeMemory -= memory;
        }
    }
}
```

```java
class ComputerDemo {

    public static void main(String[] args) {

        Computer laptop = new Computer();

        laptop.operatingSystem = "Ubuntu 19.04";
        laptop.freeMemory = 4096;
        laptop.hardDiskMemory = 131_072;
        laptop.year = 2014;
        laptop.price = 1000;
        laptop.isNotebook = true;

        Computer pc = new Computer();

        pc.operatingSystem = "Windows 10";
        pc.freeMemory = 8192;
        pc.hardDiskMemory = 525_288;
        pc.year = 2015;
        pc.price = 1500;
        pc.isNotebook = false;

        laptop.useMemory(1024);

        pc.changeOperatingSystem("Windows 7");

        System.out.println("-----");
        System.out.printf("Is Notebook %b\n", laptop.isNotebook);
        System.out.printf("Year: %d\n", laptop.year);
        System.out.printf("Price: %d\n", laptop.price);
        System.out.printf("OS: %s\n", laptop.operatingSystem);
        System.out.printf("Free Memory %d:\n", laptop.freeMemory);
        System.out.printf("HDD Memory: %d\n", laptop.hardDiskMemory);

        System.out.println("-----");
        System.out.printf("Is Notebook %b\n", pc.isNotebook);
        System.out.printf("Year: %d\n", pc.year);
        System.out.printf("Price: %d\n", pc.price);
        System.out.printf("OS: %s\n", pc.operatingSystem);
        System.out.printf("Free Memory %d:\n", pc.freeMemory);
        System.out.printf("HDD Memory: %d\n", pc.hardDiskMemory);
    }
}
```