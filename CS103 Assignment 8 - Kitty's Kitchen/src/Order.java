import java.text.NumberFormat;

/**
 * This class holds the information pertaining to a sales order
 * @author Adam Holt
 * @date 12/4/13
 */
public class Order implements Comparable<Object>
{

    //Data member declarations
    private double purchase, discount; //subtotal purchase amount and discount for this order
    private final double TAX = .06; //sales tax rate
    private int customerNumber, orderNumber; //customer number for this order and current order number

    /**
     * Default Constructor
     */
    public Order()
    {
	//Set all data members to 0
	setCustomerNumber(0);
	setPurchase(0);
	setOrderNumber(0);
	setDiscount(0);
    }

    /**
     * Constructor takes values to set data members
     * @param c Customer number
     * @param p Purchase subtotal
     * @param o Order number
     * @param d Discount percent
     */
    public Order(int c, double p, int o, double d)
    {
	//Set data members to passed values
	setCustomerNumber(c);
	setPurchase(p);
	setOrderNumber(o);
	setDiscount(d);
    }

    /**
     * Set the order number
     * @param o Order number
     */
    public void setOrderNumber(int o)
    {
	orderNumber = o;
    }

    /**
     * Get the order number
     * @return Order number
     */
    public int getOrderNumber()
    {
	return orderNumber;
    }

    /**
     * Set the customer number
     * @param c Customer number
     */
    public void setCustomerNumber(int c)
    {
	customerNumber = c;
    }

    /**
     * Get the customer number
     * @return Customer number
     */
    public int getCustomerNumber()
    {
	return customerNumber;
    }

    /**
     * Set the purchase subtotal
     * @param p Purchase subtotal
     */
    public void setPurchase(double p)
    {
	purchase = p;
    }

    /**
     * Get the purchase subtotal
     * @return Purchase subtotal
     */
    public double getPurchase()
    {
	return purchase;
    }

    /**
     * Get the current tax rate
     * @return Tax rate
     */
    public double getTaxPercent()
    {
	return TAX;
    }

    /**
     * Get the tax amount in dollars
     * @return Tax amount in dollars
     */
    public double getTax()
    {
	return getTaxPercent() * getDiscountedTotal();
    }

    /**
     * Set the discount percent
     * @param d Discount percent
     */
    public void setDiscount(double d)
    {
	discount = d;
    }

    /**
     * Get the discount percent
     * @return Discount percent
     */
    public double getDiscountPercent()
    {
	return discount;
    }

    /**
     * Get the discount amount in dollars
     * @return Discount amount in dollars
     */
    public double getDiscount()
    {
	return purchase * getDiscountPercent();
    }

    /**
     * Get the subtotal after the discount had been applied
     * @return Discounted subtotal
     */
    public double getDiscountedTotal()
    {
	return purchase - getDiscount();
    }

    /**
     * Add the tax to the discounted total
     * @return Grand total of the sale after discount and tax
     */
    public double getTotalSale()
    {
	return getDiscountedTotal() + getTax() ;
    }

    /**
     * Convert the order to a String
     */
    public String toString()
    {
	//Number formats for output
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	NumberFormat pfmt = NumberFormat.getPercentInstance();

	return "Order #: " + getOrderNumber() +
		"\nCustomer #: " + getCustomerNumber() +
		"\nPurchase amount: " + fmt.format(getPurchase()) + 
		"\nDiscount: " + pfmt.format(getDiscountPercent()) + " " + fmt.format(getDiscount()) +
		"\nTax: " + pfmt.format(getTaxPercent()) + " " + fmt.format(getTax()) + 
		"\nFinal cost: " + fmt.format(getTotalSale());
    }

    /**
     * Compare the current order to a passed order
     * @return 1 if the current order number is greater than the passed order, -1 if it is less, and 0 if they are equal
     */
    public int compareTo(Object order)
    {
	if(getOrderNumber() > ((Order)order).getOrderNumber())
	    return 1;
	else if(getOrderNumber() < ((Order)order).getOrderNumber())
	    return -1;
	else
	    return 0;
    }
}