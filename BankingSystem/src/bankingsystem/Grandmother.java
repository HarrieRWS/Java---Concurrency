package bankingsystem;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Grandmother extends Thread
{
    ThreadGroup threadGroup;
    CurrentAccount mc;
    String name;
    public Grandmother( ThreadGroup threadGroup,CurrentAccount mc, String name)
    {
        this.name = name;
        this.mc = mc;
        this.threadGroup = threadGroup;
    }
        
    @Override
    public void run()
    {
        System.out.println("\nGrandmother - Grandmother Thread Has Started! \n");
        //Deposit, Christmas
        Transaction Deposit = new Transaction(name, 500);
        mc.deposit(Deposit);
        try
        {
            Student.sleep((long)(Math.random() * 3000));
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Deposit, Birthday
        Transaction Birthday = new Transaction(name, 5000);
        mc.deposit(Birthday);
        try
        {
            Student.sleep((long)(Math.random() * 3000));
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }   
        System.out.println("\nGrandmother - Grandmother Thread Terminated! \n");
    } 
}
