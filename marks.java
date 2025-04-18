import java.io.*;
import java.util.*;
class marks{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of subjects");
        int n=sc.nextInt();
        int sub[]=new int[n];
        int sum=0;
        float avg=0;
        for(int i=0;i<n;i++){
            sub[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            sum+=sub[i];
        }
        avg=sum/n;
        char grade;
        if(avg>90) grade='A';
        else if(90<=avg&&avg>80) grade='B';
        else if(80<=avg&&avg>70) grade='C';
        else if(70<=avg&&avg>60) grade='D';
        else if(60<=avg&&avg>50) grade='E';
        else grade='f';
        System.out.println("Total number of subject:"+n+"\nAverage:"+avg+"\nGrade:"+grade);
    }
}