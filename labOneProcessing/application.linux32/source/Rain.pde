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
 
 void fall() {
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
 void show(){
   //Here, we create blue raindrops of various lengths and widths
   float thick=map(z,0,20,1,2);
   strokeWeight(thick);
   stroke(0,0,255);
  //Here we make a line. We do ths by increasing y by len 
  line(x,y,x,y+len); 
 }
  
  
  
}
