### Build Tools

![toolkit](../../../assets/x02-lecture/toolkit.jpg)

Writing the software is just the first step. Machines do not understand high level written code. Instead, they
execute machine instructions. As we know the compiler is responsible for compiling the high level code to lowe level code
(in the case of Java to byte code). Often the code base relies on external libraries. Compiling this by hand is cumbersome. 
This is just once of the problems that build tools solve. They can handle compiling both the source code and external dependencies.  

Other use cases can include:
 - Downloading and caching dependencies.
 - Resolving library version conflicts. For example library `A` depends on library `B v1`. Library `C` depends on library `B v2`.
 Your code depends both on `A` and `C`. In this case the library version of `B` needs to be resolved.
 - Automating various tasks like running tests.
 - Packaging the compiled code. In the case of Java the code can be packaged into a `jar` file. 
 
 The list goes on.
 
 ### Java Build Tools
 
 Java 