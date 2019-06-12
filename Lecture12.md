# Lecture 12
#java course#

## Collections

Data structures

#### Arrays
    
Disadvantages:

- static structure (can't change it's size)
- we need to know the initial size
    
Advantages:

- O(1) accessibility to every element
- can hold multiple elements

Dynamic Data structure:
- List
- Set
- Stack
- Queue
- Map


#### List

- ArrayList
![dynamic_array](https://www.interviewcake.com/images/svgs/dynamic_arrays__capacity_size_end_index.svg?bust=203)

За да придобиете по ясна представа, какво се случва, когато се добавят
и премахват елементи от списъците вижте това [youtube видео](https://www.youtube.com/watch?v=qTb1sZX74K0).

```java
List<String> myArrayList = new ArrayList<>();

myArrayList.add("foo");
myArrayList.add("bar");
myArrayList.add("zar");
myArrayList.add("var");
myArrayList.add("far");

myArrayList.remove("bar"); // намери елемента "bar"  и го премахни
myArrayList.remove(1); // премахни елемента на 1-ви индекс

for (String myString : myArrayList) {
    System.out.println(myString);
}
```

- LinkedList

![linked_list_insertion_animation](https://i.pinimg.com/originals/bf/db/8c/bfdb8c10a7e844f1ded4a5252d11f444.gif)

За повече информация вижте това [youtube видео](https://www.youtube.com/watch?v=_jQhALI4ujg).

```java
List<String> myLinkedList = new LinkedList<>();

myLinkedList.add("foo");
myLinkedList.add("bar");
myLinkedList.add("zar");
myLinkedList.add("var");
myLinkedList.add("far");

myLinkedList.remove("bar"); // намери елемента "bar"  и го премахни
myLinkedList.remove(1); // премахни елемента на 1-ви индекс

for (String myString : myLinkedList) {
    System.out.println(myString);
}
```

#### Stack

![stack_push_pop_animation](https://cdn-images-1.medium.com/max/1600/1*kkK3EZNOzBsuwkDNvSVR9g.gif)

```java
Stack<String> myStack = new Stack<>();

myStack.push("foo");
myStack.push("bar");
myStack.push("zar");
myStack.push("var");
myStack.push("far");

String lastElement = myStack.pop();// премахни последния добавен елемент

System.out.println("Last element: " + lastElement);

for (String myString : myStack) {
    System.out.println(myString);
}
```

#### Queue

![queue_enqueue_dequeue_animation](https://cdn-images-1.medium.com/max/1600/1*UKVABqYxsiR6YvV2385nFQ.gif)

За повече информация вижте това [youtube видео](https://www.youtube.com/watch?v=wjI1WNcIntg)

```java
Queue<String> myQueue = new LinkedList<>();

myQueue.add("foo");
myQueue.add("bar");
myQueue.add("zar");
myQueue.add("var");
myQueue.add("far");

String lastElement = myQueue.poll();// премахни първия елемент

System.out.println("First element: " + lastElement);

for (String myString : myQueue) {
    System.out.println(myString);
}
```

#### Trees 
- TreeSet

![binary_search_tree](http://web.augsburg.edu/~crockett/210/graphics/BinarySearchTreeArrayAnimation.gif)

За да придобиете по ясна представа, какво се случва, когато се добавят
и премахват елементи от списъците вижте това [youtube видео](https://www.youtube.com/watch?v=oSWTXtMglKE)

```java
TreeSet<String> myTree = new TreeSet<>();

myTree.add("foo");
myTree.add("bar");
myTree.add("zar");
myTree.add("var");
myTree.add("far");

myTree.remove("bar");// намира и премахва елемента bar

for (String myString : myTree) {
    System.out.println(myString); // обхождаме ги подредени
}
```

#### Set
- HashSet

![hash_set](https://i.stack.imgur.com/CnWBG.png)

За повече информация прочетете [тази статия](https://www.thecshandbook.com/hash_set)
или вижте това [youtube видео](https://www.youtube.com/watch?v=WPcKwA5WF7s).

```java
Set<Integer> mySet = new HashSet<>();

mySet.put(12);
mySet.put(20);
mySet.put(30);
mySet.put(30);
mySet.put(-15);

mySet.remove(20);

for (Integer number : mySet) {
    System.out.println(number); // обхождаме ги в неопределен ред
}
```

#### Hash Tables
- HashMap

![hashmap](https://cdn-images-1.medium.com/max/2000/1*78wQr8-2tEPKWa0iobs8QQ.png)

За да придобиете по ясна представа, какво се случва, когато се добавят
и премахват елементи от списъците вижте [това](https://www.youtube.com/watch?v=MfhjkfocRR0) 
и [това](https://www.youtube.com/watch?v=shs0KM3wKv8) youtube видео.

```java
Map<String, Integer> myMap = new HashMap<>();

myMap.put("foo", 1);
myMap.put("bar", 3);
myMap.put("zar", -4);
myMap.put("var", 8);
myMap.put("far", 12);

myMap.remove("bar");// намира и премахва елемента bar

for (String myKey : myMap.keySet()) { // обхождаме всички ключове
    System.out.println(myKey); // обхождаме ги в неопределен ред
}

for (int myValue : myMap.values()) { // обхождаме всички стойности
    System.out.println(myValue); // обхождаме ги в неопределен ред
}
```

##### Collections vs Maps

![java_collections_and_map_hierarchy](http://file.mrbool.com/mrbool/articles/Manisha/array-list/image1.png)

#### Iterators


#### Compare to
    
## Tasks

### Task 1

Задачата с тежестите на думите