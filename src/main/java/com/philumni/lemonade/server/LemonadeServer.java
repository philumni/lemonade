package com.philumni.lemonade.server;

import com.philumni.lemonade.Economy;
import com.philumni.lemonade.Lemonade;
import com.philumni.lemonade.Supplies;

/* 
 * This class should expose the functionality needed for a web server.
 */
public class LemonadeServer {

	boolean started;
	
	
	Lemonade l;
	
	public void start() {
		started=true;
		
	}

	public void startNewGame(String name) {
		l=new Lemonade(name);
		
	}

	public String prepareTurn() {
		   return l.prepareTurn();
	}

	public Supplies getSupplies()
	{
		return l.getSupplies();
	}

	public Economy getEconomy()
	{
		return l.getEconomy();
	}

	public String finishTurn() {
		return l.finishTurn();
	}
	
	
	public String getSugarInfo() {
		return l.getEconomy().getSugarInfo();
	}
	public String getWaterInfo() {
		return l.getEconomy().getWaterInfo();
	}
	public String getCupsInfo() {
		return l.getEconomy().getCupsInfo();
	}
	public String getIceInfo() {
		return l.getEconomy().getIceInfo();
	}
	public String getLemonsInfo() {
		return l.getEconomy().getLemonsInfo();
	}
	
	
	public boolean canBuySugar(int quantity)
	{
		return l.canBuySugar(quantity);
	}
	
	public boolean canBuyWater(int quantity)
	{
		return l.canBuyWater(quantity);
	}
	
	public boolean canBuyCups(int quantity)
	{
		return l.canBuyCups(quantity);
	}
	
	public boolean canBuyIce(int quantity)
	{
		return l.canBuyIce(quantity);
	}
	
	public boolean canBuyLemons(int quantity)
	{
		return l.canBuyLemons(quantity);
	}

	
	public String buySugar(int quantity) {
		return l.buySugar(quantity);
	}

	public String buyWater(int quantity) {
		return l.buyWater(quantity);
	}

	public String buyCups(int quantity) {
		return l.buyCups(quantity);
	}

	public String buyIce(int quantity) {
		return l.buyIce(quantity);
	}

	public String buyLemons(int quantity) {
		return l.buyLemons(quantity);
	}

	public String getWin() {
		return l.getWin();
	}

	public String getLoss() {
		return l.getLoss();
	}

	public boolean checkLoss() {
		return l.checkLoss();
	}

	public boolean checkWin() {
		return l.checkWin();
	}

	public float getMoney() {
		return l.getMoney();
	}
}
