package com.philumni.lemonade;


public class Economy {

	
	// Default prices
	public static final float SUGAR_COST=10.99F;
	public static final float WATER_COST=1.39F;
	public static final float CUP_COST=3.98F;
	public static final float ICE_COST=2.19F;
	public static final float LEMON_COST=0.68F;
	
	// Quantity of lemonade cups per purchase.
	public static final int SUGAR_CUPS=80;
	public static final int WATER_CUPS=8;
	public static final int CUP_CUPS=50;
	public static final int ICE_CUPS=20;
	public static final int LEMON_CUPS=1;
	
	/*
	 * Lemonade is made with about 1 cup of sugar per gallon of water.
	 * which is (8) 16oz cups of lemonade.
	 * 
	 * Sugar is sold by 10lb bags for about $10.99. It gives you
	 * 22.5 cups of sugar.
	 * 
	 * To keep things simple we'll say each bag gives you 22 cups of 
	 * sugar, which is 80 cups of lemonade.
	 * 
	 * One gallon of drinking water is about $1.39.
	 * It gives you 8 cups of lemonade.
	 * 
	 * Solo cups can be purchased 50 ct for $3.98.
	 *
	 * A 10 lb bag of ice is about $2.19 from the grocery store.
	 * To keep things simple, we'll use about 8 ounces of ice per
	 * 16oz cup. That means each bag of ice will net us 
	 * 20 cups of lemonade.
	 * 
	 * Lemons cost about $0.68 each, and they are 1 per cup of
	 * lemonade.
	 * 
	 * 
	 * Accordingly, when the player buys $10.99 worth of sugar,
	 * the game will say he has 80 cups of lemonade, for sugar.
	 * 
	 * And when the player buys one gallon of drinking water,
	 * the game will say he has 8 cups of lemonade, for water.
	 * 
	 * And when the player buys 50 ct of solo cups, the game
	 * will say he has 50 cups of lemonade, for cups.
	 * 
	 * And when the player buys 10lbs of ice, the game will say
	 * the player has 20 cups of lemonade, for ice.
	 * 
	 * And when they player buys 1 lemon, the game will say the
	 * player has 1 cup of lemonade, for lemons.
	 * 
	 * For the purposes of the game, the prices will
	 * fluctuate and give the player a sense of strategy.
	 * 
	 * 
	 * Sugar $10.99/80 = 13.7 cents per cup.
	 * Water $1.39/8 = 17.3 cents per cup.
	 * Cup $3.98/50 = 8.0 cents per cup.
	 * Ice $2.19/20 = 11.0 cents per cup.
	 * Lemon $0.68/1 = 68.0 cents per cup.
	 * 
	 * In total, each cup costs %1.18 to make.
	 * Since we want to make a profit,
	 * we will charge $1.50 per cups of lemonade.
	 * 
	 * It will take about 1000 cups of lemonade to reach
	 * the $1500 mark.
	 * 
	 * 
	 * Due to demand, we do not think you can sell more than
	 * about 40 per turn (i.e. a day).
	 * 
	 */
	
	private float sugarPrice;
	private float waterPrice;
	private float cupPrice;
	private float icePrice;
	private float lemonPrice;
	

	public float getSugarPrice() {
		return sugarPrice;
	}

	public void setSugarPrice(float sugarPrice) {
		this.sugarPrice = sugarPrice;
	}

	public float getWaterPrice() {
		return waterPrice;
	}

	public void setWaterPrice(float waterPrice) {
		this.waterPrice = waterPrice;
	}

	public float getCupPrice() {
		return cupPrice;
	}

	public void setCupPrice(float cupPrice) {
		this.cupPrice = cupPrice;
	}

	public float getIcePrice() {
		return icePrice;
	}

	public void setIcePrice(float icePrice) {
		this.icePrice = icePrice;
	}

	public float getLemonPrice() {
		return lemonPrice;
	}

	public void setLemonPrice(float lemonPrice) {
		this.lemonPrice = lemonPrice;
	}

	
	
	
	public void generatePrices() {
		// Setup the prices for supplies.
		
		setSugarPrice(getPricing(Economy.SUGAR_COST));
		setWaterPrice(getPricing(Economy.WATER_COST));
		setCupPrice(getPricing(Economy.CUP_COST));
		setIcePrice(getPricing(Economy.ICE_COST));
		setLemonPrice(getPricing(Economy.LEMON_COST));
	}
	
	private float getPricing(float defaultCost)
	{
		float lowEnd=(1.0F-0.4F) * defaultCost;
		float highEnd=(1.2F) * defaultCost;
		return getRandomPriceRange(lowEnd,highEnd);
	}
	
	private float getRandomPriceRange(float lowEnd, float highEnd)
	{
		// First we want to convert this into integers of pennies.
		// Essentially.
		lowEnd *=100;
		highEnd *=100;
		
		int lowEndPennies = (int)lowEnd;
		int highEndPennies = (int)highEnd;
		
		
		int result = getRandomRangeInt(lowEndPennies,highEndPennies);
		return (float)result/100;
	}

	private int getRandomRangeInt(int lowEndInt, int highEndInt) {
		return (int)Math.floor(Math.random()*(highEndInt-lowEndInt+1))+lowEndInt;
	}

	
	public String getSugarInfo()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Sugar -- $" + getSugarPrice() + " per 10lb bag. ");
		sb.append("This makes " + Economy.SUGAR_CUPS + " cups.\n");
		return sb.toString();
	}
	
	public String getWaterInfo()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Water -- $" + getWaterPrice() + " per 1 gallon. ");
		sb.append("This makes " + Economy.WATER_CUPS + " cups.\n");
		return sb.toString();
	}

	public String getCupsInfo()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Cups -- $" + getCupPrice() + " per bag. ");
		sb.append("This makes " + Economy.CUP_CUPS + " cups.\n");
		return sb.toString();
	}

	public String getIceInfo()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Ice -- $" + getIcePrice() + " per 10lb bag. ");
		sb.append("This makes " + Economy.ICE_CUPS + " cups.\n");
		return sb.toString();
	}
	
	public String getLemonsInfo()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Lemons -- $" + getLemonPrice() + " per lemon. ");
		sb.append("This makes " + Economy.LEMON_CUPS + " cups.\n");
		return sb.toString();
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("The following prices are in effect.\n");
		sb.append("**********************************\n");
		sb.append(getSugarInfo());
		sb.append(getWaterInfo());
		sb.append(getCupsInfo());
		sb.append(getIceInfo());
		sb.append(getLemonsInfo());
		sb.append("\n");
		return sb.toString();
	}
		

}
