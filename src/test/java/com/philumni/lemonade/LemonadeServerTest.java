package com.philumni.lemonade;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.philumni.lemonade.server.LemonadeServer;


class LemonadeServerTest {

	@Test
	void testSimple() {
		
		
		LemonadeServer ls = new LemonadeServer();
		ls.start();
		
		ls.startNewGame("Phil");
		
		
		while(true)
		{ 
			log(ls.prepareTurn());
		
			if (ls.checkLoss()) 
			{
				
				assertTrue(ls.getMoney()<ls.getEconomy().getCupPrice());
				assertTrue(ls.getMoney()<ls.getEconomy().getIcePrice());
				assertTrue(ls.getMoney()<ls.getEconomy().getWaterPrice());
				assertTrue(ls.getMoney()<ls.getEconomy().getSugarPrice());
				assertTrue(ls.getMoney()<ls.getEconomy().getLemonPrice());
				
				log(ls.getLoss());
				System.exit(0);
			}
		
		
			log(ls.buySugar(1));
			log(ls.buyWater(4));
			log(ls.buyCups(1));
			log(ls.buyIce(2));
			log(ls.buyLemons(30));

			
			log(ls.finishTurn());
			if (ls.checkWin())
			{
				assertTrue(ls.getMoney()>=Lemonade.FINISH);
				log(ls.getWin());
				System.exit(0);
			}
		}
	
	}

	
	private void log(String s)
	{
		System.out.println(s);
	}
}

