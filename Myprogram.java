/*
    enter ! to end, make a while loop
        end with have a nice day!
    Program made for Post Office Manager. When run the program
    brings up 
*/
import java.util.*;

public class Myprogram {
    public static void main(String[] args) 
    {
        // First we must make 49 instances of the worker class
        // This will represent the 49 total employees at the local post office

        // Note: Random name generator was used to adhere to federal confidentiality
        // Also note that consecutive days for each worker was randomized to represent the variety of availability. No more than 17 workers will have 5 consecutive days.
        Worker emp1 = new Worker("John Doe", 0);
        Worker emp2 = new Worker("Ryan Byte", 5);
        Worker emp3 = new Worker("Marilena Bianco", 0);
        Worker emp4 = new Worker("Artur Ventura", 2);
        Worker emp5 = new Worker("Farohildis Kermit", 5); 
        Worker emp6 = new Worker("Blandina Bachchan", 1);
        Worker emp7 = new Worker("Arnsteinn Bernard", 5);
        Worker emp8 = new Worker("Houssam Ó hAonghuis", 2);
        Worker emp9 = new Worker("Kimber Chaudhary", 1);
        Worker emp10 = new Worker("Séaghdha White", 5);
        Worker emp11 = new Worker("Maynard Bartosz", 1);
        Worker emp12 = new Worker("Eduard Fujita", 1);
        Worker emp13 = new Worker("Nyongesa Pavletić", 5);
        Worker emp14 = new Worker("Maela Machado", 3);
        Worker emp15 = new Worker("Seán Angelov", 0);
        Worker emp16 = new Worker("Aoibheann Curtis", 5);
        Worker emp17 = new Worker("Sujata Schumacher", 2);
        Worker emp18 = new Worker("Asha Van Aller", 3);
        Worker emp19 = new Worker("Suzanne Melo", 1);
        Worker emp20 = new Worker("Cəmilə Dirkx", 5);
        Worker emp21 = new Worker("Shoshana Althaus", 5);
        Worker emp22 = new Worker("Sherry Karimi", 0);
        Worker emp23 = new Worker("Wilhelmus Ventimiglia", 3);
        Worker emp24 = new Worker("Dominykas Yang", 5);
        Worker emp25 = new Worker("Þórgnýr Mateus", 4);
        Worker emp26 = new Worker("Maynard Uehara", 1);
        Worker emp27 = new Worker("Dunja Winther", 5);
        Worker emp28 = new Worker("Chukwuebuka Weiß", 3);
        Worker emp29 = new Worker("Maïa Christiansen", 2);
        Worker emp30 = new Worker("Olusola Dahl", 4);
        Worker emp31 = new Worker("Laius Jordà", 2);
        Worker emp32 = new Worker("Kegan Presley", 5);
        Worker emp33 = new Worker("Katheryne Trent", 5);
        Worker emp34 = new Worker("Carlene Joiner", 2);
        Worker emp35 = new Worker("Harlee Spencer", 0);
        Worker emp36 = new Worker("Bryn Richard", 2);
        Worker emp37 = new Worker("Becci Abrahams", 4);
        Worker emp38 = new Worker("Celinda Kerr", 5);
        Worker emp39 = new Worker("Norah Burns", 4);
        Worker emp40 = new Worker("Macauley Jervis", 5);
        Worker emp41 = new Worker("Corynn Caulfield", 0);
        Worker emp42 = new Worker("Jaime Harrelson", 0);
        Worker emp43 = new Worker("Treasure Abbey", 1);
        Worker emp44 = new Worker("Leith Kitchens", 5);
        Worker emp45 = new Worker("Linsay Herman", 2);
        Worker emp46 = new Worker("Lennox Upton", 5);
        Worker emp47 = new Worker("Bethanie Falkner", 4);
        Worker emp48 = new Worker("Jazmine Tupper", 3);
        Worker emp49 = new Worker("Lesleigh Niles", 5);

        Scanner input = new Scanner(System.in);
        String choice = "";
        System.out.println();        
        System.out.println("Good Day to you manager! Are you ready to start planning?");
        while(choice != "!")
        {
            System.out.println("What would you like to do? (enter '!' to end session)");
            System.out.println("[v]iew who can and cannot work today");
            System.out.println("[s]ee a specific worker's details");
            System.out.println("[m]anage who will work this week");

            choice = input.nextLine();
            //checks if the user's choice is valid and prompts them to try again 
            //if the response is incompatible with the program
            
            //If the response is deemed valid, then we check to see
            //which of the valid responses was chose by the user.
            if(choice.equals("!"))
            {
                System.out.println("Have a nice day manager, until next time!");
                break;
            }
            else if(choice.equals("v"))
            {
                System.out.println("Right away!");

                System.out.println();
                System.out.println("Here is a list of who will work today:");
                //print out name list of who could be working(32)
                Worker.printCan();
                
                System.out.println();
                System.out.println("Here is a list of who will not work today:");
                //print out name list of the 17 employees not working
                Worker.printCant();

                System.out.println();
            }
            else if(choice.equals("s"))
            {
                System.out.println("Right away!");
                System.out.println();
                System.out.println("Enter the name of the employee:");
                choice = input.nextLine();
                
                Worker.findWorker(choice);


            }
            else if(choice.equals("m"))
            {
                Worker.showSchedule();
            }
            else
            {
                System.out.println("Your answer is invalid. Please try again.");
                continue;
            }
        }
    }
}
