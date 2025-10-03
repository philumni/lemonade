package com.philumni.lemonade;

public class Supplies {

	
	// supplies are represented as possible cups of lemonade.
	private int sugar=0;
	private int water=0;
	private int cups=0;
	private int ice=0;
	private int lemons=0;
	
	public final static float STARTING_MONEY=50.00F;
	
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	private float money=Supplies.STARTING_MONEY;
	
	public int getSugar() {
		return sugar;
	}

	public int getWater() {
		return water;
	}

	public int getCups() {
		return cups;
	}

	public int getIce() {
		return ice;
	}

	public int getLemons() {

		return lemons;
	}

	
	
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public void setCups(int cups) {
		this.cups = cups;
	}

	public void setIce(int ice) {

		
		this.ice = ice;
	}

	public void setLemons(int lemons) {
		this.lemons = lemons;
	}
	
	
	public void addSugar(int cups)
	{
		sugar+=cups;
	}

	public void addWater(int cups)
	{
		water+=cups;
	}
	
	public void addCups(int cups)
	{
		this.cups+=cups;
	}
	
	public void addIce(int cups)
	{
		this.ice+=cups;
	}
	
	public void addLemons(int cups)
	{
		this.lemons+=cups;
	}
	
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("You have the following effective supplies:");
		sb.append("\nSugar: " + getSugar());
		sb.append("\nWater: " + getWater());
		sb.append("\nCups: " + getCups());
		sb.append("\nIce: " + getIce());
		sb.append("\nLemons: " + getLemons());
		sb.append(String.format("\n\nMoney: $%.2f",getMoney()));
		sb.append("\n");
		return sb.toString();
	}
	
	
	
	
	
	
	
}
