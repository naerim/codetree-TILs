import java.util.*;

public class Main {

    public static int n, m;
    public static int arr[][];
    public static boolean visited[];

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];
        arr = new int[n+1][n+1];

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(1);

        int sum = 0;
        for(int i=1; i<=n; i++) {
            if(visited[i]) {
                sum++;
            }
        }

        System.out.print(sum-1);
    }

    public static void dfs(int vertex) {
        for(int i=1; i<=n; i++) {
            if(arr[vertex][i]==1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}