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
   
   private Color groundColor = new Color(75, 231, 75);
   private Rectangle ground = new Rectangle(0,500,1000,800, groundColor);
   private Color skyColor = new Color(173, 231, 255);
   private Rectangle sky = new Rectangle(0,0,1920,1080, skyColor);
   private Color lakeColor = new Color(88, 105, 238);
   private Rectangle lake = new Rectangle(200,500,400,800, lakeColor);
   //private Cloud cloud = new Cloud(700,100);
   private Cloud[] clouds = new Cloud[10];
   private Sun sun = new Sun();
   private Bridge bridge = new Bridge();
   
   private Color buildingColor2 = new Color(46,46,46);
   private Color buildingColorBG = new Color(110,120,129);
   private Color buildingColorBG2 = new Color(108,115,120);
   
   private Rectangle building1 = new Rectangle(0,200,100,400, buildingColor2);
   private Rectangle building2 = new Rectangle(100,150,100,400, Color.darkGray);
   private Rectangle building3 = new Rectangle(700,250,100,400, buildingColor2);
   private Rectangle building4 = new Rectangle(600,200,100,400, Color.darkGray);
   
   private Rectangle building5 = new Rectangle(200,300,100,300, buildingColorBG);
   private Rectangle building6 = new Rectangle(300,275,100,300, buildingColorBG2);
   private Rectangle building7 = new Rectangle(400,315,100,300, buildingColorBG);
   private Rectangle building8 = new Rectangle(500,300,100,300, buildingColorBG2);

   /*
   Rectangle[] buildings = {building1, building2, building3, building4, building5, building6, building7, building8, building9, building10, building11, building12, building13};
   Windows[] windows = new Windows[buildings.length];
   for (int i = 0; i < windows.length; i++)
   {
       
   }
   */
   
   Color foregroundWindows = new Color(255, 252, 195);
   Color bgWindowsLight = new Color(255, 252, 195, 50);
   Color bgWindowsDark = new Color(0, 0, 0, 50);
   private Windows window1 = new Windows(building1, foregroundWindows, Color.black);
   private Windows window2 = new Windows(building2, foregroundWindows, Color.black);
   private Windows window3 = new Windows(building3, foregroundWindows, Color.black);
   private Windows window4 = new Windows(building4, foregroundWindows, Color.black);
   
   private Windows window5 = new Windows(building5, bgWindowsLight, bgWindowsDark);
   private Windows window6 = new Windows(building6, bgWindowsLight, bgWindowsDark);
   private Windows window7 = new Windows(building7, bgWindowsLight, bgWindowsDark);
   private Windows window8 = new Windows(building8, bgWindowsLight, bgWindowsDark);


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
      Random generator = new Random();
      for (int i = 0; i < clouds.length; i++) {
          int cloudX = generator.nextInt(800);
          int cloudY = generator.nextInt(200);
          clouds[i] = new Cloud(cloudX, cloudY);
      }


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
       Thread bThread3 = new Thread(building3);
       Thread bThread4 = new Thread(building4);
       
       Thread lakeThread = new Thread(lake);
       Thread skyThread = new Thread(sky);
       Thread sunThread = new Thread(sun);
       
       Thread windowThread1 = new Thread(window1);
       Thread windowThread2 = new Thread(window2);
       Thread windowThread3 = new Thread(window3);
       Thread windowThread4 = new Thread(window4);
       Thread windowThread5 = new Thread(window5);
       Thread windowThread6 = new Thread(window6);
       Thread windowThread7 = new Thread(window7);
       Thread windowThread8 = new Thread(window8);


       
       groundThread.start();
       bThread1.start();
       bThread2.start();
       bThread3.start();
       bThread4.start();
       
       lakeThread.start();
       skyThread.start();
       sunThread.start();
       
       windowThread1.start();
       windowThread2.start();
       windowThread3.start();
       windowThread4.start();
       windowThread5.start();
       windowThread6.start();
       windowThread7.start();
       windowThread8.start();


   }

   //-----------------------------------------------------------------
   //  Paints the stick figures on the applet.
   //-----------------------------------------------------------------
   public void paintComponent(Graphics g)
    {
        Graphics2D page = (Graphics2D) g;
       //page = this.page;
      sky.draw(page);
      //cloud.draw(page);
      for (Cloud cloud : clouds)
      {
          cloud.draw(page);
      }
      sun.draw(page);
      
      //buildings in background
      building5.draw(page);
      building6.draw(page);
      building7.draw(page);
      building8.draw(page);


      
      //buildings in foreground
      building1.draw(page);
      building2.draw(page);
      building3.draw(page);
      building4.draw(page);
      
      //Rectangle[][] grid1 = window1.getGrid(); 
      /*for (Rectangle[] row : grid1) {
            for (Rectangle col : row) {
                window1.draw(page);
                }
            }
      */
      window5.draw(page);
      window6.draw(page);
      window7.draw(page);
      window8.draw(page);


     
      window1.draw(page);
      window2.draw(page);
      window3.draw(page);
      window4.draw(page);
      
      ground.draw(page);
      lake.draw(page);
      //bridge.draw(page);
      
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

   public void nextFrame(int running)
   {
       //figure1.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       //figure2.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       //figure3.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       //figure4.setHeight(HEIGHT_MIN + generator.nextInt(VARIANCE));
       running ++;
       //ground.setX(running);
       //Thread t1 = new Thread(ground);
       //t1.start();
       window1.flash(running);
       window2.flash(running);
       window3.flash(running);
       window4.flash(running);
       
       window5.flash(running);
       window6.flash(running);
       window7.flash(running);
       window8.flash(running);

       
       for (Cloud cloud : clouds)
       {
           cloud.move();
       }
       sun.move();

       repaint();

   }

   public void run()
   {
    }
}
