//Rachel McMullan
//George O'Malley
import java.util.ArrayList;

public class Disk implements Comparable<Disk> {
  
    final int SIZE=1000000;//each disk has a capacity of 1GB or 1,000,000KB
    private int inUse;//represents the amount of memory in use 
    private int id; 
    ArrayList files=new ArrayList();//files stored on the disk 
    
    Disk(int id){
        inUse=0;//upon creation, the disk is empty 
        this.id=id;
    }
	
    public int compareTo(Disk d){  
        if(this.inUse==d.inUse)  
            return 0;  
        else if(this.inUse>d.inUse)  
            return 1;  
        else  
            return -1;  
    }
  
    public boolean isFull(){
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
    
    public void printDisk(){
        System.out.print(id+" "+(SIZE-inUse)+" :");
        //System.out.println(files.size());
        for(int i=0; i<files.size(); i++)
            System.out.print(files.get(i)+" ");
        System.out.println();
    }
}

