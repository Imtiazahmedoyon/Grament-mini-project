
package garmentminiproject;

public class Fabric {
    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    double calculateCost(double meters) {
        return pricePerMeter * meters;
    
}
}
