package nb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _51 {
}

class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard=new char[n][n];
        for(char[] c:chessboard){
            Arrays.fill(c,'.');
        }
        backTrack(n,0,chessboard);
        return res;
    }

    public void backTrack(int n,int row,char[][] chessboard){
        if(row==n){
            res.add(arrayToList(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if(isValid(row,col,n,chessboard)){
                chessboard[row][col]='Q';
                backTrack(n,row+1,chessboard);
                chessboard[row][col]='.';
            }
        }
    }

    public List arrayToList(char[][] chessboard){
        List<String> list=new ArrayList<>();
        for(char[] c: chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }
    public boolean isValid(int row,int col,int n,char[][] chessboard){
        //检查列
        for (int i = 0; i < row; i++) {
            if(chessboard[i][col]=='Q'){
                return false;
            }
        }
        //检查45度对角线
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }




}

//不使用二位字符数组定义棋盘
class Solution {
    List<List<String>> res=new ArrayList<>();
    List<String> tmp;
    public List<List<String>> solveNQueens(int n) {
        tmp=new ArrayList<>(n);
        String s="";
        for (int i = 0; i < n; i++) {
            tmp.add("");
            s=s+'.';
        }
        Collections.fill(tmp,s);

        backTrack(n,0);
        return res;
    }

    public void backTrack(int n,int row){
        if(row==n){
            res.add(tmp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if(isValid(row,col,n)){
                String tmps=tmp.get(row);
                tmp.set(row,tmps.substring(0,col)+'Q'+tmps.substring(col+1));
                backTrack(n,row+1);
                tmp.set(row,tmps);
            }
        }
    }


    public boolean isValid(int row,int col,int n){
        //检查列
        for (int i = 0; i < row; i++) {
            if(tmp.get(i).charAt(col)=='Q'){
                return false;
            }
        }
        //检查45度对角线
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if (tmp.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (tmp.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }




}