public class Main {
    public static String interpret(String command) {
        int i = 0;
        StringBuilder answ = new StringBuilder();
        while (i < command.length())
        {
            switch (command.charAt(i))
            {
                case 'G':
                {
                    answ.append("G");
                    i++;
                    break;
                }
                case '(':
                {
                    if (command.charAt(i + 1) == ')')
                    {
                        i += 2;
                        answ.append("o");
                    }
                    else
                    {
                        i += 4;
                        answ.append("al");
                    }
                }
            }
        }
        return answ.toString();
    }

    public static void main(String[] args) {
//        System.out.println("Goal\n" + interpret("G()(al)"));
//        System.out.println("Gooooal\n" + interpret("G()()()()(al)"));
        System.out.println("alGalooG\n" + interpret( "(al)G(al)()()G"));
    }
}