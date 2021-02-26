//Rachel McMullan
//George O'Malley

public class Disk implements Comparable<Disk> {
  
  final int SIZE=1000^2;//each disk has a capacity of 1GB or 1,000,000KB
  int spaceRemaining;//represents the amount of memory available 
    
  Disk(){
    spaceRemaining=SIZE;//upon creation, the disk is empty 
  }
	
  public int compareTo(Disk d){  
    if(this.spaceRemaining==d.spaceRemaining)  
      return 0;  
    else if(this.spaceRemaining>d.spaceRemaining)  
      return 1;  
    else  
      return -1;  
  }
  
  public boolean isFull(){
    return spaceRemaining==0;
  }
}

