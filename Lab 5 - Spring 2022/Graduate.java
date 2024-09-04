//import statements
import java.util.Scanner;
import java.util.Random;
public class Graduate{
//Declare and create a Scanner
static Scanner userinput = new Scanner(System.in);
//Declare and create a Random 
static Random random = new Random();
//Declare and create player one name to store in a string variable
public static String playerOneName;
//Declare and create player two name to store in a string variable
public static String playerTwoName;
//Declare and create player one location to store in a int variable
public static int playerOneLocation;
//Declare and create player Two location to store in a int variable
public static int playerTwoLocation;
//Declare and run boolean
public static boolean run;
//String array containing names of Admissions, the six schools, and Moody 
static String[] buildings = {"Admissions", "Cox School of Business", "Dedman College","Simmons Schools of Education", "Meadows School of the Arts", "Lyle School of Engineering", "Moody"};
public static void main(String[] args) {
    //this will set boolean run to equal true
    run = true;
    //this prints the starting point of the game
    System.out.print("Welcome to the Graduate from SMU Game!");
    System.out.println("");
    System.out.println("");
    //this asks the user name of each player and the scanner saves the name as a string variable
    System.out.print("Enter player 1 name: ");
    playerOneName = userinput.next();

    System.out.print("Enter player 2 name: ");
    playerTwoName = userinput.next();

    //this contain the current location of each player, starting at location 0
    playerOneLocation = 0;
    playerTwoLocation = 0;

    /*this set a while loop in a condition that checks if boolean run equals true then call a boolean method for each players 
    and if boolean run equals false it will break the while loop
    */
    while (run == true) {
        playerOneMethod();
        if(run == false){
            break;
        }
        playerTwoMethod();
        if(run == false){
            break;
        }
        }
        userinput.close();
    } 

public static boolean playerOneMethod(){
    System.out.println(playerOneName + "'s turn. Currently at " + buildings[playerOneLocation]);
              Scanner input= new Scanner(System.in);  
                //Admissions or enrolled if else statenment
                //If current player is at location 0 which returns a boolean                                                                          
                if(playerOneLocation == 0){
                    System.out.print("   Press Enter to roll the dice...");
                    input.nextLine();
                    boolean movedOn = rollDoubles();
                    if(movedOn == true) {
                        System.out.printf("%10s is enrolled at the first school! \n", playerOneName);
                        playerOneLocation ++;
                    }
                    else {
                        
                        System.out.printf("%s is stuck at Admissions \n", playerOneName);
                    }
                }
                //If student already enrolled, then check location of student
                else if(playerOneLocation > 0 && playerOneLocation < 6) {
                    System.out.print("   Press Enter to spin the grade wheel...");
                    
                    input.nextLine();
                    //If player passed, true or false return allowing player to move forward
                    boolean movedOn = attemptPassingGrade();
                    if(movedOn == true) {
                        playerOneLocation++;
                        if(playerOneLocation==6){
                            run = false;
                            System.out.printf("%10s graduated!   Game over. \n", playerOneName);
                            return false;
                        }
                        return true;
                        
                    }
                }
                //Else student has passed more 6 or more, student passes
                else {
                    boolean movedOn = attemptPassingGrade();
                    if(movedOn == true) {
                        run = false;
                        System.out.printf("%10s graduated!   Game over. \n", playerOneName);
                    }
                }
                return false;

}

public static boolean playerTwoMethod(){
    System.out.println(playerTwoName + "'s turn. Currently at " + buildings[playerTwoLocation]);
                Scanner input= new Scanner(System.in);
                //Admissions or enrolled if else statenment
                if(playerTwoLocation == 0){
                    System.out.print("   Press Enter to roll the dice...");
                    input.nextLine();
                    boolean movedOn = rollDoubles();
                    if(movedOn == true) {
                        System.out.printf("%10s is enrolled at the first school! \n", playerTwoName);
                        playerTwoLocation ++;
                        
                    }
                    else {
                        System.out.printf("%s is stuck at Admissions \n", playerTwoName);
                    }
                }
                //If student already enrolled, then check location of student
                else if(playerTwoLocation > 0 && playerTwoLocation < 6) {
                    System.out.print("   Press Enter to spin the grade wheel...");
                    input.nextLine();
                    //If player passed, true or false return allowing player to move forward
                    boolean movedOn = attemptPassingGrade();
                    if(movedOn == true) {
                        playerTwoLocation++;
                        if(playerTwoLocation==6){
                            run = false;
                            System.out.printf("%10s graduated!   Game over. \n", playerTwoName);
                            return false;
                        }
                        return true;
                    }
                }
                //Else student has passed more 6 or more, student passes
                else {
                    boolean movedOn = attemptPassingGrade();
                    if(movedOn == true) {
                        run = false;
                        System.out.printf("%10s graduated!   Game over. \n", playerOneName);
                    }
                }
                return false;

}

public static boolean rollDoubles() {
    //this creates the first dice
    int dice = random.nextInt(6)+1;
    //this creates the second dice
    int diceTwo = random.nextInt(6)+1;
    /*this sees if both are dice equal each other then 
       it will print Rolled the first dice output and the 
       second dice output - doubles!!
       if it doesn't equal then it will print Rolled the first 
       dice output and the second dice output
       */
    if (dice == diceTwo) {
        System.out.println("   Rolled " + dice + " and " + diceTwo + "  - doubles!!");
        return true;
    }
    else{
        System.out.print("   Rolled " + dice + " and " + diceTwo + " - ");
        
        return false;
    }
}

public static boolean attemptPassingGrade() {
    int gradeWheel = random.nextInt(5)+1;
    if (gradeWheel == 1) {
        System.out.println("  Passed - grade A");
        return true;
        }
    else if (gradeWheel == 2){
        System.out.println("  Passed - grade B");
        return true;
        }
    else if (gradeWheel == 3){
        System.out.println("  Passed - grade C");
        return true;
        }
    else if (gradeWheel == 4){
        System.out.println("  Didn't pass - grade D");
        return false;
        }
    else if (gradeWheel == 5) {
        System.out.println("  Didn't pass - grade F");
        return false;
        
    }
    return false;
}
}

