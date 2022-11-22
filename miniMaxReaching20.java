import java.util.*;
class miniMaxReaching20{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int choice=0;    // three cases 1,2
        int sum=0;     // choice + previoussum
        int playerTurns=0, computerTurns=0; //playerTurns and computerTurns
        while(sum<=20){
            if((playerTurns+computerTurns)%2==0){
                System.out.println("It's player's choice");
                System.out.println("You have the following choices to make");
                    while(choice!=1 || choice!=2){
                        System.out.println("1. make the sum to "+ (sum+1));
                        System.out.println("2. make the sum to "+ (sum+2));
                        choice=sc.nextInt(); //choice
                        if(choice==1){
                            sum=addOne(sum);//adds one to the sum
                            break;
                        }
                        else if(choice==2){
                            sum= addTwo(sum); //adds two to the sum
                            break;
                        }
                        else{
                            System.out.println("Your choice is incorrect, Please choose again!");// if not selected 1 or 2 options
                        }
                    }
                System.out.println("Now the sum is "+ sum); //sums will be printed
                playerTurns++; //playTurns will be increased
            }
            else{
                System.out.println("It's computer's choice");
                sum=computerChoice(sum);
                System.out.println("Now the sum is "+ sum); //sums will be printed
                computerTurns++; //computerTurns will be increased
            }
        }
        sc.close();
    }
    public static int computerChoice(int sum){ //gives the optimized option for the computer to choose using alphabeta
        Alphabeta ab= new Alphabeta(); //object of Alphabeta
        return ab.run(sum);
    }
    public static int addOne(int result){ //returns one the result
        return (result+1);
    }
    public static int addTwo(int result){ //returns two the result
        return (result+2);
    }
}