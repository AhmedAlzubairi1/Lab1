class  Grass{
  
  void show(){
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
