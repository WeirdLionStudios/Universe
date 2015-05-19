package wls.trek.universe;

import wls.trek.universe.objects.*;

public class UniverseMain {

	public static void main(String[] args) {
		UniverseMain main = new UniverseMain();
		
		Universe universe=new Universe(5);
		//generate Universe
		UniverseGraphics graphics = new UniverseGraphics();
		universe.generateUniverse();
		
	}
	
	public static void log(String str){
		System.out.println(str);
	}

}
