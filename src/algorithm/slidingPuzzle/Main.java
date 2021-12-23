package algorithm.slidingPuzzle;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        int i = new Main().slidingPuzzle();
        System.out.println(i);
    }


    private static String replaceIndex(int index,String res,String str){
        return res.substring(0, index)+str+res.substring(index+1);
    }

    public int slidingPuzzle() {
        int row = 2;
        int column = 3;
        //412503 return step 5
        //123504 return step -1
        String start = "412503";
        String target = "123450";

        List<List<Integer>> neighbor = Arrays.asList(
                Arrays.asList(3, 1),
                Arrays.asList(4, 0, 2),
                Arrays.asList(5, 1),
                Arrays.asList(0, 4),
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 4)
        );

        //BFS start
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.add(start);
        visited.add(start);

        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                //whether reach the target
                if (target.equals(cur)) {
                    return step;
                }

                //find the index of number zero
                int idx = 0;
                for (; !"0".equals(String.valueOf(cur.charAt(idx))); idx++) ;

                //switch zero 0 with other number in neighbor
                List<Integer> neighbors = neighbor.get(idx);
                for (Integer integer : neighbors) {
                    String newBoard = new String(cur);
                    String substring = String.valueOf(newBoard.charAt(integer));
                    newBoard = replaceIndex(integer, newBoard, "0");
                    newBoard = replaceIndex(idx, newBoard, substring);

                    if (!visited.contains(newBoard)) {
                        q.add(newBoard);
                        visited.add(newBoard);
                    }

                }
            }

            step++;
        }

        return -1;
    }
    //BFS end

}
