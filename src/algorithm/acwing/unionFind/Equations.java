package algorithm.acwing.unionFind;

public class Equations {

    public static void main(String[] args) {
//        String[] strings = {"a==b", "b!=c", "c==a"};
        String[] strings = {"c==c", "b==d", "x!=z"};
        Equations equations = new Equations();
        boolean b = equations.equationsPossible(strings);
        System.out.println(b);
    }

    public boolean equationsPossible(String[] equations) {

        if (equations.length == 0) {
            return false;
        }

        UnionFind unionFind = new UnionFind(26);

        //相等的字母形成连通
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                char x = str.charAt(0);
                char y = str.charAt(3);
                unionFind.union(x - 'a', y - 'a');
            }
        }

        //检查不等关系是否打破连通性
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                char x = str.charAt(0);
                char y = str.charAt(3);
                if (unionFind.connected(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }
}
