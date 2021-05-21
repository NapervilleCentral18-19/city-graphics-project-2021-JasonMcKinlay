//********************************************************************
//  LineUp.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a graphical object.
//********************************************************************

    import java.awt.*;
    import java.util.*;

    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import javax.swing.JComponent;

public class LineUp extends JComponent //implements Runnable
{
   private final int APPLET_WIDTH = 400;    //Size constants
   private final int APPLET_HEIGHT = 150;
   private final int HEIGHT_MIN = 100;
   private final int VARIANCE = 45;
   Random generator = new Random();
   //Graphics page;

   private Rectangle ground = new Rectangle(0,500,1000,800, Color.green);
   private Rectangle sky = new Rectangle(0,0,1920,1080, Color.cyan);
   private Rectangle building1 = new Rectangle(0,200,100,400, Color.black);
   private Rectangle building2 = new Rectangle(100,150,100,400, Color.darkGray);
   
   private Windows window1 = new Windows();
   //private StickFigure figure1,figure2, figure3, figure4;
   //private Floor ground;
   //private int running = 0;

   //-----------------------------------------------------------------
   //  Creates several stick figures with varying characteristics.
   //-----------------------------------------------------------------
   public LineUp () //init in applet is like constructor; runs only once
   {                   //Different than start.
      int h1,h2,h3,h4;  // heights of stick figures

      h1 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h2 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h3 = HEIGHT_MIN + generator.nextInt(VARIANCE);
      h4 = HEIGHT_MIN + generator.nextInt(VARIANCE);


      //figure1 = new StickFigure (100, 150, Color.red, h1);
      //x, y, color, height
      //figure2 = new StickFigure(150, 150, Color.green, h2);
      //figure3 = new StickFigure(200, 150, Color.cyan, h3);
      //figure4 = new StickFigure(250, 150, Color.yellow, h4);

      //ground = new Floor();

      //Thread t1 = new Thread(ground);
      //t1.start();
      //Thread t2 = new Thread(figure2);
      //t2.start();
      //Thread t3 = new Thread(figure3);
      //t3.start();


      //setBackground (Color.black); //sets the color of background
      //setSize (APPLET_WIDTH, APPLET_HEIGHT); //Sets up applet window

      //figure2.draw(page);


   }
   
   public void startThreads()
   {
       Thread groundThread = new Thread(ground);
       Thread bThread1 = new Thread(building1);
       Thread bThread2 = new Thread(building2);
       Thread skyThread = new Thread(sky);
       Thread windowThread1 = new Thread(window1);

       groundThread.start();
       bThread1.start();
       bThread2.start();
       skyThread.start();
       windowThread1.start();
   }

   //-----------------------------------------------------------------
   //  Paints the stick figures on the applet.
   //-----------------------------------------------------------------
   public void paintComponent(Graphics g)
    {
        Graphics2D page = (Graphics2D) g;
       //page = this.page;
      sky.draw(page);
      building1.draw(page);
      building2.draw(page);
      window1.draw(page);
      ground.draw(page);
      
      //ground.draw(page);

      //Thread t1 = new Thread(ground);
      //t1.start();

      /*
      int newHeight = HEIGHT_MIN + generator.nextInt(VARIANCE);
      figure1.setHeight(newHeight);
      newHeight = HEIGHT_MIN + generator.nextInt(VARIANCE);
      figure2.setHeight(newHeight);
      newHeight = HEIGHT_MIN + generator.nextInt(VARIANCE);
      figure3.setHeight(newHeight);
      newHeight = HEIGHT_MIN + generator.nextInt(VARIANCE);
      figure4.setHeight(newHeight);
      */
      //try{
          //pause program for quarter-sec (in miliseconds)
          //Thread.sleep(250);
        //}
      //catch(InterruptedException e){}

      //figure1.draw(page);

      //repaint(); //IMPORTANT LINE
   }

   public void nextFrame()
   {
       //figure1.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       //figure2.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       //figure3.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       //figure4.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       //running ++;
       //ground.setX(running);
       //Thread t1 = new Thread(ground);
       //t1.start();

       repaint();

   }

   public void run()
   {
    }
}
