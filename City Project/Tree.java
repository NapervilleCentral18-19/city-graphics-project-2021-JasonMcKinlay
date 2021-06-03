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
public class Tree extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private int x,y;


    /**
     * Constructor for objects of class Rectangle
     */
    public Tree(int myX, int myY)
    {
        x = myX;
        y = myY;
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
          page.setColor(new Color(126,75,58));
          page.setStroke(new BasicStroke(10));
          page.drawLine(x, y, x, y+30);
          page.setColor(new Color(51,145,85));
          page.fillOval(x-7,y-30,30,30);
          page.fillOval(x-21,y-30,30,30);
          page.fillOval(x-14,y-50,30,30);
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
