import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class PanelSampleYard extends JPanel {
    // Charlie Wang ID: 1675918
    private final Yard yard; // the currently displayed yard
    private static double runningCost = 0; // running total of revenue
    private static final DecimalFormat df = new DecimalFormat("0.00"); // ensure money format (2 decimals)

    public PanelSampleYard(Yard yard, boolean atFinalIndex) {
        this.yard = yard;
        if (atFinalIndex) runningCost = 0; // reset the running total when looping around
        initializePanel(); // create empty JPanel
        displayYardInformation(); // add Yard info to JPanel
    }

    private void initializePanel() {
        setLayout(new GridLayout(8, 2));
        setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 10));
    }

    private void displayYardInformation() {
        addLabel("Last Name:", yard.getLastName());
        addLabel("First Name:", yard.getFirstName());
        addLabel("Lawn Size:", String.valueOf(yard.getSize()));
        addLabel("Number Of Trees:", String.valueOf(yard.getNumberTrees()));
        addLabel("Garden Size:", String.valueOf(yard.getGardenSize()));
        addLabel("Double Driveway:", yard.getDoubleDriveway());
        addLabel("Total Cost:", "$"+df.format(yard.getCost()));
        addLabel("Running Cost:", "$"+df.format(runningCost += yard.getCost()));
    }

    private void addLabel(String labelText, String valueText) {
        // create a single row entry in the table
        JLabel label = new JLabel(labelText);
        JTextField value = new JTextField(valueText);
        Font font = new Font("Arial", Font.BOLD, 16);
        label.setFont(font);
        value.setFont(font);
        value.setHorizontalAlignment(SwingConstants.RIGHT);
        value.setEditable(false);
        value.setBackground(UIManager.getColor("TextField.background"));
        add(label);
        add(value);
    }
}