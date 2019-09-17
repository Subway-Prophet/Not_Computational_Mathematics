public class River
{
    public static int RiverBaseX;
    public static int RiverBaseY;
    public static int RiverPathY[];
    public static int RiverPathX[];


    public static int[] getRiverPathX()
    {
        return RiverPathX;
    }
    public static int[] getRiverPathY()
    {
        return RiverPathY;
    }
    public static int getRiverBaseX()
    {
        return RiverBaseX;
    }
    public static int getRiverBaseY()
    {
        return RiverBaseY;
    }
    public River(int x, int y, int[] riverPathY, int[] riverPathX)
    {
        RiverBaseX = x;
        RiverBaseY = y;
        RiverPathY = riverPathY;
        RiverPathX = riverPathX;

    }


}
