import java.util.*;

public class Main {
    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int n, m;
    public static boolean visited[][];
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static Queue<Point> queue = new LinkedList();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n][m];
        int arr[][] = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        push(0, 0);
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && arr[nx][ny]==1 && !visited[nx][ny]) {
                    push(nx, ny);
                }
            }
        }

        if(visited[n-1][m-1]) {
            System.out.print(1);
        } else System.out.print(0);
    }

    public static void push(int x, int y) {
        Point p = new Point(x, y);
        visited[x][y] = true;
        queue.add(p);
    }
}