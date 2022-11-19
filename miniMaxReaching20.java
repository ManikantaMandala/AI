import java.util.*;
class miniMaxReaching20{
    static int playerZero=0,computerZero=0;
    public static void main(String args[]){
        // int result=0;
        // player =1, computer =-1;
        //playerTurns, computerTurns;
        Scanner sc = new Scanner(System.in);
        int choice=0;
        int sum=0;
        int previousSum=-1;
        int playerTurns=0, computerTurns=0;
        while(sum<21){
            if((playerTurns+computerTurns)%2==0){
                System.out.println("It's player's choice");
                System.out.println("You have the following choices to make");
                if(playerZero==0 && !(sum-previousSum==0)){
                    while(choice!=1 || choice!=2 || choice!=3){
                        System.out.println("1. Remain at "+sum );
                        System.out.println("2. make the sum to "+ (sum+1));
                        System.out.println("3. make the sum to "+ (sum+2));
                        choice=sc.nextInt();
                        if(choice==1){
                            sum=addZero(sum);
                            playerZero++;
                        }
                        else if(choice==2){
                            sum= addOne(sum);
                        }
                        else if(choice==3){
                            sum = addTwo(sum);
                        }
                        else{
                            System.out.println("Your choice is incorrect, Please choose again!");
                        }
                    }
                }
                else{
                    while(choice!=1 || choice!=2){
                        System.out.println("1. make the sum to "+ (sum+1));
                        System.out.println("2. make the sum to "+ (sum+2));
                        choice=sc.nextInt();
                        if(choice==1){
                            sum=addOne(sum);
                        }
                        else if(choice==2){
                            sum= addTwo(sum);
                        }
                        else{
                            System.out.println("Your choice is incorrect, Please choose again!");
                        }
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
        computerZero++;
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