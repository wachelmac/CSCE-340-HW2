//Rachel McMullan
//George O'Malley
import java.util.ArrayList;

public class Disk implements Comparable<Disk> {
  
    final int SIZE=1000000;//each disk has a capacity of 1GB or 1,000,000KB
    private int space; 
    private int id; 
    ArrayList files=new ArrayList();//files stored on the disk 
    
    Disk(int id){
        //inUse=0;//upon creation, the disk is empty
        space=SIZE; 
        this.id=id;
    }
	
    public int compareTo(Disk d){  
        if(this.space==d.space)  
            return 0;  
        else if(this.space>d.space)  
            return 1;  
        else  
            return -1;  
    }
  
    public boolean isFull(int f){
        return (space-f)< 0;
    }
    
    public boolean addFile(int f){
        //check to see if there is space for the file on the disk
        if(isFull(f))
            return false;
        //if there is space, update space and add the new file to the list
        space-=f;
        
        return files.add(f);  
    }
    
    public void printDisk(){
        System.out.printf("\t %d %6d:  ", id, space);
        //System.out.println(files.size());
        for(int i=0; i<files.size(); i++)
            System.out.print(files.get(i)+" ");
        System.out.println();
    }
}

