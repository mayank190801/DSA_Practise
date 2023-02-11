import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Scanner;

import java.io.OutputStreamWriter;

public class fouth2 {

    private static class Node {

        private int data;
        private int index;
        private int depth;
        private Node leftChild;
        private Node rightChild;

        Node(int data, int index) {
            this.data = data;
            this.index = index;
        }

    }

    private static Node root;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = scan.nextInt();
        while (test-- > 0) {

            int size = scan.nextInt();
            int[][] arr = new int[size][2];
            int[] question = new int[size];
            int[] depth = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i][0] = scan.nextInt();
                arr[i][1] = i;
            }

            for (int i = 0; i < size; i++) {
                question[i] = arr[i][0];
            }

            // now i would have to sort this array in my fashion!
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] first, int[] second) {
                    return Integer.compare(second[0], first[0]);
                }

            });

            // now this much is done!!! I just have to put the elements in the tree now!
            int depthCount = 1;

            for (int i = 0; i < size; i++) {
                var node = new Node(arr[i][0], arr[i][1]);
                if (root == null) {
                    root = node;
                    depth[arr[i][0] - 1] = 0;

                    continue;
                }
                depthCount = 1;
                var current = root;
                while (true) {
                    if (current.index > arr[i][1]) {

                        if (current.leftChild == null) {
                            current.leftChild = node;
                            depth[arr[i][0] - 1] = depthCount;
                            break;
                        }
                        current = current.leftChild;
                        depthCount++;
                    } else {

                        if (current.rightChild == null) {
                            current.rightChild = node;
                            depth[arr[i][0] - 1] = depthCount;
                            break;
                        }
                        current = current.rightChild;
                        depthCount++;
                    }
                }

            }

            for (int i = 0; i < size; i++) {
                output.write(depth[question[i] - 1] + " ");
            }
            output.write("\n");
            // output.write("NO" + "\n");
            root = null;
        }

        output.flush();
        output.close();
    }

}