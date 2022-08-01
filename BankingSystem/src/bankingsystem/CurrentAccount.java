package bankingsystem;

public class CurrentAccount implements BankAccount
{

    private int balance;
    private String name;
    private int accNum;
    Statement accountState;

    public CurrentAccount(int accNum, String name, int balance)
    {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
        this.accountState = new Statement(name, accNum);
    }

    @Override
    public synchronized int getBalance()
    {
        return balance;
    }

    @Override
    public synchronized int getAccountNumber()
    {
        return accNum;
    }

    @Override
    public synchronized String getAccountHolder()
    {
        return name;
    }

    @Override
    public synchronized void deposit(Transaction t)
    {
        // TODO Auto-generated method stub
        if (t.getAmount() > 0)
        {
            balance = balance + t.getAmount();
            accountState.addTransaction(t.getCID(), t.getAmount(), balance);
            System.out.println("£" + t.getAmount() + " Deposit successful");

        } else
        {
            System.out.println("£" + t.getAmount() + " Deposit failed");
        }
        notifyAll();
    }

    //Checks to see if balance is more than 0
    //if balance is less wait would be activated and will have to wait for 
    //A notify all
    @Override
    public synchronized void withdrawal(Transaction t)
    {
        
            try
            {
                if ((balance + t.getAmount()) >= 0 & t.getAmount() < 0)
                {
                    balance = balance + t.getAmount();
                    accountState.addTransaction(t.getCID(), t.getAmount(), balance);
                    System.out.println("£" + (-t.getAmount()) + " Withdrawal successful");
                } else
                {
                    System.out.println("Waiting to withdraw funds of £" + (-t.getAmount()) + "!");
                    while (balance + t.getAmount() < 0)
                    {
                        wait();
                    }
                    balance = balance + t.getAmount();
                    accountState.addTransaction(t.getCID(), t.getAmount(), balance);
                    System.out.println("£" + (-t.getAmount()) + " Withdrawal successful");
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        } 

    //Not used
    @Override
    public synchronized boolean isOverdrawn()
    {
        if (balance < 0)
        {
            return true;
        } else
        {
            return false;
        }

    }

    @Override
    public synchronized void printStatement()
    {
        accountState.print();

    }

}
