package com.philumni.lemonade;


public class Lemonade {


	static final float FINISH=550.00F;

	String name="";
	Economy economy;
	Supplies supplies;
	Sale sale;


	int turn=0;
	
	
	public float getMoney() {
		return supplies.getMoney();
	}

	public void setMoney(float money) {
		supplies.setMoney(money);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getTurn() {
		return turn;
	}

	public void incrementTurn()
	{
		turn++;
	}

	
	public Lemonade(String name)
	{
		economy = new Economy();
		supplies = new Supplies();
		this.name=name;
	}
	

	public String prepareTurn() {
		incrementTurn();
		economy.generatePrices();
		
		String result = getEconomy().toString() + "\n" + getSupplies().toString();
		return result;
	}
	
	public String finishTurn() {
		return doSale() + String.format("Day %d is finished.\n\n", getTurn());
	}

	
	public boolean checkWin()
	{
		if (getMoney()>=Lemonade.FINISH) return true;
		return false;
	}
	
	public boolean checkLoss()
	{
		boolean noSugar=supplies.getSugar()==0;
		boolean noWater=supplies.getWater()==0;
		boolean noCups=supplies.getCups()==0;
		boolean noIce=supplies.getCups()==0;
		boolean noLemons=supplies.getCups()==0;
		
		boolean cantBuySugar = !canBuySugar(1);
		boolean cantBuyWater = !canBuyWater(1);
		boolean cantBuyCups = !canBuyCups(1);
		boolean cantBuyIce = !canBuyIce(1);
		boolean cantBuyLemons = !canBuyLemons(1);
		
		if (noSugar && cantBuySugar) return true;
		if (noWater && cantBuyWater) return true;
		if (noCups && cantBuyCups) return true;
		if (noIce && cantBuyIce) return true;
		if (noLemons && cantBuyLemons) return true;
		
		return false;
	}
	
	
	private void spend(float tender) {
		this.setMoney(this.getMoney()-tender);
	}

	public String doSale() {
		sale = new Sale();
		sale.processSales(this.supplies);
		String result = String.format("You've sold %d cups of lemonade!\n",sale.getSold()) +
		String.format("You've also made $%.2f. You're now at $%.2f.\n\n", sale.getRevenue(), supplies.getMoney());		
		return result;
	}

	public Supplies getSupplies() {
		return supplies;
	}

	public Economy getEconomy() {
		return economy;
	}
	
	public boolean canBuySugar(int quantity)
	{
		float price = quantity * economy.getSugarPrice();
		if (price<=getMoney()) return true;
		else return false;
	}
	
	public boolean canBuyWater(int quantity)
	{
		float price = quantity * economy.getWaterPrice();
		if (price<=getMoney()) return true;
		else return false;
	}

	public boolean canBuyCups(int quantity)
	{
		float price = quantity * economy.getCupPrice();
		if (price<=getMoney()) return true;
		else return false;
	}
	
	public boolean canBuyIce(int quantity)
	{
		float price = quantity * economy.getIcePrice();
		if (price<=getMoney()) return true;
		else return false;
	}
	public boolean canBuyLemons(int quantity)
	{
		float price = quantity * economy.getLemonPrice();
		if (price<=getMoney()) return true;
		else return false;
	}
	

	public String buySugar(int quantity)
	{
		float cost = quantity * economy.getSugarPrice();
		if (cost>getMoney()) throw new IllegalArgumentException("Not enough money.");
		
		spend(cost);
		int effective = quantity * Economy.SUGAR_CUPS;
		supplies.addSugar(effective);
		
		String result = 
		String.format("You spent $%.2f.\n",  cost) + 
		String.format("you gained %d cups worth of sugar.\n",  effective);
		return result;
		
	}
	
	public String buyWater(int quantity)
	{ 
		float cost = quantity * economy.getWaterPrice();
		if (cost>getMoney()) throw new IllegalArgumentException("Not enough money.");
		
		spend(cost);
		
		int effective = quantity * Economy.WATER_CUPS;
		supplies.addWater(effective);
		
		String result = 
		String.format("You spent $%.2f.\n",  cost) + 
		String.format("you gained %d cups worth of water.\n",  effective);
		return result;
		
	}

	public String buyCups(int quantity)
	{
		float cost = quantity * economy.getCupPrice();
		if (cost>getMoney()) throw new IllegalArgumentException("Not enough money.");
		
		spend(cost);
		int effective = quantity * Economy.CUP_CUPS;
		supplies.addCups(effective);
		
		String result = 
		String.format("You spent $%.2f.\n",  cost) + 
		String.format("you gained %d cups worth of cups.\n",  effective);
		return result;
	}

	public String buyIce(int quantity)
	{
		float cost = quantity * economy.getIcePrice();
		if (cost>getMoney()) throw new IllegalArgumentException("Not enough money.");
		
		spend(cost);
		
		int effective = quantity * Economy.ICE_CUPS;
		supplies.addIce(effective);
		
		String result = 
		String.format("You spent $%.2f.\n",  cost) + 
		String.format("you gained %d cups worth of ice.\n",  effective);
		return result;
 	}

	public String buyLemons(int quantity)
	{
		float cost = quantity * economy.getLemonPrice();
		if (cost>getMoney()) throw new IllegalArgumentException("Not enough money.");
		
		spend(cost);
		int effective = quantity * Economy.LEMON_CUPS;
		supplies.addLemons(effective);
		
		String result = 
		String.format("You spent $%.2f.\n",  cost) + 
		String.format("you gained %d cups worth of lemons.\n",  effective);
		return result;
	}

	public String getWin() {
		StringBuilder sb = new StringBuilder();
		sb.append("Hooray you've won!\n");
		sb.append(String.format("You beat the game in %d days.\n", getTurn()) );
		sb.append("Where are you going to spend all that moolah?\n");
		return sb.toString();
	}

	public String getLoss() {
	
		StringBuilder sb = new StringBuilder();
		sb.append("We regret to inform you that you cannot continue.\n");
		sb.append("You can always try again! Better luck next time.\n");
		sb.append("Regards.\n");
		return sb.toString();
	}
}
