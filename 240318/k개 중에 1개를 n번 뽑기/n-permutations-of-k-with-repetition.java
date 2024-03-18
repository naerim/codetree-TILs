import java.util.*;

public class Main {
    public static int k, n;
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();
        
        dfs(1);
    }

    public static void dfs(int current){
        if(current == n+1) {
            for(int i=0; i<list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i<=k; i++) {
            list.add(i);
            dfs(current+1);
            list.remove(list.size()-1);
        }
    }
}