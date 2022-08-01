package bankingsystem;
import java.util.logging.Level;
import java.util.logging.Logger;
public class LoanCompany extends Thread
{
    ThreadGroup threadGroup;
    CurrentAccount mc;
    String name;
    public LoanCompany( ThreadGroup threadGroup,CurrentAccount mc, String name)
    {
        this.threadGroup = threadGroup;
        this.mc = mc;
        this.name = name;
    }
        
    @Override
    public void run()
    {
        System.out.println("\nLoan Company - Thread Started!\n");
        for(int i = 0; i< 4; i++){
            Transaction loanPayment = new Transaction(name, 7000);
            mc.deposit(loanPayment);
            try
            {
                Student.sleep((long)(Math.random() * 3000));
            } catch (InterruptedException ex)
            {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("\nLoan Company - Loan Company Thread Terminated!\n");
                
    } 
}
