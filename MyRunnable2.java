public class MyRunnable2 extends Thread
{
   public static void main(String arv[]) throws Exception
   {
   MyRunnable2 t = new MyRunnable2();
    t.start();
    for(int i=1;i<10;i++)
     {
        if(i%2==1)
        {
          System.out.println(i);
         Thread.sleep(1000);  
         }
      }
    }
 public void run()
{
  try
    {
      for(int i=0;i<10;i++)
      {
        if(i%2==0)
        {
          System.out.println(i);
          Thread.sleep(1500);
        }
      }
    }
   catch(Exception e)
    {}
  }
}
   