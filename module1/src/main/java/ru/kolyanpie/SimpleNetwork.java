package ru.kolyanpie;

import java.util.ArrayList;
import java.util.List;

public class SimpleNetwork {
    private final List<Layer> layers;

    public SimpleNetwork(int... nodeCounts) {
        this.layers = new ArrayList<>();
        for (int nodeCount : nodeCounts) {
            layers.add(new Layer(nodeCount));
        }
        for (int i = 0; i < layers.size() - 1; ) {
            layers.get(i).next(layers.get(++i));
        }
    }

    public double calculate(double[] inputs) {
        if (inputs.length != layers.get(0).size()) {
            throw new RuntimeException(
                    String.format("Number of your inputs %s not equals number of NN inputs %s",
                            inputs.length,
                            layers.get(0).size()
                    )); //TODO
        }
        return 0;
    }
}
