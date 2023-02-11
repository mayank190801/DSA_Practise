public class paintHouse {

    public int minCost(int[][] costs) {
        //dopest question of the day bois
        //har case pr min bas dekhlo (simple as that)
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for(int i= 0; i < costs.length; i++){
            int nc1 = Math.min(c2, c3) + costs[i][0];
            int nc2 = Math.min(c1, c3) + costs[i][1];
            int nc3 = Math.min(c2, c1) + costs[i][2];

            c1 = nc1;
            c2 = nc2;
            c3 = nc3;
            
        }

        return Math.min(c1,Math.min(c2,c3));

    }

    //Same above logic, but not for 3 but k now!!!
    //but but you could remove k iterations by taking two min variables!!!
    //dope shit to even more efficient it!! H.W
    public int minCostII(int[][] costs) {

        
    }

}
