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
the base class is not closed for modification. Here the abstract method is the way for extension of base class.

### 3. Liskov substitution principle
**Definition :** Liskov substitution principle states that we should be able to use subclass or child class object wherever base class object is expected.
And this substitution should not alter desired properties/behaviour of the program.<br>
For an example in simple words, if we have a base class and it is providing us 'xyz' behaviour. Now we replace the object of base class
with an object of child class or subclass, by this substitution the 'xyz' feature must not be changed.<br>

The code present in '[solid - 03.a - liskov-substitution-violation](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/tree/master/solid%2003.a%20-%20liskov-substitution-violation)'
shows the violation of liskov substitution principle. Here we have two classes 'Square.class' and 'Rectangle.class' and we can 
say that square is a special type of rectangle where height and width is always equal. Hence, irrespective of what we are
 setting (height or width) for square we are internally making sure that at all the time both must be equal (by using setSide() method) 
```java
public class Square extends Rectangle{

    public Square(int side) {
        super(side, side);
    }

    public void setWidth(int width) {
        setSide(width);                     // call to setSide() method
    }

    public void setHeight(int height) {
        setSide(height);                    // call to setSide() method
    }

    private void setSide(int side) {
        super.setWidth(side);               // ensuring all side are same alway
        super.setHeight(side);
    }
}
```

As 'Square.class' is extending 'Rectangle.class' hence we will be able to call the calculateArea() method which is defined
in 'Rectangle.class' for square object as-well, and eventually it will return square of side (because height and width are equal)<br>

Now, let's see the method 'useRectangle()' below.
```java
private static void useRectangle(Rectangle rectangle) {
        rectangle.setWidth(10);
        rectangle.setHeight(20);

        if(rectangle.getHeight() == 20)
            System.out.println("Height of rectangle is 20.");
        else
            System.out.println("Height is not 20.");
        if(rectangle.getWidth() == 10)
            System.out.println("Width of rectangle is 10.");
        else
            System.out.println("Width is not 10.");
    }
```
Here we are receiving the object of 'Rectangle' class and as Square is a subclass of rectangle the method will work for 
object of square as well. But when we call the method for any object of Square, it will set width to 10 which will result 
in all sides of square being set to 10 because of setSide() method in square class. And when ```rectangle.setHeight(20);```
will get executed it will set all sides of the square to 20, so the second if block will become false for square object, 
and it will be true for rectangle. Which violates the Liskov substitution principle because by replacing the base class 
object with parent class the behaviour gets changed.<br>

To make this compliant ([solid - 03.b - liskov-substitution-compliant](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/tree/master/solid%2003.b%20-%20liskov-substitution-compliant)) what we did is we created an interface called 'Shape' having calculateArea() method and implemented 
that interface to both Square and Rectangle. So that it will be clear that Rectangle and Square both are shape but one is 
not related to other, and we can't assume that the square is a special type of rectangle and apply same properties as that 
of rectangle to square. By implementing the interface 'Shape' we are ensuring that both the classes provide the implementation 
for calculateArea() method and have area calculation functionality.


### 4. Interface segregation principle
**Definition :** Client must not be forced to depend upon the interfaces (methods defined in the interfaces) that they don't use.

**Import term :**
<br> **Interface pollution :** interface pollution means we must not create the interface bigger, i.e. we should not add methods
which are not related and create a huge interface and make all the classes implement that interface and force them to 
implement the unrelated methods.
<br> It is very easy to identify interface pollution.
<ul>
<li>If any class implementing the interface has empty method.</li>
<li>Method implementation throws UnsupportedOperationException or similar kind of exception.</li>
<li>Method implementation returns null, default value or dummy value.</li>
</ul>
If any of the above scenario is true, then the interface segregation principle is violated.

So in simple words what this principle tells us is, our interfaces must be segregated so that the class need not have to 
implement methods which are not related to that class.

Code in folder '[solid 04.a - interface-segregation-violation](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/tree/master/solid%2004.a%20-%20interface-ssegregation-violation)' 
shows the violation of this principle. In this code we can clearly see that Cat and Fish both the classes implements single
interface 'Action' and because of this both Cat and Fish has to override all the methods in Action interface. Now as we 
know fish can't walk, but still as Fish class is implementing interface Action we have to override walk method in it.
This is where Fish class became dependent on the method which is not at all related to it and this violates the interface 
segregation principle.
```java
public class Fish implements Action{
    @Override
    public String walk() {
        throw new UnsupportedOperationException("This operation is not supported by fish.");
    }

    @Override
    public String makeSound() {
        throw new UnsupportedOperationException("This operation is not supported by fat.");
    }

    @Override
    public String eat() {
        return "Fish is eating her food!";
    }

    @Override
    public String swim() {
        return "The fish is swimming really fast!";
    }
}
```
in above class we can clearly see that Fish class is forced to override walk() and makeSound() method which is not related to 
that class hence we can say that the interface Action is polluted.

<br>Now if we see code in folder '[solid 04.b - interface-segregation-compliant](https://github.com/Akhil-Selukar/SOLID-principles-and-design-patterns/tree/master/solid%2004.b%20-%20interface-segregation-compliant)'
, here we have two different interfaces 'AquaticAnimalActions' which is implemented by Fish class and another is 'TerrestrialAnimalActions'
which is implemented by Cat class. Here both the interfaces has methods related to specific type of animals.
In future if we want to add Dog class which is similar to Cat type then we can use TerrestrialAnimalActions interface and 
If we want to add class like Octopus then we can use AquaticAnimalActions interface, here we are not forcing any class to 
override method which is not related to that class.