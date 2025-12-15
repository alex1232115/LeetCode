package YandexList;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String i: split) {
            switch (i) {
                case ".." -> {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                }
                case ".", "" -> {}
                default -> stack.push(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String str: stack) {
            result.append("/").append(str);
        }
        return result.isEmpty() ? "/" : result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("///home////user/Documents/../Pictures"));
        System.out.println(simplifyPath.simplifyPath("/../"));
        System.out.println(simplifyPath.simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(simplifyPath.simplifyPath("/a/../../b/../c//.//"));
    }
}
