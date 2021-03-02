//Rachel McMullan
//George O'Malley

import java.util.ArrayList;
import java.util.Comparator;

public class WorstFit {
    
    ArrayList<Disk> disks=new ArrayList<Disk>();
    int[] files;
    int numDisks;
    
    WorstFit(int[] f){
        files=f;
        doWorst();
    }
    
    private void addDisk(){
        Disk nextDisk=new Disk(numDisks);
        disks.add(nextDisk);
        numDisks+=1;
        
    }
    
    private void doWorst(){
        addDisk();
        int fileSize;//holds current value
        MaxPQ<Disk> pq;
        
        for(int i=0; i<files.length; i++){
            fileSize=files[i];
            boolean isSpace=false; 
            for(Disk d: disks){
                if(!d.isFull(fileSize)){
                    isSpace=true; 
                    break; 
                }
            }
            if(!isSpace){
                    addDisk();//create new disk
                    disks.get(numDisks-1).addFile(fileSize);//add file to disk
            }  
            else{
                pq=new MaxPQ(disks.toArray());//create a priority queue 
                pq.max().addFile(fileSize);
            }
        }
        printFit();
    }
    
    private double sumFiles(){
        int total=0;
        for(int i=0; i<files.length; i++)
            total+=files[i];
        return (double)total/1000000;
    }
    
    
    public void printFit(){
        
        System.out.printf("file sizes sum\t = %f GB\n", sumFiles());
        System.out.printf("total disks\t = %d\n", numDisks);
        if(files.length<100){
            //sort goes here
            
            for(Disk d: disks)
                d.printDisk();
        }
    }
    
}
