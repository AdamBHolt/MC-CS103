/**
 * Specialized version of BankAccount class
 * Adds fee for withdrawing funds
 * @date 11/4/13
 * @author Adam Holt
 */
public class CheckingAccount extends BankAccount
{
    private static final double FEE = .15;

    /**
     * Default constructor
     */
    public CheckingAccount()
    {
	super();
    }
    
    /**
     * Constructor takes accountholder name and initial amount
     * @param name Accountholder name
     * @param amount Initial account amount
     */
    public CheckingAccount(String name, double amount)
    {
	super(name, amount);
	setAccountNumber(getAccountNumber() + "-10");
    }
    
    /**
     * Withdraw from current account
     * Returns true if the withdraw was successful or false if not
     * Overrides the superclass method
     */
    public boolean withdraw(double amount)
    {
	amount += FEE;
	return super.withdraw(amount);
    }
}
