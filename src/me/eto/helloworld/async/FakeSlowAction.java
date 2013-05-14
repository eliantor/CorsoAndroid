package me.eto.helloworld.async;

import java.util.Random;

public class FakeSlowAction {

	public static int reallySlowCall(){
		Random rand = new Random();
		try {
			Thread.sleep(rand.nextInt(6000));
		} catch (InterruptedException e) {
			return -1;
		}
		
		return rand.nextInt(100);
	}
}
