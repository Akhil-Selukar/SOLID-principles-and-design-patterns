# SOLID-principles-and-design-patterns

**Solid Principles :** SOLID is actually an acronym which represent 5 different design principles
<ol>
<li>Single responsibility principle</li>
<li>Open close principle</li>
<li>Liskov substitution principle</li>
<li>Interface segregation principle</li>
<li>Dependency inversion principle</li>
</ol>

*Note: There are not the only design principles you need to know, but these are one of the most important ones.*
<br><br>
**The example code mentioned in respective sections below or in the repository are just to explain the concepts, they might not follow proper coding structure or the best practice.*
<hr>

### 1. Single responsibility principle
**Definition :** Single responsibility principle tells us that there should never be more than one reason for a class to change.<br>
In simple word, a class must provide very focused functionality, or it should address a very specific concern of the desired functionality.<br>
For example, let's say we have written a big code in a single class and that code communicate with server or another microservice. 
Now as all the code is present in a single calss, there can be multiple reasons which can cause changes in the code/class, like
<ul>
<li>Messaging format changes i.e. initially we were sending the request payload in JSON format, and now we have to send in XML format.</li>
<li>Parameter in the payload changes, i.e. we are sending additional information/fields in payload like Authentication parameter.</li>
</ul>

So in such cases, our code which is written in a single class is going to be changed. 
Means there are more than one reason which can cause changes in the class, this is what single responsibility principle suggest to avoid.
If we have 2 different responsibilities then we must have two different classes to handle those responsibilities so that whenever something is changed, 
we can change our code in systematic manner.<br><br>


To understand actual code which demonstrate the violation of single responsibility violation principle see the code in '[solid - 01.a - single-responsibility-violation](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/tree/master/solid%20-%2001.a%20-%20single-responsibility-violation)' project.<br><br>
*Note : consider this as a spring boot mvc code where the request to controller is considered to be generated from main method and 
in place of storing the comment data in database we have mocked the data with hashMap*

if you see *[CommentController.class](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/blob/master/solid%20-%2001.a%20-%20single-responsibility-violation/src/main/java/com/solid/principles/controller/CommentController.java)* the 
logic to validate the payload is implemented in the controller itself, also we are creating the comment object from JSON payload as well in the controller
<br><br>
Validation logic:
```java
private boolean validateComment(Comment comment) {
        if(!isPresent(comment.getMessage())) {
            return false;
        }
        if(comment.getAuthor() == null || comment.getAuthor().trim().length() == 0) {
            return false;
        }
        return true;
    }

    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }
```
<br>
Creating object from JSON payload:

```java
ObjectMapper mapper = new ObjectMapper();
Comment comment = mapper.readValue(payloadJson, Comment.class);
```

so if the validation rules changes or if the parsing mechanism changes, or we changed payload from json to some other form, all this
scenarios will cause changes in controller class. Means controller class has more than one responsibility which is violating the 
single responsibility principle. Ideally responsibility of controller must br to rout the request to appropriate service/business logic in service layer.<br><br>

Now, consider the code in '[solid - 01.b - single-responsibility-compliant](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/tree/master/solid%20-%2001.b%20-%20single-responsibility-compliant)' project.
Here controller class only is routing the request to the service layer, service layer has only business logic, 
validation logic is transferred to the util package (PayloadValidator.class) and repository class only have one responsibility 
to store data in database. Here each and every layer or class is focused on only one functionality and if anything changes 
then we can specifically change the code inside respective class.

### 2. Open close principle
**Definition :** Open close principle states that the software entities like method, class or modules should be open for 
extension but close for modification.<br>
In simple word it means if we have a base class completely working and tested then we should be able to extend that class
to add new behaviors or override the methods (i.e. open for extension), but we must not modify the code written in base 
class because that is already tested and working. By changing base class code we might break some other functionality.
<br>

The code present in '[solid - 02.a - open-close-violation](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/tree/master/solid%2002.a%20-%20open-close-violation)'
describes the code which violates the open close principle. Here for both Tata Nexon and Honda Activa we have declared engine type, seating capacity,
number of wheels and showroom price, also we have a method to calculate on road price for both of them. 
Those methods have their own implementation. Here we can clearly see that we are repeating most of the code so what 
we can do is crete a base class which has all the above-mentioned property and add an abstract method to calculate on road price
as shown in '[solid - 02.b - open-close-compliant](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/tree/master/solid%2002.b%20-%20open-close-compliant)'
By this what we are doing is we have our base class which can be extended by another classes and add extra fields or 
functionalities, meaning open for extension. But at the same time we don't have to change the base class to add any other vehicle, meaning 
the base class is not closed for modification.