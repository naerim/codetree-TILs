import java.util.*;

public class Main {
    public static int n, count;
    public static int arr[][];
    public static boolean visited[][];
    public static int dx[] = new int[]{1,0,-1,0};
    public static int dy[] = new int[]{0,1,0,-1};
    public static List<Integer> list = new ArrayList<Integer>();

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

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                count = 0;
                dfs(i, j);
                if(count > 0) {
                    list.add(count);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int x, int y) {
        if(arr[x][y]== 0 || visited[x][y]) return;

        visited[x][y] = true;
        count++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]==1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}