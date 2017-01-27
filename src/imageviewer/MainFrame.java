package imageviewer;

import imageviewer.control.Command;
import imageviewer.ui.ImageDisplay;
import imageviewer.ui.swing.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{

    private final Map<String,Command> commands = new HashMap<>();
    private ImageDisplay imageDisplay;

    public MainFrame() {
        setTitle("Image Viewer");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(image());
        add(toolbar(),BorderLayout.SOUTH);
        setVisible(true);
    }

    void add(Command command) {
        commands.put(command.name(), command);
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    
    private Component image() {
        SwingImageDisplay swingImageDisplay = new SwingImageDisplay();
        imageDisplay=swingImageDisplay;
        return swingImageDisplay;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(button("prev"));
        panel.add(button("next"));
        return panel;
    }
    
    private Component button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(execute(name));
        return button;
    }
    
    private ActionListener execute(String name) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
            }
        };
    }

}