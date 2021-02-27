//Rachel McMullan
//George O'Malley

import java.util.ArrayList;
import java.util.Collections;


public class WorstFit {
    
    ArrayList<Disk> disks=new ArrayList<Disk>();
    int[] files=new int[20];
    double sum=0;
    int numDisks=0;
    
    private void sumFiles(){
        
    }
    
    public void printFit(){
        System.out.printf("file sizes sum\t = %f GB\n", sum);
        System.out.printf("total disks\t = %d\n", numDisks);
        
    }
    
}
