## Multithreading and Concurrency Fundamentals


### Concurrency

Nowadays we use computers to do multiple things at once. We browse the web while listening to music, write text documents
while downloading files etc...

If we have a single core CPU we only get to execute a single instruction at any given point in time. At the same time we are able
to run multiple programs and have the feeling that everything is happening at once. This would not have been possible 
if the system was not **concurrent**.  
To have a system that is concurrent means that the system is capable of doing multiple things (not necessarily at once).

### Context Switching

What ends up happening is that the CPU gets a small portion of time to execute instructions of a given task, after which 
it moves on to executing instructions on the next task and so on. This is called **context switching**. 
Thanks to context switching the system is capable of multitasking. 
This creates the illusion that multiple tasks (processes) are executed at the same time.

However, context switching has some overhead. If the CPU is to be switched to work on another task the state of the current 
task needs to be saved, and the state of the next task loaded. This allows for resuming the previous task when the time comes.    
The task's state is actually the **context**. It consists of the CPU's registers and program counter at any point in time.  

You can see this illustrated in the diagram bellow. 

![context_switching_diagram](../../../assets/x03-lecture/context_switching_diagram.png)

> ℹ️ For mor details on how a computer executes instructions watch this [youtube video](https://www.youtube.com/watch?v=XM4lGflQFvA).


Concurrency is about dealing with lots of things at once. Parallelism is about doing lots of things at once.

![concurrency_vs_parallelism](../../../assets/x03-lecture/concurrency_vs_parallelism.png)