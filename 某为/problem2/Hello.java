import java.util.*;

class Position{
    public Position(){

    }

    public Position(int row, int col){
        this.col = col;
        this.row = row;
    }

    int row;
    int col;
}

class Maze{
    public Maze(){
        maze = new int[100][100];
        stack = new Stack<Position>();
        p = new boolean[100][100];
    }

    /*
     * 构造迷宫
     */
    public void init(){
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        col = scanner.nextInt();
        step = scanner.nextInt();
        int temp = 0;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                temp = scanner.nextInt();
                maze[i][j] = ~temp;
                p[i][j] = false;
            }
        }
    }

    /*
     * 回溯迷宫，查看是否有出路
     */
    public void findPath(){
        // 给原始迷宫的周围家一圈围墙
        int temp[][] = new int[row + 2*step][col + 2*step];
        for(int i = 0; i < row + 2*step; ++i) {
            for(int j = 0; j < col + 2*step; ++j) {
                if((i<step)||(i>row+step-1)||(j<step)||(j>col+step-1))
                    temp[i][j] = 1;
            }
        }
        // 将原始迷宫复制到新的迷宫中
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                temp[i + step][j + step] = maze[i][j];
            }
        }
        // 从左上角开始按照顺时针开始查询

        int i = step;
        int j = step;
        p[i][j] = true;
        stack.push(new Position(i, j));
        while (!stack.empty() && (!(i == (row+step-1)) && (j == (col+step-1)))) {

            if ((temp[i][j + step] == 0) && (p[i][j + step] == false)) {
                p[i][j + step] = true;
                stack.push(new Position(i, j + step));
                j += step;
            } else if ((temp[i + step][j] == 0) && (p[i + step][j] == false)) {
                p[i + step][j] = true;
                stack.push(new Position(i + step, j));
                i += step;
            } else if ((temp[i][j - step] == 0) && (p[i][j - step] == false)) {
                p[i][j - step] = true;
                stack.push(new Position(i, j - step));
                j -= step;
            } else if ((temp[i - step][j] == 0) && (p[i - step][j] == false)) {
                p[i - step][j] = true;
                stack.push(new Position(i - step, j));
                i -= step;
            } else {
                stack.pop();
                if(stack.empty()){
                    break;
                }
                i = stack.peek().row;
                j = stack.peek().col;
            }

        }

        Stack<Position> newPos = new Stack<Position>();
        if (stack.empty()) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }

        /*
         * 图形化输出路径
         *

        String resault[][]=new String[row+1][col+1];
        for(int k=0;k<row;++k){
            for(int t=0;t<col;++t){
                resault[k][t]=(maze[k][t])+"";
            }
        }
        while (!newPos.empty()) {
            Position p1=newPos.pop();
            resault[p1.row-1][p1.col-1]="#";

        }

        for(int k=0;k<row;++k){
            for(int t=0;t<col;++t){
                System.out.print(resault[k][t]+"\t");
            }
            System.out.println();
        }*/
    }

    int maze[][];
    private int row = 9;
    private int col = 8;
    int step = 1;
    Stack<Position> stack;
    boolean p[][] = null;
}

class Hello{
    public static void main(String[] args){
        Maze demo = new Maze();
        demo.init();
        demo.findPath();
    }
}