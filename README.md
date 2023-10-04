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
