## Furniture Shipping Cost Calculator – Visitor Pattern

This project demonstrates the **Visitor Design Pattern** to calculate shipping costs for different types of furniture in an e-commerce system.

### Problem
Different furniture types (chairs, tables, sofas, beds, etc.) require unique shipping cost logic:
- Lightweight items (e.g., chairs) → simple flat rate + small weight surcharge
- Bulky/heavy items (e.g., sofas, beds) → volumetric weight, distance-based rates, higher multipliers

Adding shipping rules directly inside each furniture class would:
- Violate **Single Responsibility Principle**
- Create tight coupling
- Make it hard to add new furniture types or new shipping policies

### Solution: Visitor Pattern

The Visitor pattern allows us to:
- Define new operations (shipping rules) without modifying existing furniture classes
- Keep each shipping policy in its own class
- Easily add new furniture types or new pricing strategies

#### Design Elements Used

| Element                  | Name in this project                  | Purpose                                                                 |
|--------------------------|----------------------------------------|-------------------------------------------------------------------------|
| **Element Interface**    | `Furniture`                            | Declares the `accept()` method that accepts a visitor                 |
| **Concrete Elements**    | `Chair`, `Table`, `Sofa`, `Bed`        | Represent furniture products – each implements `accept()`              |
| **Visitor Interface**    | `ShippingCostVisitor`                  | Declares a `visitXxx()` method for **each** concrete element type      |
| **Concrete Visitors**    | `MetroManilaFlatRateVisitor`<br>`ProvincialDistanceVisitor` | Implement different shipping policies (flat rate vs. distance-based)   |
| **Client**               | `FurnitureShippingDemo`                | Creates furniture items, creates visitors, and applies them            |


### UML Diagram
![alt text](https://github.com/shinramyeon22/VisitorDesignPattern/blob/25e4e0bb623a92edb9a7befa23642111c31adbcb/VisitorDesignPattern.png)
