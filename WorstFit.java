//Rachel McMullan
//George O'Malley
//Group 7

import java.util.ArrayList;
import java.util.Comparator;
import java.io.*;
import java.util.Scanner;

public class WorstFit {
    
    ArrayList<Disk> disks=new ArrayList<>();
    int[] files; 
    int numDisks;
    
    
    WorstFit(String s) throws IOException{
        
        //process data from file 
        readFile(s);
        
        //implement worst-fit heuristic 
        doWorst();
    }
    
    private void doWorst(){
        
        addDisk();//create first disk 
        int fileSize;
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
    
    //reads input from file and stores it in integer array files[]
    private void readFile(String s) throws IOException{
               
        File inFile=new File(s);
        Scanner input=new Scanner(inFile);
        ArrayList<Integer> inList=new ArrayList<>();
        
        while(input.hasNext()){
          inList.add(input.nextInt());  
        }
        
        //copy file sizes to files[] for easier access 
        int size=inList.size();
        files=new int[size];
        for(int i=0; i<size; i++){
            files[i]=inList.get(i);
        }
    }
    
    //adds disk to ArrayList disks and updates total
    private void addDisk(){
        Disk nextDisk=new Disk(numDisks);
        disks.add(nextDisk);
        numDisks+=1;
        
    }
    
    //returns the sum of all file sizes in GB 
    private double sumFiles(){
        int total=0;
        for(int i=0; i<files.length; i++)
            total+=files[i];
        return (double)total/1000000;
    }
    
    
    //prints the sum of all fizes and the total number of disks
    public void printFit(){
        System.out.printf("file sizes sum\t = %f GB\n", sumFiles());
        System.out.printf("total disks\t = %d\n", numDisks);
        
        //if there are less than 100 files, print disks
        if(files.length<100){
            MaxPQ<Disk> pq=new MaxPQ(disks.toArray());

            for(Disk d: disks)
                pq.delMax().printDisk();
        }
    }
    
}
