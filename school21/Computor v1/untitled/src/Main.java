import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Polynomial polinom = new Polynomial();
//        Scanner in = new Scanner(System.in);
        if (Parse.doParse(args[1], polinom))
        {
            double[] answ = Roots.roots(polinom);
            switch (answ.length){
                case 0:
                {
                    System.out.println("The equation has no roots");
                    break;
                }
                case 1:
                {
                    System.out.println("The equation has one root.");
                    System.out.println("The solution is:\n" + answ[0]);
                    break;
                }
                case 2:
                {
                    System.out.println("Discriminant is strictly positive, the two solutions are:");
                    System.out.printf("root 1: %.5f, root 2: %.5f\n", answ[0], answ[1]);
                    break;
                }
                default:
                    System.out.println("The equation has an infinite number of solutions.");
            }
        }
        else
            System.out.println("Polynomial degree: 3+\n Third and more degree equation resolution is not required.");

    }
}

class Polynomial
{
    private double x0;
    private double x1;
    private double x2;

    public double getX0() {
        return x0;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }
}
class Parse{

    public static boolean twoParts(String enter, int enterPlus, Polynomial polynom)
    {
        int ind = 0;
        double tmpInt = 1;
        int plus;
        String[] arrEnter = enter.trim().split(" ");
        while (ind < arrEnter.length)
        {
            plus = enterPlus;
            tmpInt = plus;
            if (arrEnter[ind].charAt(0) == '-') {
                plus *= -1;
                tmpInt *= plus;
                ind++;
            }
            else if (arrEnter[ind].charAt(0) == '+') ind++;
//            StringBuilder num = new StringBuilder();
            if ((ind < arrEnter.length) && (Character.isDigit(arrEnter[ind].charAt(0))))
                tmpInt = Double.parseDouble(arrEnter[ind++]) * plus;
            if ((ind < arrEnter.length) && (arrEnter[ind].charAt(0) == '*' || (arrEnter[ind].charAt(0) == 'X')))
            {
                if (arrEnter[ind].charAt(0) != 'X') ind++;
                String del[] = arrEnter[ind].split("\\^");
                if (del.length > 1) {
                    switch (del[1]) {
                        case ("0"): {
                            polynom.setX0(polynom.getX0() + tmpInt);
                            break;
                        }
                        case ("1"): {
                            polynom.setX1(polynom.getX1() + tmpInt);
                            break;
                        }
                        case ("2"): {
                            polynom.setX2(polynom.getX2() + tmpInt);
                            break;
                        }
                        default: {
                            return false;
                        }
                    }
                }
                else
                    polynom.setX1(polynom.getX1() + tmpInt);
            }
            else {
                polynom.setX0(polynom.getX0() + tmpInt);
            }
            ind++;
        }
        return true;
    }
    public static boolean doParse(String enter, Polynomial polynom)
    {
        String[] strSplit = enter.trim().split("=");
        if (!twoParts(strSplit[0], 1, polynom))
            return false;
        return twoParts(strSplit[1], -1, polynom);
    }
}

class Roots{

    public static double[] roots(Polynomial polinom)
    {
        StringBuilder reduce = new StringBuilder();
        if (polinom.getX0() != 0) reduce.append(polinom.getX0()).append("X^0");
        if (polinom.getX1() != 0) reduce.append(polinom.getX1()).append("X^1");
        if (polinom.getX2() == 0) {
            reduce.append(" = 0\n");
            System.out.println("This is a linear equation, Polynomial degree: 1");
            System.out.println("Reduced form: " + reduce);
            return findRootsLinear(polinom);
        }
        else {
            reduce.append(polinom.getX2()).append("X^2").append(" = 0\n");
            System.out.println("This is a quadratic equation, Polynomial degree: 2");
            System.out.println("Reduced form: " + reduce);
            return findRootsSqere(polinom);
        }
    }
    public static double[] findRootsLinear(Polynomial polinom)
    {
        double[] answ;
        if (polinom.getX1() != 0)
        {
            answ = new double[1];
            answ[0] = (polinom.getX0() * -1) / polinom.getX1();
        }
        else if (polinom.getX1() == 0 && polinom.getX0() != 0)
            answ = new double[0];
        else
            answ = new double[3];
        return answ;
    }

    public static double[] findRootsSqere(Polynomial polinom)
    {
        double d = diskrim(polinom);
        double[] answ;
        if (d == 0)
        {
            answ = new double[1];
            answ[0] = (polinom.getX1() * - 1) / (2 * polinom.getX2());
        } else if (d > 0) {
            answ = new double[2];
            answ[0] = ((polinom.getX1() * - 1) + Math.sqrt(d)) / (2 * polinom.getX2());
            answ[1] = ((polinom.getX1() * - 1) - Math.sqrt(d)) / (2 * polinom.getX2());
        }
        else
            answ = new double[0];
        return answ;
    }


    public static double diskrim(Polynomial polinom)
    {
        return Math.pow(polinom.getX1(), 2) - 4 * polinom.getX2() * polinom.getX0();
    }
}