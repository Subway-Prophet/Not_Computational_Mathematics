
public class BiomeCheck
{
        public static int CheckBiome(Double elevation)
        {
            if (elevation < 0.1)
                return 0;
            else if (elevation < 0.15)
                return 1;
            else if (elevation < 0.2)
                return 2;
            else if (elevation < 0.3)
                return 3;
            else if (elevation < 0.4)
                return 4;
            else if (elevation < 0.5)
                return 5;
            else if (elevation < 0.6)
                return 6;
            else if (elevation < 0.7)
                return 7;
            else if (elevation < 0.8)
                return 8;
            else
                return 9;
        }
}
