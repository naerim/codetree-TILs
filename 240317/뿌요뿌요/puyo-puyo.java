import java.util.*;

public class Main {

    public static int n, block, max_size, count;
    public static int arr[][];
    public static boolean visited[][];
    public static int dx[] = new int[]{1,0,-1,0};
    public static int dy[] = new int[]{0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        block = 0;
        max_size = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j]) continue;
                count = 0;
                dfs(i, j, arr[i][j]);
                if(count >= 4) {
                    block++;
                }
                max_size = Math.max(max_size, count);
            }
        }

        System.out.println(block + " " + max_size);
    }

    public static void dfs(int x, int y, int num) {
        visited[x][y] = true;
        count++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]==num && !visited[nx][ny]) {
                dfs(nx, ny, num);
            }
        }
    }
}