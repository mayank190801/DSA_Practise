import java.io.*;
import java.util.*;

public class second {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] tasks = { { 19, 13 }, { 16, 9 }, { 21, 10 }, { 32, 25 }, { 37, 4 }, { 49, 24 }, { 2, 15 }, { 38, 41 },
                { 37, 34 }, { 33, 6 }, { 45, 4 }, { 18, 18 }, { 46, 39 }, { 12, 24 } };
        //
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] first, int[] second) {
                // compare n1 and n2
                return Integer.compare(first[1], second[1]);
            }
        });

        //
        ArrayList<Integer> ans = new ArrayList<>();
        int ansIndex = 0;
        //
        int[][] newTask = new int[tasks.length][3];

        for (int i = 0; i < tasks.length; i++) {
            newTask[i][0] = tasks[i][0];
            newTask[i][1] = tasks[i][1];
            newTask[i][2] = i;
        }

        // sorting the new array! with proper indexes!
        Arrays.sort(newTask, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                return Integer.compare(first[0], second[0]);
            }
        });

        // MAIN Question starts from here!!!!!!!
        int arrayIndex = 0;

        int timeRequire = newTask[0][0];

        while (arrayIndex < newTask.length || !pq.isEmpty()) {

            boolean flag1 = false, flag2 = false;
            if (arrayIndex < newTask.length) {
                while (timeRequire >= newTask[arrayIndex][0]) {
                    flag1 = true;
                    int[] arr = new int[3];
                    arr[0] = newTask[arrayIndex][0];
                    arr[1] = newTask[arrayIndex][1];
                    arr[2] = newTask[arrayIndex][2];
                    pq.add(arr);
                    arrayIndex++;

                    if (arrayIndex >= newTask.length) {
                        break;
                    }
                }
            }

            if (!pq.isEmpty()) {
                flag2 = true;
                timeRequire += pq.peek()[1];
                ans.add(pq.remove()[2]);
            }

            if (!flag1 && !flag2) {
                timeRequire = newTask[arrayIndex][0];
            }
        }
        int[] finalAns = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            finalAns[i] = ans.get(i);
        }

        System.out.println(Arrays.toString(finalAns));

    }

}