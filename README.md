This project is intended for POJO Implementation in Rest API using Rest Assured library.

To understand it more clearly lets take one example, 

{
"message":"HI",
"id": 101,
"name": "Welcome"
}

This is out response JOSON received in Get request,
Now, to access these details either we can use "JSonPath" or use POJO classes.

If we use JSonPath then it will be Json all over the methods and code looks complex. To solve this we will use POJO implementation.

What is POJO - It is Plain Old Java Object which means you can create class with all the objects in the JSON response, use GSON dependency  which will do the job for us by converting Json object to our class getter and setters.

So in above mentioned example we will create class with any name and then create 'private' fields in it such as 

private String name;
private int id;
private String message;

make sure that you name the fields same as present in your JSON,

then create getter and setter of it. 

After this in you test you can use this Class and its getter, setter to use the values of Json,

In this way we avoided the direct use of JSOn in our test and can use the same class objects for different test cases.





