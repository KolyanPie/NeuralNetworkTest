package ru.kolyanpie;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class Node {
    public static final DoubleUnaryOperator SIGMOID = (x) -> 1d / (1 + Math.exp(-x));
    private double value;
    private final List<Edge> inputs;
    private final DoubleUnaryOperator func;

    public Node() {
        this.inputs = new ArrayList<>();
        this.func = SIGMOID;
    }

    public Node(DoubleUnaryOperator func) {
        this.inputs = new ArrayList<>();
        this.func = func;
    }

    public double getValue() {
        return value;
    }

    public void addTransitions(Node... inputNodes) {
        addTransitions(Edge.DEFAULT_COEFFICIENT, inputNodes);
    }

    public void addTransitions(double defaultCoefficient, Node... inputNodes) {
        for (Node inputNode : inputNodes) {
            inputs.add(new Edge(defaultCoefficient, inputNode));
        }
    }

    public void calculate() {
        value = 0;
        for (Edge input : inputs) {
            value += input.getNode().getValue() * input.getCoefficient();
        }
        value = func.applyAsDouble(value);
    }
}
