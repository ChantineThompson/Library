# Library
This library was created to compute statistics based on an inputted text file. It computes the number of words, number of lines, average letters per word and the most common letter.

### Build and Run
Make sure the .jar file is located in the class path of the java project you want to implement this in.

At the top of your code with your other dependencies, type:
```
import Library.Library;
```

From here you can create an instance of this library and run the different methods. 
```
Library newLib = new Library();
File filename = new File("test.txt");
newLib.wordCount(filename);
```

To compile and run your program through command line, you can use this to compile including the Library dependency: 
```
javac -cp "locationOfJarFile/lib.jar" program.java 
```
Then you can run it through: 
```
java -cp "locationOfJarFile/lib.jar" program
```
### Design decisions
- Adding error handling on all methods in case the file does not exist/is non-readable.
- Had each calculation in its own method. This was to increase code readability and to also allow the user to choose which specific statistic they would like to see. 
- Created an all statistics method to run all methods at once, if the user does want all statistics.
- Made methods public due to testing and the need to be accessible for library usage. 





