//Rachel McMullan
//George O'Malley

import java.util.ArrayList;

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
        disks.add(numDisks, nextDisk);
        numDisks+=1;
    }
    
    private void doWorst(){
        addDisk();
        int fileSize;//holds current value
        
        for(int i=0; i<files.length; i++){
            fileSize=files[i];
            boolean isSpace=false; 
            
            for(Disk d: disks){
                if(!d.isFull(fileSize)){
                    isSpace=true;//at least one disk has space for the file
                    break; 
                }
                
                else{
                    addDisk();//create new disk
                    assert disks.get(numDisks-1).addFile(fileSize);//add file to disk
                }
            }
            
            if(isSpace){
                //create a priority queue 
                MaxPQ<Disk> pq=new MaxPQ(disks.toArray());
                Disk max= pq.max(); //find the disk with the most remaining space
                assert max.addFile(fileSize); //add file to that disk
            }  
        }
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
            for(Disk d: disks)
                d.printDisk();
            }
    }
    
}
