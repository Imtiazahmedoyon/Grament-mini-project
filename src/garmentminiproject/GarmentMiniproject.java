
package garmentminiproject;


public class GarmentMiniproject {

    
    public static void main(String[] args) {
        Garment g1 = new Garment();
        g1.name = "Silk";
        g1.description = "Good Product";
        g1.price = 600;

        double discountPrice = g1.calculateDiscountPrice(10);
        System.out.println("Discount Price: " + discountPrice);
        
    }
    
}
