**Spring MVC and Hibernate Store project**

I created this project to help further learn the Spring and Hibernate framework.

This projects will be an online store that allows customers to 
login, view all products, filter products, and add orders based on the products that the users have selected.

This project isn't a real-world example but the purpose is for me to further enhance my knowledge of the Spring MVC and Hibernate framework.

I am working with adding Hazelcast for in-memory caching distribution across multiple clusters.

I am also adding a Metrics to this application. This will allows an admin user to view all hit counts for all of the rest URLS.
The purpose of this is to show web pages that are the most viewed and least viewed. 

After gathering these statistics, certain actions to make for your website. (Ex. If a most viewed page is buried in the navigation. This can be brought up front for even more views.))

In the future, I want to be able to display these metrics into an internal REST endpoint that only the admin user can view.

I am still working on these unit and integration test as I learned how to test using the Spring MVC framework.

There is also logging that used for testing to make sure everything works. I have insecure logs statements such as getting a person's Id from the database and their name.
I left these in for my testing purposes. I will remove them eventually when I created all the unit and integration tests to ensure everything works properly.

**Java Classes** - This folder shows all the classes for this projects.(excluding test classes. There are located in the separate folder). This is so anyone can see all the classes with digging deep to the src folder to find these classes.
I also have **Test Classes** - This folder shows the test classes including integration and unit tests.

**Documents** - This folder will contain documentation of this project. For now, this folder includes the requirements and test cases for this Spring MVC Store project.
 
Additional documentation including UML diagrams, flowchart diagram, will be added later.