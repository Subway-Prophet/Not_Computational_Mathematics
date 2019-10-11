import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class MainForm
    {
        private JPanel RootPanel; //
        private JButton generateMapButton;
        private JCheckBox islandCheckBox;
        private JCheckBox riversCheckBox;
        private JCheckBox lavaCheckBox;
        private JSlider ZoomSlider;
        private JLabel TitleLabel;
        private JTextArea SeedEnter;
        private JButton randomButton;
        private JSlider slider1;
        private JCheckBox settlementsCheckBox;
        private JCheckBox namesCheckBox;
        private JCheckBox nationsCheckBox;
        private JCheckBox gradiantsCheckBox;

        public static boolean IslandToggle = false;
        public static double MapZoom = 124;
        public static int MapType = 1;
        public static boolean RiverToggle = false;
        public static boolean Lava = false;
        public static int seed = 0;


        public MainForm()
        {
            generateMapButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    JFrame frame1 = new JFrame("imageForm");
                    frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    int result = Integer.parseInt(SeedEnter.getText());
                    seed = result;
                    //seed = getRandomNumberInRange(42, 69696969);
                    Island.DrawRiver = false;
                    if (RiverToggle && IslandToggle)
                    {
                        Island.DrawRiver = true;
                        frame1.add(new Island());
                        frame1.setVisible(true);
                    }
                    else if (RiverToggle)
                    {
                        frame1.add(new RiverTest());
                        frame1.setVisible(true);
                    }
                    else if (IslandToggle)
                    {
                        frame1.add(new Island()); //Islands in the stream, that is what we are.
                        frame1.setVisible(true);
                    }
                    else
                        {
                        frame1.add(new JungleTerrain());
                        frame1.setVisible(true);
                    }
                }
            });
            lavaCheckBox.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    if (!Lava)

                         Lava = true;
                    else
                        Lava = false;

                }
            });
            islandCheckBox.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    if (IslandToggle)
                        IslandToggle = false;
                    else
                        IslandToggle = true;
                }
            });
            riversCheckBox.addActionListener(new ActionListener()
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
            randomButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    SeedEnter.setText(Integer.toString(getRandomNumberInRange(69, 42424242)));
                }
            });
        }

        public static void main(String[] args)
        {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainForm().RootPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(750, 750);
            frame.setVisible(true);
        }
        private static int getRandomNumberInRange(int min, int max)
        {

            if (min >= max)
            {
                throw new IllegalArgumentException("max must be greater than min"); //I don't ever want to feel like I did that day
            }

            Random r = new Random();
            return r.nextInt((max - min) + 1) + min; //Take me to the place I love, take me all the way
        }

    }
