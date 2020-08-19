## 1. Java Generics

## X. Concurrency


## Wikipedia Article Crawler

Build a web application that can find the Wikipedia articles that are referencing a given topic.

**Example**  
The Wiki article [Pizza](https://en.wikipedia.org/wiki/Pizza) is referenced by the articles
[Pizzeta](https://en.wikipedia.org/wiki/Pizzetta), [Italian Cuisine](https://en.wikipedia.org/wiki/Italian_cuisine)
[Fast Food](https://en.wikipedia.org/wiki/Fast_food) etc...

In short the article `A` is considered referenced by `B` when `B` has a link pointing to `A`.

The application should have a simple WEB UI that supports the following functionality:
1. The user should be able to submit an article for analysis (like Pizza).
2. The user can view an already analysed article and which articles are pointing to it. 

There are a few technical requirements:
1. The API used for article analysis should not block until the analysis finishes. Instead, it should return immediately when the request is accepted for processing.
2. There should be clear indication if an article is in a `PENDING`, `PROCESSING`, `COMPLETE` or `FAILED` state.
    

### Guidelines
- You are free to use any web-server. However, I do recommend using SpringBoot as the setup is fairly simple.  
You can use [Spring Initializer](https://start.spring.io/) to set up the project. I recommend the following dependencies: 
    - Maven - use maven as a build tool
    - Thymeleaf - as a template engine
    - Spring Data JPA - as a database access layer
    - Spring Web - the required tooling to build web apps
    - You are free to use any database. However, I do recommend using a relation in memory database like H2 in order to avoid local set up of a DB.

- Try to model the entire article analysis process as a system composed of several independent stages.  
**Example**  
1. Accept the article for processing
2. Retrieve article content and extract links
3. Start processing links and upon each link completion store relevant information


### Quick links

- [Wikipedia API](https://www.mediawiki.org/wiki/API:Main_page)
- [Api Sandbox](https://www.mediawiki.org/wiki/Special:ApiSandbox#action=query&list=search&srsearch=meaning)
- Example Query
```
https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&page=pizza
```