package com.philumni.lemonade.client;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.philumni.lemonade.server.LemonadeServer;

public class LemonadeClient {

	LemonadeServer ls;
	Scanner scanner = new Scanner(System.in);
	
	/*
	 * This coupling is to allow for the command line to use a web server 
	 * business logic.
	 */
	public LemonadeClient(LemonadeServer ls) {
		this.ls=ls;
	}

	public void start() {
		// TODO Auto-generated method stub
		ls.startNewGame("Phil");
		
		while(true)
		{
			log(ls.prepareTurn());
			
			if (ls.checkLoss()) doLoss();
		
			promptSugar();
			promptWater();
			promptCups();
			promptIce();
			promptLemons();
			
			log(ls.finishTurn());
			
			if (ls.checkWin()) doWin();
		}
	}

	
	private void log(String text)
	{
		System.out.println(text);
	}
	
	private void log()
	{
		System.out.println();
	}
	
	
	// Prompt and make sure they don't try to buy too much/many.
	private void promptSugar()
	{
		log();
		log("How much sugar would you like to buy?");
		
		log(ls.getSugarInfo());
		
		int quantity = getInputInt();
		
		// skip
		if (quantity==0) return;
		
		// Recover from bad input.
		if (quantity==-1)
		{
			promptSugar();
			return;
		}
		
		
		if ( ! ls.canBuySugar(quantity))
		{
			if (ls.canBuySugar(1)) 
			{
				// Repeat until they get it right :)
				log("The quantity is too high.");
				promptSugar();
				return;
			}
			
			// Can't buy any so we shall skip.
			else return;
		}
		
		String result=ls.buySugar(quantity);
		log(result);
	}
	
	private void promptWater()
	{
		log();
		log("How much water would you like to buy?");
		
		log(ls.getWaterInfo());
		
		int quantity = getInputInt();
		
		// skip
		if (quantity==0) return;

		// Recover from bad input.
		if (quantity==-1)
		{
			promptWater();
			return;
		}
		
		
		if ( ! ls.canBuyWater(quantity))
		{
			if (ls.canBuyWater(1)) 
			{
				// Repeat until they get it right :)
				log("The quantity is too high.");
				promptWater();
				return;
			}
			
			// Can't buy any so we shall skip.
			else return;
		}
		
		String result=ls.buyWater(quantity);
		log(result);
	}
	
	private void promptCups()
	{
		log();
		log("How many cups would you like to buy?");
		
		log(ls.getCupsInfo());
		
		int quantity = getInputInt();
		
		// skip
		if (quantity==0) return;

		// Recover from bad input.
		if (quantity==-1)
		{
			promptCups();
			return;
		}
		
		
		if ( ! ls.canBuyCups(quantity))
		{
			if (ls.canBuyCups(1)) 
			{
				// Repeat until they get it right :)
				log("The quantity is too high.");
				promptCups();
				return;
			}
			
			// Can't buy any so we shall skip.
			else return;
		}
		
		String result=ls.buyCups(quantity);
		log(result);
	}
	
	private void promptIce()
	{
		log();
		log("How much ice would you like to buy?");
		
		log(ls.getIceInfo());
		
		int quantity = getInputInt();
		
		// skip 
		if (quantity==0) return;

		// Recover from bad input.
		if (quantity==-1)
		{
			promptIce();
			return;
		}
		
		
		if ( ! ls.canBuyIce(quantity))
		{
			if (ls.canBuyIce(1)) 
			{
				// Repeat until they get it right :)
				log("The quantity is too high.");
				promptIce();
				return;
			}
			
			// Can't buy any so we shall skip.
			else return;
		}
		
		String result=ls.buyIce(quantity);
		log(result);
	}
	
	private void promptLemons()
	{
		log();
		log("How many lemons would you like to buy?");
		
		log(ls.getLemonsInfo());
		
		int quantity = getInputInt();
		
		// skip
		if (quantity==0) return;

		// Recover from bad input.
		if (quantity==-1)
		{
			promptLemons();
			return;
		}
		
		
		if ( ! ls.canBuyLemons(quantity))
		{
			if (ls.canBuyLemons(1)) 
			{
				// Repeat until they get it right :)
				log("The quantity is too high.");
				promptLemons();
				return;
			}
			
			// Can't buy any so we shall skip.
			else return;
		}
		
		String result=ls.buyLemons(quantity);
		log(result);
	}
	
	
	private int getInputInt()
	{
		int a=-1;
		try
		{
			a=scanner.nextInt();
		}			
		catch(InputMismatchException e)
		{
			log("Input is out of range. Please try again.");
			return -1;
		}
		
		catch(NoSuchElementException e)
		{
			log(e.getStackTrace().toString());
			System.exit(1);
		}
		
		catch(IllegalStateException e)
		{
			log(e.getStackTrace().toString());
			System.exit(1);
		}
		return a;
	}
	
	public void doWin()
	{
		log(ls.getWin());
		System.exit(0);
	}
	
	public void doLoss()
	{
		log(ls.getLoss());
		System.exit(0);
	}
}
