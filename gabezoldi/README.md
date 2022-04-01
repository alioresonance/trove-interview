# Trove QA Interview Take Home Assignment

**Setup**
1. Install Chrome Browser: https://www.google.com/chrome/
2. Install JDK 11: https://www.oracle.com/java/technologies/downloads/#java11
3. Install Git: https://git-scm.com/download
4. Install Maven 3: https://www.baeldung.com/install-maven-on-windows-linux-mac   https://maven.apache.org/download.cgi#
5. [Optional] Install IntelliJ (Free Community Edition): https://www.jetbrains.com/idea/download

**Running Test**
1. Open Terminal (mac) or Git Bash (windows) window and run commands...
```
mkdir github
cd github
git clone https://github.com/alioresonance/trove-interview.git
cd trove-interview/gabezoldi
mvn clean install
mvn test
```



![gravity-image](gcc.jpg)

# Screenplay Pattern with Serenity BDD

This project is a simple demonstration showing the difference between
the [PageObject](http://martinfowler.com/bliki/PageObject.html)
and the [Screenplay pattern](https://dzone.com/articles/page-objects-refactored-solid-steps-to-the-screenp),
both implemented using the [Serenity BDD](http://serenity-bdd.info/#/) library and JUnit.

The web tests you'll find here run against the http://todomvc.com/examples/angularjs/#/ application and are organised
by feature in packages under `src/test/java/net/serenitybdd/demos/todos/<pattern name>/features`.

By default the tests run on Chrome, so make sure you have the latest chromedriver instance on your system path.

## PageObjects implementation

These tests use trove.qa.pageobject and trove.qa.steps defined in `src/main/java/net/serenitybdd/demos/todos/pageobjects`.

The overall project structure is shown below:

````
+ trove.qa.model
    Domain trove.qa.model classes
+ trove.qa.pageobject
    PageObjects
+ trove.qa.steps
    Tasks and assertions performed by the "user"
````

## Screenplay implementation

These tests use tasks, actions, questions and page elements defined in `src/main/java/net/serenitybdd/demos/todos/screenplay`.

The overall project structure is shown below:

````
+ trove.qa.model
    Domain trove.qa.model classes
+ tasks
    Business-level tasks
+ action
    UI interactions
+ trove.qa.pages
    Page Objects and Page Elements
+ questions
    Objects used to query the application
````

## Running the project

To run the project you'll need JDK 1.8 and Maven installed.

### Screenplay and Cucumber

The first demo shows the integration of Serenity BDD, Screenplay and Cucumber JVM.
To run it, execute:

```
mvn clean verify -Pcucumber
```

### Screenplay and JUnit Demo

The second demo covers the integration of Serenity BDD, Screenplay and JUnit.

To run it, execute:

```
mvn clean verify -Pscreenplay
```

### Page Objects and JUnit Demo

We've also included a demo of how the tests you've just seen implemented using the Screenplay Pattern
would have looked if they were implemented using the Page Objects.

To run it, execute:

```
mvn clean verify -Ppageobjects
```

## Trove Tests

There are also Tests implemented using the Screenplay Pattern.

To run it, execute:

```
mvn clean verify -Ptrove
```

## 

## Reporting

The Serenity reports will be generated in the `target/site/serenity` directory.
