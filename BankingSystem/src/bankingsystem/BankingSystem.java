package bankingsystem;

import java.lang.*;

public class BankingSystem
{

    public static void main(String[] args)
    {
        //Account Creation
        CurrentAccount acc = new CurrentAccount(0, "Harrie", 0);
        
        //Thread Groups
        ThreadGroup Family = new ThreadGroup("Family");
        ThreadGroup Study = new ThreadGroup("Study");

        //Define student, grandmother, loan, university classes with respected
        //Student
        Student student = new Student(Family, acc);
        System.out.println("Student - Student Object Created.");
        
        //Grandmother
        Grandmother grandmother = new Grandmother(Family, acc, "Grandmother");
        System.out.println("Grandmother - Grandmother Object Created.");
        
        //Loan Company
        LoanCompany loan = new LoanCompany(Study, acc, "Loan Payment");
        System.out.println("Loan Company - Loan Company Object Created.");
        
        //University
        University uni = new University(Study, acc, "University");
        System.out.println("University - University Object Created. ");
        System.out.println("==================================================\n");
        
        //Thread start
        student.start();
        grandmother.start();
        loan.start();
        uni.start();

        
        
        
        
        //Waits for threads to finish then executes the print statement
        while (true)
        {
            if (!student.isAlive() & !grandmother.isAlive() & !loan.isAlive() & !uni.isAlive())
            {
                acc.printStatement();
                break;
            }

        }

    }
}
