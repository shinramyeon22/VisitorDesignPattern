package VisitorPattern;

class ProvincialDistanceVisitor implements ShippingCostVisitor {
    private final double distanceKm;

    public ProvincialDistanceVisitor(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    private double baseRatePerKm() {
        return 4.5 + (distanceKm * 0.008);   // slightly increasing rate for longer distances
    }

    @Override
    public double visitChair(Chair chair) {
        double volumetricWeight = chair.getVolumeCubicMeters() * 250; // kg/m³ factor
        double chargeableWeight = Math.max(chair.getWeightKg(), volumetricWeight);
        return chargeableWeight * baseRatePerKm() * 1.1;
    }

    @Override
    public double visitTable(Table table) {
        double volumetricWeight = table.getVolumeCubicMeters() * 220;
        double chargeableWeight = Math.max(table.getWeightKg(), volumetricWeight);
        return chargeableWeight * baseRatePerKm() * 1.3;
    }

    @Override
    public double visitSofa(Sofa sofa) {
        double volumetricWeight = sofa.getVolumeCubicMeters() * 180;
        double chargeableWeight = Math.max(sofa.getWeightKg(), volumetricWeight);
        return chargeableWeight * baseRatePerKm() * 2.0; // bulky item multiplier
    }

    @Override
    public double visitBed(Bed bed) {
        double volumetricWeight = bed.getVolumeCubicMeters() * 200;
        double chargeableWeight = Math.max(bed.getWeightKg(), volumetricWeight);
        return chargeableWeight * baseRatePerKm() * 1.8;
    }
}