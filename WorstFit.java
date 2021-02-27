//Rachel McMullan
//George O'Malley

import java.util.ArrayList;
//import java.util.Collections;

public class WorstFit {
    
    ArrayList<Disk> disks=new ArrayList<Disk>();
    int[] files;
    int numDisks;
    int index;
    
    WorstFit(int[] f){
        
        files=f;
        addDisk();
        doWorst();
    }
    
    private void addDisk(){
        Disk nextDisk=new Disk(numDisks);
        disks.add(numDisks, nextDisk);
        numDisks+=1;
    }
    
    private void doWorst(){
        
        for(int i=0; i<files.length; i++){
            //ALGORITHM GOES HERE
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
