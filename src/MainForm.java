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
        private JButton generatePointsButton;
        private JLabel Title;
        private JLabel LeftLabel;
        private JLabel RightLabel;
        private JButton ZoomedButton;
        private JButton standardViewButton;
        private JButton fractalButton;
        private JButton islandsButton;
        private JButton connectedButton;
        private JButton farViewButton;

        private static final int HEIGHT = 750;
        private static final int WIDTH = 750;
        public static double MapZoom = 124;
        public static int MapType = 1;


        public MainForm()
        {
            generateMapButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent actionEvent)
                {
                    JFrame frame1 = new JFrame("imageForm");
                    frame1.setSize(WIDTH, HEIGHT);
                    frame1.add(new JungleTerrain());
                    frame1.setVisible(true);
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
        }

        public static void main(String[] args)
        {
            JFrame frame = new JFrame("MainForm");
            frame.setContentPane(new MainForm().RootPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setSize(WIDTH, HEIGHT);
            frame.setVisible(true);
        }

    }
