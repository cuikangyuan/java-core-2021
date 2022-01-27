package algorithm.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.print.attribute.standard.PrinterInfo;

//AC 850 Dijkstra求最短路径 II
public class Client2 {

    private static final int N = 100010;
    private int n, m;

    private int[] h, e, ne, w;
    private int idx;

    private int[] dist;
    private boolean[] st;


    private class Pair {
        public int first;
        public int second;

        public Pair(int first,  int second) {
            this.first = first;
            this.second = second;
        }
    }


    public Client2() {
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        w = new int[N];

        dist = new int[N];
        st = new boolean[N];

        for(int i = 0; i < N; i++) {
            h[i] = -1;
            e[i] = -1;
            dist[i] = Integer.MAX_VALUE;
        }

    }

    private void add(int a, int b, int weight) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = weight;
        h[a] = idx++;

    }

    private void testDijkstra() {

        n = m = 3;
        add(1, 2, 1);
        
        //add(1, 2, 1);
        //add(1, 2, 3);

        add(2, 3, 1);
        add(1, 3, 4);


        int dis = dijkstra();
        System.out.println(dis);
    }

    private int dijkstra() {


        dist[1] = 0;
        Queue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>() {
        
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first - o2.first;
            }
        });
        queue.add(new Pair(0, 1));    

        while(!queue.isEmpty()) {
            Pair pair = queue.poll();

            //??? nowhere to set element in st array
            int ver = pair.second;
            int distance = pair.first;

            if(st[ver]) {
                System.out.println("drop ver = " + " distance = " + distance);
                continue;
            }        
            st[ver] = true;//same ver can be dropped!!

            for(int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];
                int t = distance + w[i] < 0 ? Integer.MAX_VALUE : distance + w[i];
                
                if(dist[j] > t) {
                    dist[j] = t;
                    queue.add(new Pair(dist[j], j));
                }
                
            }

        }

        if(dist[n] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dist[n];
        }
    }


    public static void main(String[] args) {
    
        Client2 client2 = new Client2();
        client2.testDijkstra();
    }
}
