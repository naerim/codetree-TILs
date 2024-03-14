import java.util.*;

public class Main {

    public static int n,m;
    public static int answer;
    public static int arr[][];
    public static boolean visited[][];
    public static int dx[] = new int[]{0, 1};
    public static int dy[] = new int[]{1, 0};


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        answer = 0;
        visited[0][0] = true;
        dfs(0,0);

        System.out.print(answer);
    }

    public static void dfs(int x, int y) {
        if(x==n-1 && y==m-1) {
            answer = 1;
            return;
        }

        for(int i=0; i<2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<m&&arr[nx][ny]==1&&!visited[nx][ny]) {
                visited[x][y] = true;
                dfs(nx, ny);
            }
        }
    }
}