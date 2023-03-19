package assign3;

import java.io.IOException;

public class FindShortestPath {
    public static void main(String[] args) {
        try {
            Dungeon dungeon = new Dungeon(args[0]);
            DLPriorityQueue<Hexagon> priorityQueue = new DLPriorityQueue<>();
            Hexagon start = dungeon.getStart();

            priorityQueue.add(start, 0);
            start.markEnqueued();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
