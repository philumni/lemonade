package com.philumni.lemonade;

public class Sale {

	public static final int TYPICAL=40;
	private static final float PRICE=1.50F;
	
	public int getSold() {
		return sold;
	}


	public void setSold(int sold) {
		this.sold = sold;
	}


	public float getRevenue() {
		return revenue;
	}


	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}



	private int sold=0;
	private float revenue=0F;
	
	
	public void processSales(Supplies supplies) {
		
		int minimum = getMinimum(supplies);

		if (Sale.TYPICAL<minimum) minimum = Sale.TYPICAL;
		
		supplies.setSugar(supplies.getSugar()-minimum);
		supplies.setWater(supplies.getWater()-minimum);
		supplies.setCups(supplies.getCups()-minimum);
		supplies.setIce(supplies.getIce()-minimum);
		supplies.setLemons(supplies.getLemons()-minimum);
		
		float revenue = minimum*Sale.PRICE;
		
		setSold(minimum);
		setRevenue(revenue);
		
		supplies.setMoney(floatAdd(supplies.getMoney(),revenue));
		}


	private float floatAdd(float f, float g) {

		int a = (int) Math.round(f*100.0);
		int b = (int) Math.round(g*100.0);
		return (float) ((a+b)/100.0);
	}


	private int getMinimum(Supplies supplies) {
		int minimum = supplies.getSugar();
		
		if (supplies.getWater()<minimum) minimum = supplies.getWater();
		if (supplies.getCups()<minimum) minimum = supplies.getCups();
		if (supplies.getIce()<minimum) minimum = supplies.getIce();
		if (supplies.getLemons()<minimum) minimum = supplies.getLemons();
		
		return minimum;
	}

	public String getReport() {
		// TODO Auto-generated method stub
		return "This is a sample report.\n";
	}

	
	
}

