import java.util.Random;
public class GuitarString 
{
    private RingBuffer s;
    private int n;
    private int timeCount;
    public GuitarString(double frequency) 
    {
        n = ((int)(44100/frequency));
        timeCount = 0;
        s= new RingBuffer(n);
        for(int i = 0; i < n; i++)
        {
            s.add(0.0);
        }
    }

    public GuitarString(double[] array) 
    {
        n=array.length;
        timeCount = 0;
        s= new RingBuffer(array.length);
        for(int i = 0; i < array.length; i++)
        {
            s.add(array[i]);
        }
    }

    public void pluck() 
    {
        //Random rd = new Random();
        for(int i = 0; i < n; i++){s.remove();}
        for(int i = 0; i < n; i++)
        {
            s.add((Math.random()) -.5);
        }
    }

    // advance the simulation one time step
    public void tic() 
    {
        double a = s.remove()+s.peek();
        a = a/2;
        a = a*.994;
        s.add(a);
        timeCount++;
    }

    // return the current sample
    public double sample() 
    {
        return s.peek();
    }

    // return number of times tic was called
    public int time() 
    {
        return timeCount;
    }

    public static void main(String[] args) 
    {
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < 25; i++) 
        {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
