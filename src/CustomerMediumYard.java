import java.util.Objects;

public class CustomerMediumYard implements Yard{
    // Charlie Wang ID: 1675918
    private final String lastName;
    private final String firstName;
    private final int size;
    private final int numberTrees;
    private final int gardenSize;
    private final String doubleDriveway;

    public CustomerMediumYard(String lastName, String firstName, int size, int numberTrees, int gardenSize, String doubleDriveway) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.size = size;
        this.numberTrees = numberTrees;
        this.gardenSize = gardenSize;
        this.doubleDriveway = doubleDriveway;
    }

    @Override
    public double getCost() {
        double baseFee = 0.004*(size-gardenSize);
        double treeFee = (numberTrees%2 != 0 ? 0.05 : 0)*baseFee;
        double doubleDrivewayDiscount = (Objects.equals(doubleDriveway, "yes") ? -0.03 : 0)*baseFee;
        double gardenFee = (gardenSize>0 ? 10 : 0);
        return baseFee+treeFee+doubleDrivewayDiscount+gardenFee;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public int compareTo(Yard y) {
        return lastName.compareTo(y.getLastName());
    }

    @Override
    public int getNumberTrees() {
        return numberTrees;
    }

    @Override
    public int getGardenSize() {
        return gardenSize;
    }

    @Override
    public String getDoubleDriveway() {
        return doubleDriveway;
    }

    @Override
    public String toString() {
        return "Customer: " + getFirstName() + " " + getLastName() +
                ", Yard Size: " + getSize() +
                ", Number of Trees: " + getNumberTrees() +
                ", Garden Size: " + getGardenSize() +
                ", Double Driveway: " + getDoubleDriveway() + "\n";
    }

    @Override
    public int getSize() {
        return size;
    }
}
