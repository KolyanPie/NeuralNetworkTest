package ru.kolyanpie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class Layer {
    private final List<Node> nodes;

    public Layer() {
        nodes = new ArrayList<>();
    }

    public Layer(int numberOfNodes) {
        this();
        makeNodes(numberOfNodes);
    }

    public void addNodes(Node... nodes) {
        this.nodes.addAll(List.of(nodes));
    }

    public void makeNodes(int numberOfNodes) {
        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(new Node());
        }
    }

    public void makeNodes(int numberOfNodes, DoubleUnaryOperator func) {
        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(new Node(func));
        }
    }

    public void calculate() {
        for (Node node : nodes) {
            node.calculate();
        }
    }

    public void next(Layer layer) {
        for (Node node : layer.nodes) {
            node.addTransitions(nodes.toArray(new Node[0]));
        }
    }

    public int size() {
        return nodes.size();
    }
}
