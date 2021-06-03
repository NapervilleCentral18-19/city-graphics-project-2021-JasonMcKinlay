import java.awt.*;
    import java.util.*;
    
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;
/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Car extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x;
    private int newColor, direction;
    private Color color;

    /**
     * Constructor for objects of class Floor
     */
    public Car(Color myColor, int myX)
    {
        color = myColor;
        x = myX;
        direction = 0;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        
        // invoke the draw method 
        // ...
        draw(g2);
        
        
    }
    
    
       //-----------------------------------------------------------------
       //  Draws this figure relative to baseX, baseY, and height.
       //-----------------------------------------------------------------
       public void draw (Graphics2D page)
       {
          page.setColor(color);
          page.fillRect(x-5,500,50,8);
          page.fillOval(x,490,35,15); 
          
          page.setColor(new Color(250,250,250));
          //page.fillRect(x+25,495,10,5);
          page.fillRect(x+10,495,15,5);
           
          page.setColor(color.darkGray);
          page.fillOval(x, 505, 10, 10);
          page.fillOval(x+30, 505, 10, 10);
          
       }
       
       public void move ()
       {
           Random generator = new Random();
           if (x > 830 || x < -30) {
               newColor = generator.nextInt(4);
               if (newColor == 0)
                   color = new Color(64,81,145);
               else if (newColor == 1)
                   color = Color.orange;
               else if (newColor == 2)
                   color = Color.red;    
               else
                   color = Color.lightGray;
                   
               direction = generator.nextInt(2);
               if (direction == 0)
                   x = -30;
               else
                   x = 830;
           }
           else
               if (direction == 0)
                   x += 15;
               else
                   x -= 15;
           repaint();
       }
       
    public void run()
    {
        int running  = 0;
    while(true){
        
        if(running % 2 == 0)
            x +=20;
        else
            x -= 20;
        running ++;
            try{
            Thread.sleep(250); //1000 is a second
        }catch (Exception e){}
        
        System.out.print(x+"-----------------");
        //repaint();
    }
  
    }
}
