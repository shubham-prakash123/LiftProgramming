package com.example.liftprogramming;

import java.util.ArrayList;
import java.util.List;

public class Utility {

    private List<Integer> finalOrder = new ArrayList<>();

    private int m,n = 0;

    public Utility() {

    }

    public List<Integer> getSequence(List<String> floorSequence, List<String> directionSequence) {

        if (floorSequence.size() == 0) {
            return null;
        }
        m = n = 0;
        finalOrder.clear();

        int[] newFloorSequenceUp = new int[floorSequence.size()];
        String[] newDirectionSequenceUp = new String[directionSequence.size()];

        int[] newFloorSequenceDown = new int[floorSequence.size()];
        String[] newDirectionSequenceDown = new String[directionSequence.size()];

        for (int i = 0 ; i < floorSequence.size() ; i++) {
            if(directionSequence.get(i).equals("UP")) {
                newFloorSequenceUp[m] = Integer.parseInt(floorSequence.get(i));
                newDirectionSequenceUp[m] = directionSequence.get(i);
                m++;
            }
        }

        for (int i = 0 ; i < floorSequence.size() ; i++) {
            if(directionSequence.get(i).equals("DOWN")) {
                newFloorSequenceDown[n] = Integer.parseInt(floorSequence.get(i));
                newDirectionSequenceDown[n] = directionSequence.get(i);
                n++;
            }
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = i; j < m - i - 1; j++) {
                if (newFloorSequenceUp[j] > newFloorSequenceUp[j+1]) {
                    int tmp = newFloorSequenceUp[j];
                    newFloorSequenceUp[j] = newFloorSequenceUp[j+1];
                    newFloorSequenceUp[j+1] = tmp;

                    String tmp1 = newDirectionSequenceUp[j];
                    newDirectionSequenceUp[j] = newDirectionSequenceUp[j+1];
                    newDirectionSequenceUp[j+1] = tmp1;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - i - 1; j++) {
                if (newFloorSequenceDown[j] < newFloorSequenceDown[j+1]) {
                    int tmp = newFloorSequenceDown[j];
                    newFloorSequenceDown[j] = newFloorSequenceDown[j+1];
                    newFloorSequenceDown[j+1] = tmp;

                    String tmp1 = newDirectionSequenceDown[j];
                    newDirectionSequenceDown[j] = newDirectionSequenceDown[j+1];
                    newDirectionSequenceDown[j+1] = tmp1;
                }
            }
        }

        for (int i = 0 ; i < m ; i++) {
            finalOrder.add(newFloorSequenceUp[i]);
        }
        for (int i = 0 ; i < n ; i++) {
            finalOrder.add(newFloorSequenceDown[i]);
        }
        return finalOrder;
    }
}
