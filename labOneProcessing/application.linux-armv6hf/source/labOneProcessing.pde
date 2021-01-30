// Source: https://www.youtube.com/watch?v=KkyIDI6rQJI

Rain [] drops = new Rain[500];
  Cloud cloud = new Cloud();
  Grass grass = new Grass();

void setup(){
  //size(640,360);
  fullScreen();
  // Now we create a bunch of rain drops
  for (int i=0; i<drops.length;i++){
   drops[i]=new Rain(); 
  }
}

void draw(){
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
