import java.util.*;
public class LeakyBucket{
int n,d,x[],nsec,drop;
LeakyBucket()
{
  Scanner s=new Scanner(System.in);
  System.out.print("Enter the bucket size:");
  n=s.nextInt();
  System.out.print("Enter the output data rate:");
  d=s.nextInt();
  System.out.print("enter the no of seconds you want to send data:");
  nsec=s.nextInt();
  x=new int[nsec];
for(int i=0;i<nsec;i++)
{
   System.out.print("enter the input rate at "+(i+1)+"seconds:");
   x[i]=s.nextInt();
}
}
void LeakyBucket()
{
  drop=0;
  int i,u=n;
  for(i=0;i<nsec;i++)
  {
  if(x[i]>u)
  {
     drop=x[i]-u;
     u=d;
  }
  else
{
  drop=0;
  u=u-x[i]+d;
}
System.out.println((i+1)+"\t\t"+x[i]+"\t\t\t"+d+"\t\t"+(n-u)+"\t\t"+drop);
}
while(u+d<=n)
{
  drop=0;
  u=u+d;
  System.out.println((i+1)+"\t\t"+"\t\t\t"+d+"\t\t"+"\t\t"+drop);
  i++;
}
if(u!=n)
  System.out.println((i+1)+"\t\t0\t\t\t"+(n-u)+"\t\t"+"0\t\t"+drop);
}
public static void main(String[] args)
{
 LeakyBucket t=new LeakyBucket();
 System.out.println("time\t packet recieved\t packet sent\t packet left\t packets dropped");
 t.LeakyBucket();
}
}

