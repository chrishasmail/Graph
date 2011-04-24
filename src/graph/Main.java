

package graph;
import processing.core.*;
import java.util.Random;
/**
 *
 * @author Chris
 showlater*/
public class Main extends PApplet {

 
    public static void main(String[] args) {
       
    
        //Create an array which will be sent to the PApplet's main function
        //This array should include the arguments from the comand line and
        //the arguments that processing requires. The first two will be used by
        //the Processing API and the rest will be used by our program.
        String tempArgs[] = new String[args.length + 2];

        //Set the parameters which will be used by Processing's API
        tempArgs[0] = "--bgcolor=#FFFFFF";
        tempArgs[1] = "graph.Main";

        //Append the arguments from the command line to the end of the tempArray
        for(int i = 2; i < tempArgs.length; i++){
            tempArgs[i] = args[i-2];
        }

        //Send the String array to the PApplet's main function.
        PApplet.main(tempArgs);
    }
        
        @Override
        public void setup(){
            
            //Drawing the screen that will contain graph
            int scrWidth = Integer.parseInt(args[1]);
            int scrHeight = Integer.parseInt(args[2]);
            size(scrWidth, scrHeight);
            smooth();

            
            //Setting values that will be used to draw the bars
            float [] parsedArgs  = new float[args.length-3];
            for (int i = 0; i < parsedArgs.length; i++){
                parsedArgs[i]  = Float.parseFloat(args[i+3]);
            }
            float maxBarValue = maxAmt(parsedArgs);
            float barRatio = (scrHeight - 20) / maxBarValue;
            int barWidth = (scrWidth - (parsedArgs.length + 1)*5)
                    / parsedArgs.length;
            
            
            //Drawing the randomly colored bars
            for (int i = 0; i < parsedArgs.length; i++){
                float barHeight = (parsedArgs[i] * barRatio);
                int x = i * barWidth + (i + 1) * 5;
                float y = scrHeight - barHeight;
                Random generator = new Random();
                fill(generator.nextInt(255), generator.nextInt(255), 
                        generator.nextInt(255));
                rect(x, y, barWidth, barHeight);
            }
        }


        //Finding the value of the largest bar
        public static float maxAmt(float[] m) {
            float maximum = m[0];
            for (int i=0; i <(m.length); i++) {
                if (m[i] > maximum) {
                    maximum = m[i];
                } 
            }
                return maximum;
        }     
}

