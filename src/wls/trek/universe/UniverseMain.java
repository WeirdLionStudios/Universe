package wls.trek.universe;

import wls.trek.universe.objects.*;

public class UniverseMain {

	public static void main(String[] args) {
		UniverseMain main = new UniverseMain();
		
		Universe universe=new Universe(1, 1, 0);
		//generate Universe
		universe.generateUniverse();
		@SuppressWarnings("unused")
		UniverseGraphics graphics = new UniverseGraphics();
		
	}
	
	public static void log(String str){
		
		System.out.println(str);
		
	}

}
