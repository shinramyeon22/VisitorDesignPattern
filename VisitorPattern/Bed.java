package VisitorPattern;

class Bed implements Furniture {
    private String name;
    private double weightKg;
    private double volumeM3;

    public Bed(String name, double weightKg, double volumeM3) {
        this.name = name;
        this.weightKg = weightKg;
        this.volumeM3 = volumeM3;
    }

    @Override
    public double accept(ShippingCostVisitor visitor) {
        return visitor.visitBed(this);
    }

    @Override public String getName() { return name; }
    @Override public double getWeightKg() { return weightKg; }
    @Override public double getVolumeCubicMeters() { return volumeM3; }
}