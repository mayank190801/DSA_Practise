#include <bits/stdc++.h> 
using namespace std;

//a game of pointers is a lot more prevalent in herre

int solve(int m, int n, vector<vector<int>> &mat){
    for(int i = 0; i < 9 ; i++){
        for(int j = 0; j < 9 ; j++){
            cout << mat[i][j] << " ";
        }
        cout << endl;
    }


    return 0;
}
 
int main(){

    #ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
    #endif

    //code from below
    //pre made array was definitely required for sure
    //how to freaking code with this language man, it's annoying
    

    vector<vector<int>> mat(9);

    mat[1][9] = 4;


    cout << mat[1][9] << endl;

    int n = 2;

    int answer = solve(9,9, mat);
    return 0;
}