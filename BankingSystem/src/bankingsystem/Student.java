package bankingsystem;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends Thread
{

    ThreadGroup threadGroup;
    CurrentAccount mc;

    public Student(ThreadGroup threadGroup, CurrentAccount mc)
    {
        this.threadGroup = threadGroup;
        this.mc = mc;
    }

    @Override
    public void run()
    {
        System.out.println("Student - Student Thread Started!");
        //Loterry, Deposit into accout ( £20000 )
        Transaction lottery = new Transaction(mc.getAccountHolder(), 15000);
        mc.deposit(lottery);
        try
        {
            Student.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Withdraw, For New Phone ( £2000 )
        Transaction phone = new Transaction(mc.getAccountHolder(), -2000);
        mc.withdrawal(phone);
        try
        {
            Student.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Withdraw, Gym Membership ( £1500 )
        Transaction gymMember = new Transaction(mc.getAccountHolder(), -1500);
        mc.withdrawal(gymMember);
        try
        {
            Student.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Deposit, Money From Pinkybank ( £2000 )
        Transaction pinkyBank = new Transaction(mc.getAccountHolder(), 2000);
        mc.deposit(pinkyBank);
        try
        {
            Student.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Deposit, Money On The Ground ( £50 )
        Transaction someoneElsesMoney = new Transaction(mc.getAccountHolder(), 50);
        mc.deposit(someoneElsesMoney);
        try
        {
            Student.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Withdraw, Shopping ( £250 )
        Transaction shopping = new Transaction(mc.getAccountHolder(), -250);
        mc.withdrawal(shopping);
        try
        {
            Student.sleep((long) (Math.random() * 3000));
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Student - Student Thread Terminated!");
        System.out.println("\nStudent - Printing Statement...");
        mc.printStatement();
    }
}
