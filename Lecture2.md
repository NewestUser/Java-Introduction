# Lecture 2
#java course#

## if/else statements

**Control flow** e редът на изпълнение на предефинирани инструкции в една програма.
Редът на изпълнение на една програма може да е различен в зависимост от различни **условия**.   
Например в зависимост от това, какваи данни е въвел потребителя програмата може да извърши различни изчисления.

По време на изпълнение на програмта се изчисляват тези условия и се решава по кой клон 
да протече изпълнението на програмата.

![control-flow-graph](https://www.researchgate.net/profile/Chao_Wang287/publication/307577660/figure/fig5/AS:401918053634048@1472836139016/Control-flow-graph-of-a-C-code-and-its-dominator-tree.png)
> Примерно изпълнение на една програма. Във всички случаи започваме от **1**, като в зависимост от решенията, които се вземат
> в различните звена, програмата може да приключи на **5**, **7** или **9**.

### if

Единия от начините чрез, който може да се разклони изпълнението на програмата е използвайки `if` условния оператор.  
Ето как изглежда той.

```java
if (condition) {
    // if block
}
```

> В скобите `(...)` се изписва **boolean** условие. Ако условието е **true** се изпълнява тялото на **if блока**.
> Ако условието е **false** то тогава, кода в **if блока** не се изпълнява.
 
###### Примери

```java
if(true) {
    System.out.println("This will allways execute");
}
``` 

```java
boolean myCondition = ...;

if(myCondition) {
    System.out.println("This will execute only if myCondition == true");
}
```

```java
int a = ...;

if(a == 5) {
    System.out.println("This will execute only if a == 5");
}
```

```java
int a = ...;
int b = ...;

if(a != 5 && b >= 10) {
    System.out.println("This will execute only if a is not equal to 5 and b >= 10");
}
```

### else

Често имаме нужда да проверим за дадено условие и ако то не е изъплнено да извършим някакво друго действие.  
Това става с помоща на `else` оператора.

Ето как изглежда той:

```java
if (myCondition) {
    // if block
} else {
    // else block
}
``` 
> Ако условието `condition` е **false**, то тогава ще се изпълни **else блока** пропускайки **if блока**.

**ВАЖНО:** Не може да има `else` без `if`.

###### Пример

```java
int age = ...;

if (age >= 18) {
    System.out.println("He is equal or over 18");
} else {
    System.out.println("He is under 18");
}
```

Често подобен тип условия се илюстрират по следния начин:

![if-else-statement](https://i.ibb.co/7Y5kjy8/if-else-statement.png)

### else if

Някой път едно условие `if` и всички останали случаи `else` не са достатъчни за да изградим логиката на едно приложение.  
Често се налага да се изпълни едно парче код измежду множество условия.

За това може да използваме `else if` оператора.

Ето как изглежда той:

```java
if (condition) {
    // if block
} else if (otherCondition) {
    // else if block
}
```

... TODO (mzlatev)
- inner if
- switch case


### Loops

- for 
![for-loop](https://www.tutorialsteacher.com/Content/images/csharp/for-loop.png)

- while
- do while

