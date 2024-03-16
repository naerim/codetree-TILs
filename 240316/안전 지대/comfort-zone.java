import java.util.*;

public class Main {

    public static int max,n,m,answer_k,count,answer_count;
    public static int[][] arr;
    public static boolean visited[][];
    public static int dx[] = new int[]{1,0,-1,0};
    public static int dy[] = new int[]{0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        max = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int num = sc.nextInt();
                arr[i][j] = num;
                max = Math.max(max, num);
            }
        }

        answer_k = 0;
        answer_count = 0;
        count = 0; //안전한 영역 갯수
        for(int k=1; k<=max; k++) {
            
            count = 0;
            visited = new boolean[n][m];
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(!visited[i][j] && arr[i][j]>k) {
                        count++;
                        dfs(i, j, k);
                    }
                }
            }

            if(answer_count < count) {
                answer_k = k;
                answer_count = count;
            }
        }

        System.out.print(answer_k + " " + answer_count);
    }

    public static void dfs(int x, int y, int k) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]>k && !visited[nx][ny]) {
                dfs(nx, ny, k);
            }
        }
    }
}