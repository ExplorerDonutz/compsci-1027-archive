package assign3;

import java.io.IOException;

public class FindShortestPath {
    public static void main(String[] args) {
        try {
            Dungeon dungeon = new Dungeon(args[0]);
            DLPriorityQueue<Hexagon> priorityQueue = new DLPriorityQueue<>();
            Hexagon hex = dungeon.getStart();

            priorityQueue.add(hex, 0);
            hex.markEnqueued();

            while (!priorityQueue.isEmpty() && !hex.equals(dungeon.getExit())) {
                // Remove chamber with smallest priority and mark is as dequeued
                hex = priorityQueue.removeMin();
                hex.markDequeued();

                boolean isNeighborDragon = false;
                for (int i = 0; i < 5; i++) {
                    if (hex.getNeighbour(i).isDragon()) {
                        isNeighborDragon = true;
                        break;
                    }
                }

                if (hex.isDragon() || isNeighborDragon)
                    continue;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
