package VisitorPattern;
import java.util.List;          

public class FurnitureShippingDemo {
    public static void main(String[] args) {

        List<Furniture> items = List.of(   
                new Chair("Ergonomic Office Chair", 12.5, 0.12),
                new Table("6-seater Dining Table", 38.0, 0.48),
                new Sofa("3-Seater Fabric Sofa", 65.0, 1.25),
                new Bed("Queen Size Bed Frame + Mattress", 82.0, 0.95)
        );

        ShippingCostVisitor metroVisitor = new MetroManilaFlatRateVisitor();

        System.out.println("=== Metro Manila Shipping Costs ===");
        for (Furniture item : items) {
            double cost = item.accept(metroVisitor);
            System.out.printf("%-28s → ₱%,.2f%n", item.getName(), cost);
        }

        System.out.println("\n=== Provincial (Cebu - ~570 km) Shipping Costs ===");
        ShippingCostVisitor provinceVisitor = new ProvincialDistanceVisitor(570);

        for (Furniture item : items) {
            double cost = item.accept(provinceVisitor);
            System.out.printf("%-28s → ₱%,.2f%n", item.getName(), cost);
        }

    }

}
