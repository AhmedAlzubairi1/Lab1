import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class labOneProcessing extends PApplet {

// Source: https://www.youtube.com/watch?v=KkyIDI6rQJI

Rain [] drops = new Rain[500];
  Cloud cloud = new Cloud();
  Grass grass = new Grass();

public void setup(){
  //size(640,360);
  
  // Now we create a bunch of rain drops
  for (int i=0; i<drops.length;i++){
   drops[i]=new Rain(); 
  }
}

public void draw(){
  // Note to self: In processing the first shapes you draw are drawn first, 
  //aka the second shape is drawn ontop of the first
  background(0); //This is black background 
  
  
  for (int i=0; i<drops.length;i++){
   drops[i].fall();
   drops[i].show();
  }
  cloud.show();
  grass.show();
}
class Cloud{
  
  public void show(){
   //This is for purple color
   
   strokeWeight(3);
   //stroke(255,255,255);
  stroke(255,255,0);
  fill(255,255,255);
  //Here we make a rectangle. Represents a cloud 
  rect(0,0,width,200,25);
 } 
  
}
class  Grass{
  
  public void show(){
   //This is for purple color
   
  //This is to create the green base  
  fill(0,255,0);
  stroke(0,255,0);
  strokeWeight(3);
  rect(0,height-50,width,50,0);
  
  //This is to make small green lines to represent the actual grass
  for (int i=0; i<width;i+=10){
   line(0+i,height-50,0+i,height-70); 
  }
 } 
  
}
class Rain{
  //Have a random number for mapping sakes
  float z=random(0,20);
  //Lets make a random x location
 float x=random(width);
 //The negative is to make the rain drop way off the screen
 float y=random(-500,-50); 
 //y=0 means top of screen. X is middle of screen
 //We map yspeed because we want each raindrop to have a different speed
 float yspeed=map(z,0,20,20,30);
 //Now this variable is to determine the length of raindrop. Some are bigger than others
 float len = map(z,0,20,10,20);

 //This function is to make raindrop to fall
 
 public void fall() {
   y=y+yspeed;
   //Have a variable called gravity to change the speed of the raindrop 
   float gravity= map (z,0,20,0,2);
   yspeed=yspeed+gravity;
   //What happens if the raindrop leaves screen? We reset it. 
   if (y>height){
    y=random(-500,-50); 
    yspeed=map(z,0,20,20,30);
   }
   
 }
 //This is to render the raindrop
 public void show(){
   //Here, we create blue raindrops of various lengths and widths
   float thick=map(z,0,20,1,2);
   strokeWeight(thick);
   stroke(0,0,255);
  //Here we make a line. We do ths by increasing y by len 
  line(x,y,x,y+len); 
 }
  
  
  
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "labOneProcessing" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
