package VisitorPattern;

class MetroManilaFlatRateVisitor implements ShippingCostVisitor {
    private static final double BASE_RATE_CHAIR  = 180.0;
    private static final double BASE_RATE_TABLE  = 350.0;
    private static final double BASE_RATE_SOFA   = 1200.0;
    private static final double BASE_RATE_BED    = 950.0;

    private static final double KG_SURCHARGE     = 15.0;

    @Override
    public double visitChair(Chair chair) {
        return BASE_RATE_CHAIR + chair.getWeightKg() * KG_SURCHARGE;
    }

    @Override
    public double visitTable(Table table) {
        return BASE_RATE_TABLE + table.getWeightKg() * KG_SURCHARGE * 1.4;
    }

    @Override
    public double visitSofa(Sofa sofa) {
        // Sofas are bulky → higher base + volume factor
        return BASE_RATE_SOFA + sofa.getWeightKg() * 22.0 + sofa.getVolumeCubicMeters() * 1800;
    }

    @Override
    public double visitBed(Bed bed) {
        return BASE_RATE_BED + bed.getWeightKg() * 18.0 + bed.getVolumeCubicMeters() * 1400;
    }
}