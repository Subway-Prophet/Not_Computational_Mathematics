import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class Island extends JPanel
{
    private static final int WIDTH = 1800;
    private static final int HEIGHT = 900;
    public boolean Island = true;
    public static boolean lava = false;

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g)
    {
        int EXPO = MainForm.MapType;
        double FEATURE_SIZE = MainForm.MapZoom;
        int seed = getRandomNumberInRange(42, 69696969);
        var g2d = (Graphics2D) g;
        OpenSimplexNoise noise = new OpenSimplexNoise(seed);
        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
            {

                double e1 = 1 * noise.eval(x / FEATURE_SIZE, y / FEATURE_SIZE, 1.0);
                double e2 = 0.50 * noise.eval(2 * x / FEATURE_SIZE, 2 * y / FEATURE_SIZE, 1.0);
                double e3 = 0.25 * noise.eval(4 * x / FEATURE_SIZE, 4 * y / FEATURE_SIZE, 0);
                double e4 = 0.125 * noise.eval(6 * x / FEATURE_SIZE, 6 * y / FEATURE_SIZE, 1.0);
                double e5 = 0.05125 * noise.eval(8 * x / FEATURE_SIZE, 8 * y / FEATURE_SIZE, 1.0);
                double e6 = 0.02505125 * noise.eval(10 * x / FEATURE_SIZE, 8 * y / FEATURE_SIZE, 1.0);

                double elevation = Math.pow((e1 + e2 + e3 + e4 + e5 + e6), EXPO);
                if (elevation > .99)
                {
                    elevation = .99;
                }
                if (elevation < -.99)
                {
                    elevation = -.99;
                }
                    double distance = calculateDistanceBetweenPointsWithHypot(x, y, 900, 450);
                    double NewValue;
                    double OldRange = (1004.8 - 0);
                    double NewRange = (0.99 - -.69);
                    NewValue = (((distance - 0) * NewRange) / OldRange) + -.69;

                    elevation = (1 + elevation - NewValue)/ 2;
                if (BiomeCheck.SeaLevel == 0.1)
                {

                    if (BiomeCheck.CheckBiome(elevation) < 5 && !lava) //Ocean Drawing
                    {
                        int rgb = 0x0000FF * (int) (((elevation + 1)) * 127.5);
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) < 5 && lava) //Lava Drawing
                    {
                        int randomNumber = getRandomNumberInRange(1, 3);
                        if (randomNumber == 1)
                        {
                            int rgb = 0xcf1020;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }
                        else if (randomNumber == 2)
                        {
                            int rgb = 0x9c2d25;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }
                        else if (randomNumber == 3)
                        {
                            int rgb = 0xed7e00;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 5) //Beach Drawing
                    {
                        if (getRandomNumberInRange(1, 3) == 1) {
                            int rgb = 0xFFFF99;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);
                        } else {
                            int rgb = 0xFFFFCC;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);
                        }
                        //sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 8 || //Rain forest painter
                            BiomeCheck.CheckBiome(elevation) == 7 ||
                            BiomeCheck.CheckBiome(elevation) == 6)
                    {
                        int randomNumber = getRandomNumberInRange(1, 2);
                        if (randomNumber == 1)
                        {
                            int rgb = 0x003300;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }
                        else
                        {
                            int rgb = 0x006600;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }

                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 9)
                    {
                        int randomNumber = getRandomNumberInRange(1, 2);
                        if (randomNumber == 1)
                        {
                            int rgb = 0x193300;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        } else
                        {
                            int rgb = 0x003300;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 10)
                    {
                        int rgb = 0x202020;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 11)
                    {
                        int rgb = 0x404040;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 12)
                    {
                        int rgb = 0xA0A0A0;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 13)
                    {
                        int rgb = 0xf0ebeb;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 14)
                    {
                        int rgb = 0xe3dede;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 15)
                    {
                        int rgb = 0xf5e6e6;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 16)
                    {
                        int rgb = 0xFFFFFF;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                }

            }
        }
    }
    //Get your money for nothin' and your chicks for free
    // I want my I want my I want my I want my MTV
    //*Bongo*


    private static int getRandomNumberInRange(int min, int max)
    {

        if (min >= max)
        {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    public double calculateDistanceBetweenPointsWithHypot(double x1, double y1, double x2, double y2)
    {

        double ac = Math.abs(y2 - y1);
        double cb = Math.abs(x2 - x1);

        return Math.hypot(ac, cb);
    }
}
