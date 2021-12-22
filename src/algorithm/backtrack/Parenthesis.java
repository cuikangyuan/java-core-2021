package backtrack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Parenthesis {

    public List<String> generateParenthesis(int n) {

        LinkedList<String> result = new LinkedList();
        StringBuilder track = new StringBuilder();
        if (n > 0) {
            backtrack(n, n, track, result);
        }

        System.out.println(result);

        return result;
    }

    public void backtrack(int left, int right, StringBuilder track, LinkedList result) {
        if (left < 0 || right < 0) {
            return;
        }
        if (right < left) {
            return;
        }
        if (left == 0 && right == 0) {
            result.addLast(track.toString());
            return;
        }
        track.append("(");
        backtrack(left - 1, right, track, result);
        track.deleteCharAt(track.length() - 1);

        track.append(")");
        backtrack(left, right - 1, track, result);
        track.deleteCharAt(track.length() - 1);
    }
}
