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

    public static int n, k;
    public static boolean visited[][];
    public static int map[][];
    public static int dx[] = new int[]{0,1,0,-1};
    public static int dy[] = new int[]{1,0,-1,0};
    public static Queue<Point> queue = new LinkedList();

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
    
        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            queue.add(new Point(x, y));
        }

        int sum = 0;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(!visited[p.x][p.y]) {
                visited[p.x][p.y] = true;
                sum += 1;

                for(int i=0; i<4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(nx>0 && nx<=n && ny>0 && ny<=n && map[nx][ny]==0 && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        System.out.print(sum);
    }
}