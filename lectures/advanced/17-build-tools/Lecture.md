## Build Tools

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
 
There are a lot of different build tools out there each one suitable for a different language or use case.
Some popular Java build tools are **Gradle**, **Maven** and **Ant**.

![ant_gralde_maven](../../../assets/x02-lecture/ant_gradle_maven.png)

Each has its pros and cons. 
- **Ant's** focus is on writing scripts that can be executed.
- **Maven** provides strong typing, structure, rich community and relies mainly on configurations.
- **Gradle** is a mix of both Ant and Maven providing flexibility in writing tasks and some structure to the project.

In this course we will be using Maven as it is a well-established build tool and has
a lot of tutorials on it and problems can be more easily solved.

### Maven
 
As mentioned earlier Maven is build tool that can be used via the command line.  

##### Installation
You can download the binary zip archive from [here](https://maven.apache.org/download.cgi#files).
After which you should extract the archive and add the *bin* directory to your `PATH` environment variable.  
After you complete the steps check that open a terminal and type `mvn -v`. If the maven version is printed you have  
configured everything successfully. 

**Cheat Sheet**  
- [Guide](https://docs.oracle.com/en/database/oracle/r-enterprise/1.5.1/oread/creating-and-modifying-environment-variables-on-windows.html)
 on how to set up an Environment Variable on Windows. 
 NOTE: the way the `PATH` variable is configured may vary depending on the Windows version you are running. 
 On some versions you would need to add `;` at the end of the variable after which set a new value. On other versions
 you can add a new row for the variable.
- [Guide](https://docs.oracle.com/cd/E19062-01/sun.mgmt.ctr36/819-5418/gaznb/index.html)
 on how to set up the `PATH` variable on Linux.
- [Guide](https://www.cyberciti.biz/faq/appleosx-bash-unix-change-set-path-environment-variable/)
 on how to setup the `PATH` variable on OS X.
- These are the official installation [docs](https://maven.apache.org/install.html). 

#### Creating a maven project

Each maven project can be identified by a **groupId** (this usually is the company or domain name)
and **artifactId** (this is the actual project name). A project also has a version. 

Here is an example configuration.

```xml
<groupId>com.mycompany.app</groupId>
<artifactId>my-app</artifactId>
<version>1.0-SNAPSHOT</version>
```
> Note that the configuration uses XML. We will touch on that later.

Here is an example command on how to create a new project:

```shell script
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```
> archetype:generate tels maven to create a new project (archetype) there are also som additional flags that determine the actual archetype template.

After executing the command a new directory with the provided **artifactId** will be created.
In it you can find the `src` directory and a `pom.xml` file.

#### pom.xml

The pom file is the maven project configuration. The project can be divided into 3 major parts.
- **project properties** - The project properties can be used to create variables that can be reused in the configuration.
- **dependencies** - Used for listing the artifacts (libraries) that the project requires.
- **build** - Used to describe packaging type and including plugins.

By using maven as a build tool we get to use the so called **build lifecycle**. It is composed of a set of phases (steps).  
The default build cycle consists of 7 phases:  
**validate** --> **compile** --> **test** --> **package** --> **verify** --> **install** --> **deploy** 
Each phase of the lifecycle is dependent on the previous one.

#### Plugins

Maven comes with a standard set of phases. However, using plugins more phases can be added.
The plugin needs to be configured in the `<plugins></plugins>` section of the pom file.
Just by listing the plugin, maven will take care of downloading it and applying it.
[Here](http://maven.apache.org/plugins/) you can find some plugins that maven supports. 
However, there are other open-source plugins available or if something is missing you can always write your own.

#### Maven Repository

By listing the artifact dependencies of a project maven is capable of downloading the dependencies and 
the dependencies of the dependencies and so on. This is possible due to a centralized maven repository 
[Maven Central](https://mvnrepository.com/repos/central).
A developer is capable of publishing different version of an artifact to the repository which will 
then become available to other maven users.  

Maven allows for working on closed source projects as well. For this reason a custom central repository can be hosted
with limited access. Maven can be configured to publish and retrieve dependencies from it.

Any dependencies that are downloaded are cached locally on the machine. Have this in mind the first time you run a maven command.
This will trigger a download and will slow down the process. Subsequent executions will be faster because of the cached dependencies.
Usually the cache is located at `~/.m2`.

> Build tools like Gradle also use the centralized maven repository to resolve dependencies.

ℹ️ For more detailed information checkout the official 
[Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html) guide.