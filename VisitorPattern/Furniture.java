package VisitorPattern;

interface Furniture {
    double accept(ShippingCostVisitor visitor);
    String getName();
    double getWeightKg();
    double getVolumeCubicMeters();   // length × width × height / 1,000,000
}