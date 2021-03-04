//Rachel McMullan
//George O'Malley
//Group 7

import java.util.ArrayList;

public class Disk implements Comparable<Disk> {
  
    final int SIZE=1000000;//each disk has a capacity of 1GB or 1,000,000KB
    private int space; //remaining space on disk, Comparable variable 
    private int id; //unique id associated with each disk
    ArrayList files=new ArrayList();//files stored on the disk 
    
    Disk(int id){
        //constructor initializes Disk object
        space=SIZE; 
        this.id=id;
    }

    public int compareTo(Disk d){  
        //Comparable method compares remaining space on disks 
        if(this.space==d.space)  
            return 0;  
        else if(this.space>d.space)  
            return 1;  
        else  
            return -1;  
    }
    public boolean isFull(int f){
        //if false, there is no space on the disk for the file 
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
        //output disk metrics in the given format 
        System.out.printf("\t %d %6d:  ", id, space);
        for(int i=0; i<files.size(); i++)
            System.out.print(files.get(i)+" ");
        System.out.println();
    }
}

