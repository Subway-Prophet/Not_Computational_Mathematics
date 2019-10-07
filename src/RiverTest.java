import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RiverTest extends JPanel
{
    private static final int WIDTH = 1800;
    private static final int HEIGHT = 900;
    public boolean Island = false;
    public static boolean lava = false;
    public static int[] RiverPathX;
    public static int[] RiverPathY;

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        doDrawing(g);
    }

    private static int getRandomNumberInRange(int min, int max)
    {

        if (min >= max)
        {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double getElevation(int seed, int EXPO, double FEATURE_SIZE, int x, int y)
    {
        OpenSimplexNoise noise = new OpenSimplexNoise(seed);

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
        return elevation;
    }

    private void doDrawing(Graphics g)
    {
        int Rivers = 0;
        int seed = MainForm.seed;
        int EXPO = MainForm.MapType;
        double FEATURE_SIZE = MainForm.MapZoom;
        var g2d = (Graphics2D) g;
        for (int y = 0; y < HEIGHT; y++)
        {
            for (int x = 0; x < WIDTH; x++)
            {

                double elevation = getElevation(seed, EXPO, FEATURE_SIZE, x, y);
                if (BiomeCheck.SeaLevel == 0.1)
                {

                    if (BiomeCheck.CheckBiome(elevation) == 0 && !lava) //Ocean Drawing
                    {
                        int rgb = 0x0000FF * (int) (((elevation + 1)) * 127.5);
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 0 && lava) //Lava Drawing
                    {
                        int randomNumber = getRandomNumberInRange(1, 3);
                        if (randomNumber == 1)
                        {
                            int rgb = 0xcf1020;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        } else if (randomNumber == 2)
                        {
                            int rgb = 0x9c2d25;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        } else if (randomNumber == 3)
                        {
                            int rgb = 0xed7e00;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 1) //Beach Drawing
                    {
                        if (getRandomNumberInRange(1, 3) == 1)
                        {
                            int rgb = 0xFFFF99;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);
                        } else
                        {
                            int rgb = 0xFFFFCC;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);
                        }
                        //sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 4 || //Rain forest painter
                            BiomeCheck.CheckBiome(elevation) == 3 ||
                            BiomeCheck.CheckBiome(elevation) == 2)
                    {
                        int randomNumber = getRandomNumberInRange(1, 2);
                        if (randomNumber == 1)
                        {
                            int rgb = 0x003300;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        } else
                        {
                            int rgb = 0x006600;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);//sets color
                        }

                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 5)
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
                    } else if (BiomeCheck.CheckBiome(elevation) == 6)
                    {
                        int rgb = 0x202020;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 7)
                    {
                        int rgb = 0x404040;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 8)
                    {
                        int rgb = 0xA0A0A0;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 9)
                    {
                        int rgb = 0xf0ebeb;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 10)
                    {
                        int rgb = 0xe3dede;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 11)
                    {
                        int rgb = 0xf5e6e6;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    } else if (BiomeCheck.CheckBiome(elevation) == 12)
                    {
                        int rgb = 0xFFFFFF;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }

                }
                else if (BiomeCheck.SeaLevel == .5)
                {
                    if (BiomeCheck.CheckBiome(elevation) == 0 && !lava) //Lake Drawing
                    {
                        int rgb = 0x0000FF * (int) (((elevation + 1)) * 127.5);
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 0 && lava) //Lava Drawing
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
                    else if (BiomeCheck.CheckBiome(elevation) == 1 ||BiomeCheck.CheckBiome(elevation) == 2) //Beach Drawing
                    {
                        if (getRandomNumberInRange(1, 3) == 1)
                        {
                            int rgb = 0xFFFF99;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);
                        }
                        else
                        {
                            int rgb = 0xFFFFCC;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);
                        }
                        //sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 6 ||
                            BiomeCheck.CheckBiome(elevation) == 5 ||
                            BiomeCheck.CheckBiome(elevation) == 4 || //Rain forest painter
                            BiomeCheck.CheckBiome(elevation) == 3)
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
                    else if (BiomeCheck.CheckBiome(elevation) == 7 ||
                            BiomeCheck.CheckBiome(elevation) == 8 ||
                            BiomeCheck.CheckBiome(elevation) == 9 ||
                            BiomeCheck.CheckBiome(elevation) == 10 ||
                            BiomeCheck.CheckBiome(elevation) == 11 ||
                            BiomeCheck.CheckBiome(elevation) == 12)
                    {
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
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                }
                else if (BiomeCheck.SeaLevel == -.5)
                {

                    if (BiomeCheck.CheckBiome(elevation) == 0 && !lava) //Lake Drawing
                    {
                        int rgb = 0x0000FF * (int) (((elevation + 1)) * 127.5);
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 0 && lava) //Lava Drawing
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
                    else if (BiomeCheck.CheckBiome(elevation) == 1) //Beach Drawing
                    {
                        if (getRandomNumberInRange(1, 3) == 1)
                        {
                            int rgb = 0xFFFF99;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);
                        }
                        else
                        {
                            int rgb = 0xFFFFCC;
                            Color Blue2 = new Color(rgb);
                            g2d.setColor(Blue2);
                        }
                        //sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 6 ||
                            BiomeCheck.CheckBiome(elevation) == 5 ||
                            BiomeCheck.CheckBiome(elevation) == 4 || //Rain forest painter
                            BiomeCheck.CheckBiome(elevation) == 3 ||
                            BiomeCheck.CheckBiome(elevation) == 2)
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
                    else if (BiomeCheck.CheckBiome(elevation) == 7 ||
                            BiomeCheck.CheckBiome(elevation) == 8 ||
                            BiomeCheck.CheckBiome(elevation) == 9 ||
                            BiomeCheck.CheckBiome(elevation) == 10 ||
                            BiomeCheck.CheckBiome(elevation) == 11 ||
                            BiomeCheck.CheckBiome(elevation) == 12)
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
                    else if (BiomeCheck.CheckBiome(elevation) == 13)
                    {
                        int rgb = 0x202020;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 14)
                    {
                        int rgb = 0xA0A0A0;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        g2d.drawLine(x, y, x, y);// draws point
                    }
                    else if (BiomeCheck.CheckBiome(elevation) == 15)
                    {
                        int rgb = 0xededed;
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
        while (Rivers < 30)
        {

            for (int y = 0; y < HEIGHT; y++)
            {
                for (int x = 0; x < WIDTH; x++)
                {
                    double elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                    if
                    (getRandomNumberInRange(1, 1000) == 69 && elevation >= (.59) && elevation < (.6) && Rivers < 30)
                    {
                        double lastElevation = 0;
                        boolean riverEnd = false;
                        int rgb = 0x0000FF;
                        int Count = 0;
                        Color Blue2 = new Color(rgb);
                        g2d.setColor(Blue2);//sets color
                        Rivers = Rivers + 1;
                        g2d.drawLine(x, y, x, y);// draws point
                        int SaveX = x;
                        int SaveY = y;
                        while (!riverEnd)

                        {
                            double CheckUpLeft = elevation - getElevation(seed, EXPO, FEATURE_SIZE, x - 1, y + 1);
                            double CheckUpMid = elevation - getElevation(seed, EXPO, FEATURE_SIZE, x, y + 1);
                            double CheckUpRight = elevation - getElevation(seed, EXPO, FEATURE_SIZE, x + 1, y + 1);
                            double CheckMidLeft = elevation - getElevation(seed, EXPO, FEATURE_SIZE, x - 1, y);
                            double CheckMidRight = elevation - getElevation(seed, EXPO, FEATURE_SIZE, x + 1, y);
                            double CheckDownLeft = elevation - getElevation(seed, EXPO, FEATURE_SIZE, x - 1, y - 1);
                            double CheckDownMid = elevation - getElevation(seed, EXPO, FEATURE_SIZE, x, y - 1);
                            double CheckDownRight = elevation - getElevation(seed, EXPO, FEATURE_SIZE, x + 1, y - 1);
                            if (Count > 301)
                            {
                                g2d.drawLine(x, y, x, y);
                                g2d.drawLine(x - 1, y, x - 1, y);
                                g2d.drawLine(x + 1, y, x + 1, y);
                                g2d.drawLine(x, y - 1, x, y - 1);
                                g2d.drawLine(x, y + 1, x, y + 1);
                                g2d.drawLine(x + 1, y + 1, x + 1, y + 1);
                                g2d.drawLine(x + 1, y - 1, x + 1, y - 1);
                                g2d.drawLine(x - 1, y + 1, x - 1, y + 1);
                                g2d.drawLine(x - 1, y -1, x - 1, y - 1);

                                g2d.drawLine(x - 2, y, x - 2, y);
                                g2d.drawLine(x + 2, y, x + 2, y);
                                g2d.drawLine(x, y - 2, x, y - 2);
                                g2d.drawLine(x, y + 2, x, y + 2);
                                g2d.drawLine(x + 2, y + 2, x + 2, y + 2);
                                g2d.drawLine(x + 2, y - 2, x + 2, y - 2);
                                g2d.drawLine(x - 2, y + 2, x - 2, y + 2);
                                g2d.drawLine(x - 2, y - 2, x - 2, y - 2);
                                riverEnd = true;
                            }
                            else if (CheckMidLeft > CheckUpLeft
                                    && CheckMidLeft > CheckUpMid
                                    && CheckMidLeft > CheckUpRight
                                    && CheckMidLeft > CheckMidRight
                                    && CheckMidLeft > CheckDownLeft
                                    && CheckMidLeft > CheckDownMid
                                    && CheckMidLeft > CheckDownRight)
                            {
                                x = x - 1;
                                g2d.drawLine(x, y, x, y);
                                Count++;
                                elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                                if (lastElevation == elevation)
                                {
                                    riverEnd = true;
                                }
                                lastElevation = elevation;
                                System.out.println(elevation);
                                if (getElevation(seed, EXPO, FEATURE_SIZE, x, y) < BiomeCheck.SeaLevel)
                                {
                                    riverEnd = true;
                                }
                            }
                            else if (CheckMidRight > CheckUpLeft
                                    && CheckMidRight > CheckUpRight
                                    && CheckMidRight > CheckUpMid
                                    && CheckMidRight > CheckMidLeft
                                    && CheckMidRight > CheckDownLeft
                                    && CheckMidRight > CheckDownMid
                                    && CheckMidRight > CheckDownRight)
                            {
                                x = x + 1;
                                g2d.drawLine(x, y, x, y);
                                Count++;
                                elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                                if (lastElevation == elevation)
                                {
                                    riverEnd = true;
                                }
                                lastElevation = elevation;
                                if (getElevation(seed, EXPO, FEATURE_SIZE, x, y) < BiomeCheck.SeaLevel)
                                {

                                    riverEnd = true;
                                }
                            } else if (CheckUpMid > CheckUpLeft
                                    && CheckUpMid > CheckUpRight
                                    && CheckUpMid > CheckMidRight
                                    && CheckUpMid > CheckMidLeft
                                    && CheckUpMid > CheckDownLeft
                                    && CheckUpMid > CheckDownMid
                                    && CheckUpMid > CheckDownRight)
                            {
                                y = y + 1;
                                g2d.drawLine(x, y, x, y);
                                Count++;
                                elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                                if (lastElevation == elevation)
                                {
                                    riverEnd = true;
                                }
                                lastElevation = elevation;
                                if (getElevation(seed, EXPO, FEATURE_SIZE, x, y) < BiomeCheck.SeaLevel)
                                {
                                    riverEnd = true;
                                }
                            } else if (CheckDownMid > CheckUpLeft
                                    && CheckDownMid > CheckUpRight
                                    && CheckDownMid > CheckMidRight
                                    && CheckDownMid > CheckMidLeft
                                    && CheckDownMid > CheckDownLeft
                                    && CheckDownMid > CheckUpMid
                                    && CheckDownMid > CheckDownRight)
                            {
                                y = y - 1;
                                g2d.drawLine(x, y, x, y);
                                Count++;
                                elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                                if (lastElevation == elevation)
                                {
                                    riverEnd = true;
                                }
                                lastElevation = elevation;
                                if (getElevation(seed, EXPO, FEATURE_SIZE, x, y) < BiomeCheck.SeaLevel)
                                {
                                    riverEnd = true;
                                }
                            } else if (CheckDownLeft > CheckUpLeft
                                    && CheckDownLeft > CheckUpRight
                                    && CheckDownLeft > CheckMidRight
                                    && CheckDownLeft > CheckMidLeft
                                    && CheckDownLeft > CheckDownMid
                                    && CheckDownLeft > CheckUpMid
                                    && CheckDownLeft > CheckDownRight)
                            {
                                y = y - 1;
                                x = x - 1;
                                g2d.drawLine(x, y, x, y);
                                Count++;
                                elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                                if (lastElevation == elevation)
                                {
                                    riverEnd = true;
                                }
                                lastElevation = elevation;
                                if (getElevation(seed, EXPO, FEATURE_SIZE, x, y) < BiomeCheck.SeaLevel)
                                {
                                    riverEnd = true;
                                }
                            }
                            else if (CheckUpLeft > CheckDownLeft
                                    && CheckUpLeft > CheckUpRight
                                    && CheckUpLeft > CheckMidRight
                                    && CheckUpLeft > CheckMidLeft
                                    && CheckUpLeft > CheckDownMid
                                    && CheckUpLeft > CheckUpMid
                                    && CheckUpLeft > CheckDownRight)
                            {
                                y = y + 1;
                                x = x - 1;
                                g2d.drawLine(x, y, x, y);
                                Count++;
                                elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                                if (lastElevation == elevation)
                                {
                                    riverEnd = true;
                                }
                                lastElevation = elevation;
                                if (getElevation(seed, EXPO, FEATURE_SIZE, x, y) < BiomeCheck.SeaLevel)
                                {
                                    riverEnd = true;
                                }
                            }
                        else if
                            (CheckUpRight > CheckDownLeft
                            && CheckUpRight > CheckUpLeft
                            && CheckUpRight > CheckMidRight
                            && CheckUpRight > CheckMidLeft
                            && CheckUpRight > CheckDownMid
                            && CheckUpRight > CheckUpMid
                            && CheckUpRight > CheckDownRight)
                            {
                                y = y + 1;
                                x = x + 1;
                                g2d.drawLine(x, y, x, y);
                                Count++;
                                elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                                if (lastElevation == elevation)
                                {
                                    riverEnd = true;
                                }
                                lastElevation = elevation;
                                if (getElevation(seed, EXPO, FEATURE_SIZE, x, y) < BiomeCheck.SeaLevel)
                                {
                                    riverEnd = true;
                                }
                            }
                        else if (CheckDownRight > CheckDownLeft
                                    && CheckDownRight > CheckUpLeft
                                    && CheckDownRight > CheckMidRight
                                    && CheckDownRight > CheckMidLeft
                                    && CheckDownRight > CheckDownMid
                                    && CheckDownRight > CheckUpMid
                                    && CheckDownRight > CheckUpRight)
                        {
                                y = y - 1;
                                x = x + 1;
                                g2d.drawLine(x, y, x, y);
                                Count++;
                                elevation = (getElevation(seed, EXPO, FEATURE_SIZE, x, y));
                                if (lastElevation == elevation)
                                {
                                    riverEnd = true;
                                }
                                lastElevation = elevation;
                                if (getElevation(seed, EXPO, FEATURE_SIZE, x, y) < BiomeCheck.SeaLevel)
                                {
                                    riverEnd = true;
                                }
                            } else
                            {
                                riverEnd = true;
                            }
                        }
                        y = SaveY;
                        x = SaveX;
                    }
                }
            }
        }
    }
}
