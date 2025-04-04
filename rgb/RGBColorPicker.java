import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RGBColorPicker {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<Integer> redComboBox, greenComboBox, blueComboBox;
    private JButton showButton;

    public RGBColorPicker() {
        frame = new JFrame("RGB Color Picker");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(4, 2, 5, 5));

        controlPanel.add(new JLabel("Red:"));
        redComboBox = createColorComboBox();
        controlPanel.add(redComboBox);

        controlPanel.add(new JLabel("Green:"));
        greenComboBox = createColorComboBox();
        controlPanel.add(greenComboBox);

        controlPanel.add(new JLabel("Blue:"));
        blueComboBox = createColorComboBox();
        controlPanel.add(blueComboBox);

        showButton = new JButton("Show Output");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBackgroundColor();
            }
        });
        controlPanel.add(showButton);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private JComboBox<Integer> createColorComboBox() {
        Integer[] values = new Integer[256];
        for (int i = 0; i < 256; i++) {
            values[i] = i;
        }
        return new JComboBox<>(values);
    }

    private void updateBackgroundColor() {
        int red = (int) redComboBox.getSelectedItem();
        int green = (int) greenComboBox.getSelectedItem();
        int blue = (int) blueComboBox.getSelectedItem();
        panel.setBackground(new Color(red, green, blue));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RGBColorPicker::new);
    }
}
