package wls.trek.universe.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;

import wls.trek.universe.UniverseMain;
import wls.trek.universe.utils.MathUtils;
import wls.trek.universe.utils.Vector2D;


public class Body{
	
	public double mass;
	public String name;
	public Point pos;
	public Vector2D velocity, acceleration;
	
	public Body(Point position, String n, double m){
		pos=position;
		name=n;
		mass=m;
		
		acceleration=new Vector2D(pos);
		velocity=new Vector2D(pos);
	}
	
	public void getVelocity(){
		//UniverseMain.log(acceleration.x+" | " +acceleration.y);
		for(int i=0;i<Universe.numBodies-1;i++){
			acceleration.x+=MathUtils.calculateGravAttraction(getSubarray(Universe.bodies,this)[i], this).x/mass;
			acceleration.y+=MathUtils.calculateGravAttraction(getSubarray(Universe.bodies, this)[i], this).y/mass;
		}
		//UniverseMain.log(MathUtils.calculateGravAttraction(getSubarray(Universe.bodies,this)[0], this).x+" / " +mass);
		
		//UniverseMain.log(acceleration.x+" | " +acceleration.y);
		velocity.x=acceleration.x;
		velocity.y=acceleration.y;
	}
	
	public void move(){
	
		getVelocity();
		pos.x+=velocity.x;
		pos.y+=velocity.y;
	}
	
	public void printVector(){
		UniverseMain.log(name+"\nmass: "+mass+"\npos: (x)"+pos.x+" (y)"+pos.y);
	}

	public void renderBody(Graphics g){
		g.setColor(Color.red);
		g.fillOval(pos.x, pos.y, 20, 20);
		g.drawString(name,  pos.x+10, pos.y-10);
	}
	
	public Body[] getSubarray(Body[] bodies,  Body body){
		Body[] sub=new Body[bodies.length-1];
		
		Body temp=bodies[getIndex(bodies, body)];
		bodies[getIndex(bodies, body)]=bodies[bodies.length-1];
		bodies[bodies.length-1]=temp;
		
		sub=Arrays.copyOfRange(bodies, 0, bodies.length-1);
		
		return sub;
	}
	
	public int getIndex(Body[] bodies, Body body){
		
		int index=-1;
		for(int i=0;i<bodies.length;i++){
			if(bodies[i].name==body.name)
				index=i;
		}
		
		return index;		
	}
	
}