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
public class Bridge extends JComponent implements Runnable
{
    // instance variables - replace the example below with your own
    private Color color;

    /**
     * Constructor for objects of class Bridge
     */
    public Bridge()
    {
        color = new Color(46,46,46);
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
          page.setStroke(new BasicStroke(10));
          page.drawLine(0,515,800,515);
          page.drawOval(200,450,400,150);
          
          page.setStroke(new BasicStroke(5));
          page.drawLine(300, 460, 300, 800);
          page.drawLine(500, 460, 500, 800);
          page.drawLine(250, 480, 250, 800);
          page.drawLine(550, 480, 550, 800);
          page.drawLine(350, 460, 350, 800);
          page.drawLine(450, 460, 450, 800);
          page.drawLine(400, 450, 400, 800);
          
          page.setColor(new Color(75, 231, 75));
          page.fillRect(0,520,800,800);
          
          page.setColor(new Color(88, 105, 238));
          page.fillRect(200,520,400,800);
          
          
          /*
          page.fillRect(0, 515, 200,10);
          page.fillRect(600, 515, 200,10);
          page.fillRect(300, 475, 200,10);
          page.setStroke(new BasicStroke(10));
          page.drawLine(200, 520, 300, 480);
          page.drawLine(600, 520, 500, 480);
          */
       }
       
    public void run()
    {
        int running  = 0;
    while(true){
        
            try{
            Thread.sleep(250); //1000 is a second
        }catch (Exception e){}
        
        //System.out.print(x+"-----------------");
        //repaint();
    }
  
    }
}
