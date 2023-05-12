import java.util.ArrayList;

public class Main {
    public String simplifyPath(String path) {
        ArrayList<String> stack = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < path.length())
        {
            start = end;
            if (path.charAt(end) == '.') {
                start = end;
                while (end < path.length() && path.charAt(end) == '.')
                    end++;
                if (end - start == 1 && (end < path.length() && path.charAt(end) == '/' || end == path.length())) {
                    if (!stack.isEmpty()) stack.remove(stack.size() - 1);
                }
                else if (end - start == 2 && (end < path.length() && path.charAt(end) == '/' || end == path.length())) {
                    stack.remove(stack.size() - 1);
                    if (!stack.isEmpty()) stack.remove(stack.size() - 1);
                }
                else
                {
                    while (end < path.length() && path.charAt(end) != '/')
                        end++;
                    stack.add(path.substring(start,end));
                }

            }
            else if (path.charAt(end) == '/')
            {
                if (stack.isEmpty() || !stack.get(stack.size() - 1).equals("/") && end != path.length() - 1)
                    stack.add(path.substring(start,end + 1));
                end++;
            }
            else
            {
                start = end;
                while (end < path.length() &&  path.charAt(end) != '/')
                    end++;
                if (start != end) stack.add(path.substring(start,end));
            }
        }
        if (stack.isEmpty()) return "/";
        else if (stack.size() > 1 && stack.get(stack.size() - 1).equals("/")) stack.remove(stack.size() - 1);
        StringBuilder srr = new StringBuilder();
        for (String d : stack)
            srr.append(d);
        return srr.toString();
//        return String.join("", stack);
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("/home\n" + ds.simplifyPath("/home/"));
        System.out.println("/\n" + ds.simplifyPath("/../"));
        System.out.println("/home/foo\n" + ds.simplifyPath("/home//foo/"));
        System.out.println("/c\n" + ds.simplifyPath("/a/./b/../../c/"));
        System.out.println("/...\n" + ds.simplifyPath("/..."));
        System.out.println("/..hidden\n" + ds.simplifyPath("/..hidden"));
        System.out.println("/home/foo/.ssh/authorized_keys\n" + ds.simplifyPath("/home/foo/.ssh/authorized_keys/"));
        System.out.println("/home/foo/.ssh2/authorized_keys\n" + ds.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));



    }

}
