package nb.leetcode;

/**
 * @author shkstart
 * @date 2020-11-13 23:18
 */
public class _289 {
    public static void  gameOfLife(int[][] board) {
        //用来找每个节点的八个邻居
        int[] neighbors={0,1,-1};
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int liveNeighbors=0;
                for(int m=0;m<neighbors.length;m++){
                    for(int n=0;n<neighbors.length;n++){
                        //邻居的行和列
                        int r=i+neighbors[m];
                        int c=j+neighbors[n];
                        if(!(r==i&&c==j)&&r>=0&&r<row&&c>=0&&c<col&&(Math.abs(board[r][c])==1)){
                            liveNeighbors++;
                        }
                    }
                }
                //原来是活的
                if(board[i][j]==1){
                    //后来死了
                    if(liveNeighbors<2||liveNeighbors>3){
                        board[i][j]=-1;
                    }
                }else{//原来是活的
                    if(liveNeighbors==3){//后来活了
                        board[i][j]=2;
                    }
                }


            }
        }
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                board[i][j]=board[i][j]==-1?0:board[i][j];
                board[i][j]=board[i][j]==2?1:board[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(test);
    }
}

