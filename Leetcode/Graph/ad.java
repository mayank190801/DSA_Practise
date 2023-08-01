public class ad {
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    //
    public static int edgeScore(int[] edges) {
        int n = edges.length;
        int[] count = new int[n];
        int maxC = -1;
        int ptrNode = 0;
        for (int i = 0; i < n; i++) {
            int pt = edges[i];
            count[pt] += i;
            if (count[pt] >= maxC) {
                if (count[pt] > maxC) {
                    ptrNode = pt;
                    maxC = count[pt];
                } else {
                    ptrNode = Math.min(ptrNode, pt);
                }

            }
        }
        return ptrNode;
    }

}
