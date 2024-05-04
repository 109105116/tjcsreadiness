import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplaySampleYard extends JFrame {
    private final ArrayList<Yard> yardList; // array of yards
    private JPanel mainPanel; // panel to display yard data
    private int currIndex; // which yard the GUI is on

    public DisplaySampleYard(ArrayList<Yard> yardList) {
        this.yardList = yardList;
        this.currIndex = 0;
        initializeGUI();
        displayYardInformation();
    }

    private void initializeGUI() {
        // configure JFrame
        setTitle("Sample CS Readiness Test");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // configure title
        JLabel title = new JLabel("Green and Grow Mowing Company", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(title, BorderLayout.NORTH);

        // configure mainPanel
        mainPanel = new JPanel(new GridLayout(0, 1));
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        add(scrollPane, BorderLayout.CENTER);

        // create a "Next" button
        JButton nextButton = new JButton("Next");
        // listen for a click event
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // display the next yard
                showNextYard();
            }
        });

        // create a "Quit" button
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // close the window
                dispose();
            }
        });

        // configure the buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void displayYardInformation() {
        // refresh the yard data inside mainPanel
        mainPanel.removeAll();
        PanelSampleYard panel = new PanelSampleYard(yardList.get(currIndex), currIndex==0);
        mainPanel.add(panel);
        revalidate();
        repaint();
    }

    private void showNextYard() {
        currIndex++; // increment currIndex to show the next yard in yardList
        currIndex %= yardList.size(); // loop back to the beginning of the array
        displayYardInformation();
    }
}
