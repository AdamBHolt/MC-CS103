//The purpose of this class is to model a television
//Adam Holt 9/25/13
public class Television
{
	final private String MANUFACTURER;	//Manufacturer of the television
	final private int SCREEN_SIZE;		//Size of the television screen
	private boolean powerOn;			//Determines whether the power is on or off
	private int channel;				//The current channel
	private int volume;					//The current volume level
	
	//The constructor initializes the manufacturer and screen size with supplied values
	//The power is initially set to off, the initial volume is 20, and initial channel is 2
	public Television(String man, int size)
	{
		MANUFACTURER = man;
		SCREEN_SIZE = size;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	/**
	 * Returns the current volume of the television
	 * @return Current volume
	 */
	public int getVolume()
	{
		return volume;
	}
	
	/**
	 * Returns the current channel of the television
	 * @return Current channel
	 */
	public int getChannel()
	{
		return channel;
	}
	
	/**
	 * Returns the manufacturer of the television
	 * @return Television manufacturer
	 */
	public String getManufacturer()
	{
		return MANUFACTURER;
	}
	
	/**
	 * Returns the screen size of the television
	 * @return Television screen size
	 */
	public int getScreenSize()
	{
		return SCREEN_SIZE;
	}
	
	/**
	 * Sets the current channel of the television
	 * @param chan The new channel to set
	 */
	public void setChannel(int chan)
	{
		channel = chan;
	}
	
	/**
	 * Toggles the television power on or off
	 */
	public void power()
	{
		powerOn = !powerOn;
	}
	
	/**
	 * Increases the volume by 1
	 */
	public void increaseVolume()
	{
		volume++;
	}
	
	/**
	 * Decreases the volume by 1
	 */
	public void decreaseVolume()
	{
		volume--;
	}
}
