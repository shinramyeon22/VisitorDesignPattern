package VisitorPattern;

interface ShippingCostVisitor {
    double visitChair(Chair chair);
    double visitTable(Table table);
    double visitSofa(Sofa sofa);
    double visitBed(Bed bed);
}