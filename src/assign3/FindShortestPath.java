package assign3;

import java.io.IOException;

/**
 * Implements an algorithm to compute the shortest path from a dungeons initial chamber to the exit
 *
 * @author Michael Quick
 * @version 1.0, 2023/03/21
 */

public class FindShortestPath {
    public static void main(String[] args) {
        // Try to open the file, catch for any IOExceptions
        try {
            // If the length of args is less than 1 then there was no dungeon selected
            if (args.length < 1) throw new IllegalArgumentException("Missing file path argument (args < 1)");
            Dungeon dungeon = new Dungeon(args[0]);
            DLPriorityQueue<Hexagon> priorityQueue = new DLPriorityQueue<>();
            Hexagon start = dungeon.getStart();
            boolean pathFound = false;

            // Add the starting chamber to the priority queue and mark it as enqueued
            priorityQueue.add(start, 0);
            start.markEnqueued();

            // Search through all the chambers until the exit is found
            while (!priorityQueue.isEmpty() && !pathFound) {
                // Get the chamber with the smallest priority and remove it from the queue
                Hexagon curr = priorityQueue.removeMin();
                curr.markDequeued();

                if (curr.isExit()) {
                    // Exit found, leave the loop
                    pathFound = true;
                }

                // Loop through all neighbors
                for (int i = 0; i < 6; i++) {
                    Hexagon neighbor = curr.getNeighbour(i);
                    if (neighbor == null || neighbor.isWall() || neighbor.isMarkedDequeued()) {
                        // This neighbor is either null, a wall, or dequeued, so it should be skipped
                        continue;
                    }

                    // Check if the neighbor is adjacent to a dragon
                    boolean neighborAdjacentToDragon = false;
                    for (int j = 0; j < 6; j++) {
                        Hexagon neighborNeighbor = neighbor.getNeighbour(j);
                        if (neighborNeighbor != null && neighborNeighbor.isDragon()) {
                            neighborAdjacentToDragon = true;
                            break;
                        }
                    }

                    // If the current chamber is a dragon or the neighbor is adjacent to a dragon, move on to the next chamber
                    if (curr.isDragon() || neighborAdjacentToDragon)
                        continue;

                    // Calculate the distance from the current chamber to the starting chamber
                    int d = curr.getDistanceToStart() + 1;
                    if (d < neighbor.getDistanceToStart()) {
                        neighbor.setDistanceToStart(d);
                        neighbor.setPredecessor(curr);

                        if (neighbor.isMarkedEnqueued()) {
                            priorityQueue.updatePriority(neighbor, neighbor.getDistanceToStart() + neighbor.getDistanceToExit(dungeon));
                        } else {
                            priorityQueue.add(neighbor, neighbor.getDistanceToStart() + neighbor.getDistanceToExit(dungeon));
                            neighbor.markEnqueued();
                        }
                    }
                }

            }

            // Print the number of chambers in the path from start to exit
            int pathLength = 0;
            Hexagon current = dungeon.getExit();
            while (current != null) {
                pathLength++;
                current = current.getPredecessor();
            }

            // Check if a path was found then print the response accordingly
            if (pathFound)
                System.out.println("Path of length " + pathLength + " found");
            else System.out.println("No path found");

        } catch (IOException e) {
            // Something went wrong when reading the file
            e.printStackTrace();
        }
    }
}
