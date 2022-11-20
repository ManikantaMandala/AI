import java.util.*;
class miniMaxReaching20{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int choice=0;    // three cases 1,2
        int sum=0;     // choice + previoussum
        int previousSum=-1;  // choice of the last player to add the choice of current player
        int playerTurns=0, computerTurns=0;
        while(sum<=20){
            if((playerTurns+computerTurns)%2==0){
                System.out.println("It's player's choice");
                System.out.println("You have the following choices to make");
                    while(choice!=1 || choice!=2){
                        System.out.println("1. make the sum to "+ (sum+1));
                        System.out.println("2. make the sum to "+ (sum+2));
                        choice=sc.nextInt();
                        previousSum=sum;
                        if(choice==1){
                            sum=addOne(sum);
                            break;
                        }
                        else if(choice==2){
                            sum= addTwo(sum);
                            break;
                        }
                        else{
                            System.out.println("Your choice is incorrect, Please choose again!");
                        }
                    }
                System.out.println("Now the sum is "+ sum);
                playerTurns++;
            }
            else{
                System.out.println("It's computer's choice");
                computerChoice(previousSum, sum);
                System.out.println("Now the sum is "+ sum);
                computerTurns++;
            }
        }
        sc.close();
    }
    public static int computerChoice(int previousSum,int sum){
        // the algorithm goes here!
        previousSum=sum;

        // Do operations


        //TODO: First lets try with minimax algorithm!
        //TODO: Then we can apply Alpha-beta pruning!
        return sum;
    }

    public static int addZero(int result){
        return result;
    }
    public static int addOne(int result){
        return (result+1);
    }
    public static int addTwo(int result){
        return (result+2);
    }


    // public static int reaching20(int sum,int result){
    //     //player should take a move.
    //     //should check the previous player used the zero.
    //     //And only once the player can use this in the whole game.
    //     //computer should take a move by alpha-beta pruning and print the results in the every iteration or the recursion!
    //     Scanner sc = new Scanner(System.in);
    //     if(result==20){

    //     }
    //     System.out.println("Please enter your choice");
    //     int previousChoice=choice;
    //     choice=sc.nextInt();
    //     if(choice==0){
    //         if(previousChoice==0){}
    //     }
    //     else if(choice==1){
    //         addOne(result);
    //     }
    //     else if(choice==2){
    //         addTwo(result);
    //     }
    //     else{
    //         System.out.println("can't choose above one");
    //     }
    //     sc.close();
    //     return result;
    // }
}