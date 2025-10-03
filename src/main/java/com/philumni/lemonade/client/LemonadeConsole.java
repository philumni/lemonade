package com.philumni.lemonade.client;

import com.philumni.lemonade.server.LemonadeServer;

/*
 * The purpose of this class is to implement a client/server interaction
 * for Lemonade stand, that produces the game over the command line.
 */
public class LemonadeConsole {
	
	
	
	public static void main(String[] args)
	{
		LemonadeServer ls = new LemonadeServer();
		ls.start();
		
		LemonadeClient lc = new LemonadeClient(ls);
		lc.start();
	}
	
	
}
