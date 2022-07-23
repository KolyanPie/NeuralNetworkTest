package ru.kolyanpie;

class Edge {
    public static final double DEFAULT_COEFFICIENT = 0.5;
    private double coefficient;
    private final Node node;

    public Edge(double coefficient, Node node) {
        this.coefficient = coefficient;
        this.node = node;
    }

    double getCoefficient() {
        return coefficient;
    }

    Node getNode() {
        return node;
    }
}
