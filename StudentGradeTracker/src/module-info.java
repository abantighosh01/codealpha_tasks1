import java.util.Scanner;
class StudentGradeTracker {

    void average( int b,int n)
    {
        int avg;
        avg= b/n;
    }
    void highest_score(int b)
    {
        int l=0;
        if(b>l)
        {
            l=b;
        }
        System.out.println("Highest Score:"+l);
    }
    void lowest_score(int b)
    {
        int l=100;
        if(b<l)
        {
            l=b;
        }
        System.out.println("Lowest Score:"+l);
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n, i,t=0;
        StudentGradeTracker ob=new StudentGradeTracker();
        System.out.println("Enter the number of Subjects: ");
        n = in.nextInt();
        int a[]=new int[n];
        for (i=0; i<n; i++)
        {
            System.out.println("Enter the marks of Subject " + (i+1) + ": ");
            a[i] = in.nextInt();
            t=t+a[i];
            ob.highest_score(a[i]);
            ob.lowest_score(a[i]);
        }
        ob.average(t,n);
        
     }

 }