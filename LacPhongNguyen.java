import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 */
public class LacPhongNguyen extends Student implements SpecialInterestOrHobby, NumberOfSiblings
{

    /**
     * Constructor for the LacPhongNguyen class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public LacPhongNguyen(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public LacPhongNguyen() {
        firstName="Lac-Phong";
        lastName="Nguyen";
        myRow=3;
        mySeat=1;
       //imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the LacPhongNguyen actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to play basketball, volleyball, and Nintendo games!");
            // Create a "special method for your class and put the call here.
            // Call the sitDown() method to move back  to your seat
            
                circleClass();  // LacPhongNguyen's special method... Please write one of your own. You can use this, but please modify it and be creative.
            }
            else {
                answerQuestion();//calls answerQuestion method, just prompts the user to ask Lac-Phong questions
                sitDown();//calls sitDown method to make LacPhong Nguyen sit down
            }
                    
        }
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("I " + firstName + " " + lastName+ " have a dream");//introduces LacPhong Nguyen
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public int numberOfSiblings(){
        return 2;//number of siblings LacPhong has
    }
    public int numberOfBrothers(){
        return 1;//number of brothers LacPhong has
    }
    public int numberOfSisters(){
        return 1;//number of sisters LacPhong has
    }
    public void answerQuestion(){
        String q=Greenfoot.ask("What would you like to know?");//asks user what he/she/it would like to know
        q.toLowerCase();//makes answers all lowercase
        if (q.contains("hard")){//lists all the stuff LacPhong found hard about the CSA summer hw
            q=Greenfoot.ask("I found inheritance a bit confusing as well as the binary and merge sorts, interfaces, recursion, and DeMorgan's Law... May I sit down?");
            q.toLowerCase();
            if (q.contains("inheritance")){//if user specifically mentions inheritance LacPhong will explain
                q=Greenfoot.ask("Inheritance is a mechanism in Java where a subclass will inherit the characteristics of its superclass. The way the teacher was explaining it was a little hard to understand and I had to replay the videos several times because it was so hard to pay attention to her... May I sit down?");
                q.toLowerCase();
                if (q.contains("yes")){//if user allows LacPhong to sit down, LacPhong sits down
                    Greenfoot.delay(10);//delays code
                    sitDown();
                }
                else {//if user inputs none of the above it will reexecute answerQuestion method
                answerQuestion();
            }
            }
            if (q.contains("binary")||q.contains("merge")){
                q=Greenfoot.ask("Binary Search is a way to sort an array through repeatedly dividing the search interval half. A merge sort is a divide and conquer algorithm where it divides the array into two halfs repeatedly until the array is fully sorted... May I sit down?");
                q.toLowerCase();
                if (q.contains("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
                else {
                answerQuestion();
            }
            }
            if (q.contains("interface")){//if user mentions interface
                q=Greenfoot.ask("The interface is a mechanism in java that serves as a blueprint of a class which contains static constants and abstract methods. They can only contain abstract methods... May I sit down?");
                q.toLowerCase();
                if (q.contains("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
                else {
                    answerQuestion();
                }
            }
            if (q.contains("recursion")){//if user mentions recursion
                q=Greenfoot.ask("Recursion is the process in which a method calls itself continuously. This makes the code more comact, but somewhat more complex to understand... May I sit down?");
                q.toLowerCase();
                if (q.contains("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
                else {
                    answerQuestion();
                }
            }
            if (q.contains("demorgan")){//if user mentions demorgan
                q=Greenfoot.ask("Demorgan's Law basically describes how mathematical statements and concepts are related through their opposites. This was a little confusing to me because some interactions between certain symbols like greater than and less than were a bit confusing... May I sit down?");
                q.toLowerCase();
                if (q.contains("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
                else {
                    answerQuestion();
                }
            }
        }
        if (q.contains("siblings")){//if user mentions siblings, code utilizes interface NumberOfSiblings to answer
            q=Greenfoot.ask("I have " + numberOfSiblings() + " but I like to consider by 2 other cousins as siblings because I have lived with them for my entire life... May I sit down?");
            q.toLowerCase();
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            else {
                answerQuestion();
            }
        }
        if (q.contains("brother")){//if user mentions brother, code utilizes interface NumberOfSiblings to answer
            q=Greenfoot.ask("I have only " + numberOfBrothers() + " brother... May I sit down?");
            q.toLowerCase();
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            else {
                answerQuestion();
            }
        }
        if (q.contains("sister")){//if user mentions sister, code utilizes interface NumberOfSiblings to answer
            q=Greenfoot.ask("I have only " + numberOfSisters() + " sister... May I sit down?");
            q.toLowerCase();
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            else {
                answerQuestion();
            }
        }
        if ((q.contains("hi"))||(q.contains("hello"))){//if user says hi or hello, LacPhong responds
            q=Greenfoot.ask("Well hello there! I'm Lac-Phong Nguyen. How are you?");
            q.toLowerCase();
            if (q.contains("good")){//if user says they're doing good LacPhpong responds
                q=Greenfoot.ask("Cool, but I don't care.");
                sitDown();
            }
            if (q.contains("bad")){//if user says they're doing bad LacPhong responds
                q=Greenfoot.ask("Feelsbadman. Sucks to be you :P");
                sitDown();
            }
        }
        else {//if user doesn't input any of the above LacPhong responds
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
            }
            else {
                answerQuestion();
            }
            
        }
         
        
    }
    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You can write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        int[][] list = new int[10][10];//creates a 2d array named list
        for (int i=0;i<10;i++){//loops through list and adds in random integers
            for (int n=0;n<10;n++){
            list[i][n] = (int)Math.random()*10+1;//Math.random from 1-10
        }
       }
        setLocation(1,3);//sets LacPhong to coordinate (1,3)
        Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i,3);//iterates through x values from 1-9
            turn(100);//spins LacPhong
            Greenfoot.delay(6);
        }
        // move back
        for (int i=5;i<=5;i++){
            setLocation(9,i);//iterates through y values
            turn(100);//turns LacPhong
            Greenfoot.delay(6);
        }      
         // move left
        for (int i=5;i>=1;i--){
            setLocation(i,5);//iterates through x values backwards from 5-1
            turn(100);//turns LacPhong
            Greenfoot.delay(6);
        }      
              // move Forward
        for (int i=5;i>=3;i--){
            setLocation(1,i);//iterates through y values backwards from 5-3
            turn(100);//turns LacPhong
            Greenfoot.delay(6);
        }
        for (int i=0; i<10;i++){
            turn(list[i][i]);//iterates through the 2d array list for random values to make LacPhpong spin
            Greenfoot.delay(6);
            turn(-(list[i][i]));//iterates through the 2d array list for random values to make LacPhpong spin
            Greenfoot.delay(6);
        }
        
        for (int i=0; i<25;i++){
            returnToSeat(list[5][5]);
            GreenfootImage image = getImage();//gets image for Greenfoot
            image.scale((image.getWidth()+3),(image.getHeight()+3));//makes images grow
            Greenfoot.delay(6);
            returnToSeat(-(list[5][5]));//returns LacPhong to original orientation
            Greenfoot.delay(6);
            
            
        }
        
        
}
     public void myHobby(String s) {
         System.out.println(s);
}

}