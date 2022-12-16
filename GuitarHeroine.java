public class GuitarHeroine
{
    public static void main(String[] args) 
    {
        GuitarString[] arr = new GuitarString[37];
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        for(int i = 0; i < arr.length; i++)
        {
            arr[i]= new GuitarString((int)(440)*Math.pow(1.05956, i-24));
        }

        // the main input loop
        while (true) 
        {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) 
            {
                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                if(keyboard.indexOf(key)!=-1)
                {
                    arr[keyboard.indexOf(key)].pluck();
                }
            }

            // compute the superposition of the samples
            double superposition = 0.0;
            for(int i = 0; i < arr.length; i ++)
            {
                superposition+=arr[i].sample();
            }
            // send the result to standard audio
            StdAudio.play(superposition);
            // advance the simulation of each guitar string by one step
            for(int i = 0; i < arr.length; i++)
            {
                arr[i].tic();
            }
        }
    }
}
