/*
 * The Worker class is dedicated for each individual worker.
 * each employee is set with their specific names and the number of days they have worked consecutively
 * Weather an employee can work or not is determined by
 * the number of consecutive days, which must be less than or
 * equal to 5 in order to work. Otherwise, they are deemed ineligible.
 */
import java.util.*;

public class Worker
{
    private static ArrayList<Worker> workerList = new ArrayList<Worker>(); // list of all 49 employees
    private static ArrayList<Worker> limitList = new ArrayList<Worker>(); // holds the employees that have reached 5-day limit

    private String name;
    private int consec_days;
    private static boolean canwrk;

    public Worker(String name, int consec_days)
    {
        this.name = name;
        this.consec_days = consec_days;
        workerList.add(this);
        if(consec_days < 5)
        {
            canwrk = true;
        }
        else
        {
            canwrk = false;
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getDays(){
        return this.consec_days;
    }

    public static void resetDays(Worker emp)
    {
        emp.consec_days = 0;
    }
    
    public static void addDay(Worker emp)
    {
        emp.consec_days+=1;
    }
    
    public static boolean canWork(Worker emp)
    {
        if(emp.consec_days <= 5)
        {
            canwrk = true;
        }
        else
        {
            canwrk = false;
        }
        return canwrk;
    }

    //loops through workerList and prints names of workers with consecutive days less than 5
    //should print out precisely 32 names
    //one day is added after printing so they can be updated accordingly
    public static void printCan()
    {
        int count = 0;
        for(int i = 0; i < workerList.size(); i++)
        {
            if(canWork(workerList.get(i)))
            {
                if(count == 32)
                {
                    break;
                }
                System.out.println(workerList.get(i).getName());
                count++;
            }
        }
    }
    //Loops through workerList just like printCan except checks if the consectuive days worked
    //is greater than the 5-day restriction. Should print precisely 17 names
    public static void printCant()
    {
        int count = 0;
        for(int i = 33; i < workerList.size(); i++)
        {
            if(canWork(workerList.get(i)))
            {
                if(count == 32)
                {
                    break;
                }
                System.out.println(workerList.get(i).getName());
                count++;
            }
        }
    }
    
    //find the worker entered by the manager - go through every worker in workerList
    //if the name of the worker does not exist in the list, then they should be prompted to try again or quit.
    //else it should return a sentence with the name of the worker, their number of consecutive working days, and the number of days until their break
    public static void findWorker(String name){
        boolean fail = true;
        for(Worker emp: workerList){
            if(name.equals(emp.getName())){
                fail = false;
                System.out.println(name + " has worked " + emp.getDays() + " days, so they can work " + (5-emp.getDays()) + " more days before taking a break.");
                break;
            }
        }
        if(fail){
            System.out.println("The name you entered unfortunately does not exist.");
            Scanner input = new Scanner(System.in);
            String answer = "";
            System.out.println("[t]ry again or quit?");
            answer = input.nextLine();
            if(answer.equals("t")){
                System.out.println("Enter the name of the employee.");
                name = input.nextLine();
                for(Worker emp: workerList){
                    if(name.equals(emp.getName())){
                        fail = false;
                        System.out.println(name + " has worked " + emp.getDays() + " days, so they can work " + (5-emp.getDays()) + " more days before taking a break.");
                        break;
                    }
                }
            }
            else{
                System.out.println("Ok returning back to main hub.");
            }
        }
        System.out.println();
    }

    public static void showSchedule()
    {
        for(int i = 0; i < 7; i++)
        {
            //Prints out the days of the week first and foremost before displaying the workers who will work
            if(i+1 == 1)
            {
                System.out.println("Monday\n");
            }
            else if(i+1 == 2)
            {
                System.out.println("Tuesday\n");
            }
            else if(i+1 == 3)
            {
                System.out.println("Wednesday\n");
            }
            else if(i+1 == 4)
            {
                System.out.println("Thursday\n");
            }
            else if(i+1 == 5)
            {
                System.out.println("Friday\n");
            }
            else if(i+1 == 6)
            {
                System.out.println("Saturday\n");
            }
            else if(i+1 == 7)
            {
                System.out.println("Sunday\n");
            }

            //print out the names of who can work today - uses printCan() function
            //go through limit list to give wokrers a break
            //resets the people who did not work that day so they can come in for work the next day
            int count = 0;
            if(i>0)
            {
                for(int d =0; d< limitList.size(); d++)
                {
                    resetDays(limitList.get(d));
                    workerList.add(limitList.get(d));
                    limitList.remove(d);
                }
            }
            for(int z = 0; z < workerList.size(); z++)
            {
                if(canWork(workerList.get(z)))
                {
                    if(count == 32)
                    {
                        break;
                    }
                    System.out.println(workerList.get(z).getName());
                    addDay(workerList.get(z));
                    
                    if(workerList.get(z).getDays() > 5)
                    {
                        limitList.add(workerList.get(z));
                        workerList.remove(z);
                    }
                    
                    count++;
                }
            }
            if(i==4 || i==5)
            {
                limitList.add(workerList.get(0));
                workerList.remove(0);
            }

            System.out.println();

            //since everyone started working at different times, in order to better simulate reality the program shows workers having more than just one day of a break due to there only being 32 jobs available for 49 people. therefore, some ppl will have consecutive breaks
        }
    }
}
