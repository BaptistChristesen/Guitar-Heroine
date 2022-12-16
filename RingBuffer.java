/**
 * This RingBuffer object . . .
 * 
 * @author  
 * @version 
 */
public class RingBuffer 
{
    private int size;
    private double[] buff;
    private int front;
    private int rear;
    private int cap;
    public RingBuffer(int capacity)
    {
        size=0;
        cap=capacity;
        buff = new double[capacity];
        front=0;
        rear=0;
    }
    public int size(){return size;}
    public boolean isEmpty(){return size==0;}
    public boolean isFull(){return size==cap;}
    
    public void add(double value)
    {
        atCapacity();
        buff[rear]=value;
        rear++;
        size++;
        atCapacity();
    }
    
    public double peek()
    {
        return buff[front];
    }
    
    public void atCapacity()
    {
        if(front==cap){front=0;}
        if(rear==cap){rear=0;}
    }
    
    public double remove()
    {
        atCapacity();
        double t = buff[front];
        buff[front]=0.0;
        front++;
        size--;
        atCapacity();
        return t;
    }
    
    // a simple test of the constructor and methods in RingBuffer
    public static void main(String[] args) 
    {
        int capacity = 100;
        RingBuffer buffer = new RingBuffer(capacity);  
        for (int i = 1; i <= capacity; i++) 
            buffer.add(i);
      
        double t = buffer.remove();
        buffer.add(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.remove();
            double y = buffer.remove();
            buffer.add(x + y);
        }
        System.out.println(buffer.peek());
    }

}
