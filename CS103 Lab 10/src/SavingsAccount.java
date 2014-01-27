/**
 * Specialized version of BankAccount class
 * Provides interest methods and ability to create
 * multiple accounts with the same accountholder
 * @date 11/4/13
 * @author Adam Holt
 */
public class SavingsAccount extends BankAccount
{
    //Instance variable declarations
    private double rate = 2.5;
    private int savingsNumber = 0;
    private String accountNumber;
    
    /**
     * Default constructor
     */
    public SavingsAccount()
    {
	super();	
    }
    
    /**
     * Constructor takes accountholder name and initial amount
     * @param name Accountholder name
     * @param amount Initial account amount
     */
    public SavingsAccount(String name, double amount)
    {
	super(name, amount);
	accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	
    }
    
    /**
     * Copy constructor uses passed SavingsAccount object
     * to create a new SavingsAccount with the same accountholder
     * and a new account number
     * @param oldAccount Original SavingsAccount object
     * @param amount Initial account amount
     */
    public SavingsAccount(SavingsAccount oldAccount, double amount)
    {
	//Call superclass copy constructor
	super(oldAccount, amount);
	//Set the subclass variable to the superclass value + the savings account number
	accountNumber = super.getAccountNumber() + "-" + ++savingsNumber;
    }
    
    /**
     * Add monthly interest to the account value
     */
    public void postInterest()
    {
	setBalance(getBalance() + (getBalance() * ((rate/100)/12)));
    }
    
    /**
     * Returns the account number for the current SavingsAccount object
     * Overrides superclass method
     * @return The current account number
     */
    public String getAccountNumber()
    {
	return accountNumber;
    }
}