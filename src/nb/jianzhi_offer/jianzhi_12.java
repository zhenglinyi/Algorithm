package nb.jianzhi_offer;

public class jianzhi_12 {
}







//dfs+剪枝
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,words,i,j,0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board,char[] word,int i,int j,int k){
        //数组越界或者字符不匹配返回false
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        //k个匹配成功，返回true
        if(k == word.length - 1)
            return true;
        //匹配现在的字符，把当前字符替换为’\0‘，为了防止重复匹配
        board[i][j] = '\0';
        //下上右左遍历
        boolean res =
                        dfs(board, word, i + 1, j, k + 1) ||
                        dfs(board, word, i - 1, j, k + 1) ||
                        dfs(board, word, i, j + 1, k + 1) ||
                        dfs(board, word, i, j - 1, k + 1);
        //最后要改过来
        board[i][j] = word[k];
        return res;

    }
}
