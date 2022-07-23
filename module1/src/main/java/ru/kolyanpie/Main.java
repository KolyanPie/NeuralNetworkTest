package ru.kolyanpie;

public class Main {
    public static void main(String[] args) {
        SimpleNetwork simpleNetwork = new SimpleNetwork(4, 2, 2, 1);
        System.out.println(simpleNetwork.calculate(new double[] {4}));
    }
}
