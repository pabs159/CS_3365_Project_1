import java.awt.*;
import javax.swing.*;



//Create a simple GUI window
public class TopLevelWindow {
   
    public static void addComponentsToPane(String Summary, Double WindGust, Double Temp, Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
 
        addText("Currrent Conditions: "+Summary, pane);
        addText("Temperature: "+Temp + " F", pane); 
        addText("Wind Gust: "+WindGust +" MPH", pane);

    }
 
    private static void addText(String text, Container container) {
        JLabel textLabel = new JLabel(text);
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(textLabel);
    }


    public static void createWindow(String Summary, Double WindGust, Double Temp) {
        
        JFrame frame = new JFrame("Widget GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        
        //JLabel textLabel = new JLabel("Window label", SwingConstants.CENTER);
        //textLabel.setPreferredSize(new Dimension(500,250));
        //frame.getContentPane().add(textLabel, BorderLayout.CENTER);
        
        //frame.getContentPane().setLayout(new FlowLayout());
        
        addComponentsToPane(Summary, WindGust, Temp, frame.getContentPane());

        
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);






    }


}


