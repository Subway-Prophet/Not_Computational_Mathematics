import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RiverTest extends JPanel {
    private static final int WIDTH = 750;
    private static final int HEIGHT = 750;
    public boolean Island = false;
    public static boolean lava = false;
    public static int[] RiverPathX;
    public static int[] RiverPathY;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private void doDrawing(Graphics g) {
        int Rivers = 0;

        int EXPO = MainForm.MapType;
        double FEATURE_SIZE = MainForm.MapZoom;
        int seed = 69;
        var g2d = (Graphics2D) g;
        OpenSimplexNoise noise = new OpenSimplexNoise(seed);
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {

                double e1 = 1 * noise.eval(x / FEATURE_SIZE, y / FEATURE_SIZE, 1.0);
                double e2 = 0.50 * noise.eval(2 * x / FEATURE_SIZE, 2 * y / FEATURE_SIZE, 1.0);
                double e3 = 0.25 * noise.eval(4 * x / FEATURE_SIZE, 4 * y / FEATURE_SIZE, 0);
                double e4 = 0.125 * noise.eval(6 * x / FEATURE_SIZE, 6 * y / FEATURE_SIZE, 1.0);
                double e5 = 0.05125 * noise.eval(8 * x / FEATURE_SIZE, 8 * y / FEATURE_SIZE, 1.0);
                double e6 = 0.02505125 * noise.eval(10 * x / FEATURE_SIZE, 8 * y / FEATURE_SIZE, 1.0);

                double elevation = Math.pow((e1 + e2 + e3 + e4 + e5 + e6), EXPO);
                if (elevation > .99) {
                    elevation = .99;
                }
                if (elevation < -.99) {
                    elevation = -.99;
                }
                /**if (Island)
                 {

                 elevation = (1 + elevation - distance)/ 2;
                 }**/
                if (BiomeCheck.SeaLevel == 0.1) {

                    if (BiomeCheck.CheckBiome(elevation) == 0 && !lava) //Ocean Drawing
                    {
                        int rgb = 0x0000FF * (int) (((elevation + 1)) * 127.5);
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 0 && lava) //Lava Drawing
                    {
                        int randomNumber = getRandomNumberInRange(1, 3);
                        if (randomNumber == 1) {
                            int rgb = 0xcf1020;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        } else if (randomNumber == 2) {
                            int rgb = 0x9c2d25;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        } else if (randomNumber == 3) {
                            int rgb = 0xed7e00;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 1) //Beach Drawing
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
                    } else if (BiomeCheck.CheckBiome(elevation) == 4 || //Rain forest painter
                            BiomeCheck.CheckBiome(elevation) == 3 ||
                            BiomeCheck.CheckBiome(elevation) == 2) {
                        int randomNumber = getRandomNumberInRange(1, 2);
                        if (randomNumber == 1) {
                            int rgb = 0x003300;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        } else {
                            int rgb = 0x006600;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }

                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 5) {
                        int randomNumber = getRandomNumberInRange(1, 2);
                        if (randomNumber == 1) {
                            int rgb = 0x193300;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        } else {
                            int rgb = 0x003300;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }
                        /**if (getRandomNumberInRange(1, 1000) == 69 && elevation >= .49 && elevation < .5 && Rivers < 1)
                         {
                         int rgb = 0x0000FF;
                         Color Blue2 = new Color(rgb);
                         g2d.setColor(Blue2);//sets color
                         Rivers = Rivers + 1;
                         FindRiver(x, y, seed, FeatureSize);
                         RiverPathX = new int[50];
                         RiverPathY = new int[50];
                         }**/
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 6) {
                        int rgb = 0x202020;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 7) {
                        int rgb = 0x404040;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 8) {
                        int rgb = 0xA0A0A0;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 9) {
                        int rgb = 0xf0ebeb;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 10) {
                        int rgb = 0xe3dede;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 11) {
                        int rgb = 0xf5e6e6;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 12) {
                        int rgb = 0xFFFFFF;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }

                }
            }
        }
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
                if (getRandomNumberInRange(1, 1000) == 69 && elevation >= .49 && elevation < .5 && Rivers < 5)
                {
                    int rgb = 0x0000FF;
                    Color Blue2 = new Color(rgb);
                    g2d.setColor(Blue2);//sets color
                    Rivers = Rivers + 1;
                    RiverPathX = new int[50];
                    RiverPathY = new int[50];
                    g2d.drawLine(x, y, x, y);// draws point

                }

            }
        }
    }

}