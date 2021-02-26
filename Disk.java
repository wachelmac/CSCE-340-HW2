//Rachel McMullan
//George O'Malley
import java.util.ArrayList;

public class Disk implements Comparable<Disk> {
  
    final int SIZE=1000^2;//each disk has a capacity of 1GB or 1,000,000KB
    private int inUse;//represents the amount of memory in use 
    ArrayList files;//files stored on the disk 
    
    Disk(){
        files=new ArrayList(SIZE);//is this how you use ArrayList? I don't know how to use ArrayList
        inUse=0;//upon creation, the disk is empty 
    }
	
    public int compareTo(Disk d){  
        if(this.inUse==d.inUse)  
            return 0;  
        else if(this.inUse>d.inUse)  
            return 1;  
        else  
            return -1;  
    }
  
    public boolean isFull(){//idk if this method is necessary but it seemed like a good thing to have just in case
        return inUse==SIZE;
    }
    
    public boolean addFile(int f){
        //check to see if there is space available for the file on the disk
        if(inUse+f>SIZE)
            return false;
        //if there is space, update inUse and add the new file to the list
        inUse+=f;
        
        return files.add(f);  
    } 
}

