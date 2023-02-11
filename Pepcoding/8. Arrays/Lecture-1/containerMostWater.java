public class containerMostWater {

    //method-1  O(n^2) //simple method
    //method-2  O(n) //two pointers, ek aage piche according to question

    //simple greedy method, not requiring left greatest and right greates shit
    //easy and simple bois
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length-1;

        int area = 0;
        while(p1 < p2){
            int carea = Math.min(height[p1], height[p2]) * (p2-p1);
            area = Math.max(carea, area);

            if(height[p1] <= height[p2]){
                p1++;
            }else{
                p2--;
            }
        }

        return area;
    }
}
