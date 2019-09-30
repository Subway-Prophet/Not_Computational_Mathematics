import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class MainForm
    {
        private JPanel RootPanel;
        private JButton generateMapButton;
        private JButton closeZoomButton;
        private JButton midZoomButton;
        private JButton farZoomButton;
        private JButton LowSeaButton;
        private JButton oopsGlobalWarmingButton;
        private JButton defaultSeaLevelButton;
        private JButton button4;
        private JButton button5;
        private JButton lavaButton;

        private static final int HEIGHT = 920;
        private static final int WIDTH = 1920;
        public static double MapZoom = 124;
        public static int MapType = 1;
        public static boolean RiverToggle = false;


        public MainForm()
        {
            generateMapButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    JFrame frame1 = new JFrame("imageForm");
                    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    if (RiverToggle)
                    {
                        frame1.add(new RiverTest());
                        frame1.setVisible(true);
                    }
                    else
                    {
                        frame1.add(new JungleTerrain());
                        frame1.setVisible(true);
                    }
                }
            });
            closeZoomButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    MapZoom = 324;
                }
            });
            midZoomButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    MapZoom = 124;
                }
            });
            farZoomButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    MapZoom = 50;
                }
            });
            LowSeaButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    BiomeCheck.SeaLevel = -0.5;
                }
            });
            defaultSeaLevelButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    BiomeCheck.SeaLevel = 0.1;
                }
            });
            oopsGlobalWarmingButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    BiomeCheck.SeaLevel = 0.5;
                }
            });
            lavaButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    if (JungleTerrain.lava)
                        JungleTerrain.lava = false;
                    else
                        JungleTerrain.lava = true;
                }
            });
            button5.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    if (RiverToggle)
                    RiverToggle = false;
                    else
                        RiverToggle = true;
                }
            });
        }

        public static void main(String[] args)
        {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainForm().RootPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        }

    }
