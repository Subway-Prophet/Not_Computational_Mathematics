
public class BiomeCheck
{
    public static double SeaLevel = 0.1;
        public static int CheckBiome(Double elevation)
        {
            if (elevation < SeaLevel)
                return 0;
            else if (elevation < SeaLevel + .02)
                return 1;
            else if (elevation < SeaLevel + .1)
                return 2;
            else if (elevation < SeaLevel + .2)
                return 3;
            else if (elevation < SeaLevel + .3)
                return 4;
            else if (elevation < SeaLevel + .4)
                return 5;
            else if (elevation < SeaLevel + .5)
                return 6;
            else if (elevation < SeaLevel + .6)
                return 7;
            else if (elevation < SeaLevel + .7)
                return 8;
            else if (elevation < SeaLevel + .8)
                return 9;
            else if (elevation < SeaLevel + .9)
                return 10;
            else if (elevation < SeaLevel + 1)
                return 11;
            else if (elevation < SeaLevel + 1.1)
                return 12;
            else if (elevation < SeaLevel + 1.2)
                return 13;
            else if (elevation < SeaLevel + 1.3)
                return 14;
            else if (elevation < SeaLevel + 1.4)
                return 15;
            else
                return 16;
        }
}
