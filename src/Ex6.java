import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String equation = scanner.nextLine();
        if (checkEquation(equation)) {
            int a = aValue(equation);
            int b = bValue(equation);
            int c = cValue(equation);
            System.out.println("a: " + a + "b: " + b + "c: " + c);
            double[] solutionOfEquation = solution(a, b, c);
            System.out.println("X1= " + solutionOfEquation[0] + "X2= " + solutionOfEquation[1]);
        } else {
            System.out.println("Invalid equation.");
        }

    }

    public static boolean checkEquation(String equation) {
        if (!equation.contains("^2") || !equation.contains("=0"))
            return false;
        int index = equation.indexOf("=");
        equation = equation.substring(0, index);
        index = equation.indexOf("x^2");
        String a = equation.substring(0, index);
        if ((a.charAt(0) == '-' || a.charAt(0) == '+') && a.length() == 1)
            a = a + 1;
        equation = equation.substring(index + 3);
        index = equation.indexOf("x");
        String b = equation.substring(0, index);
        if ((a.charAt(0) == '-' || a.charAt(0) == '+') && b.length() == 1)
            b = b + 1;
        String c = equation.substring(index + 1);
        if ((a.charAt(0) == '-' || a.charAt(0) == '+') && c.length() == 1)
            c = c + 1;
        return true;
    }

    public static int aValue(String equation) {
        int aValue;
        if (equation.startsWith("-x")) {
            aValue=-1;
        } else if (equation.startsWith("x")) {
            aValue=1;
        } else {
            String a = equation.substring(0 ,equation.indexOf("^2") -1);
            aValue=Integer.parseInt(a);}
        return aValue;
        }
        public static int bValue (String equation) {
        int bValue;
        String b = equation.substring(equation.indexOf("^2")+2, equation.indexOf("x+"));
        if (b.startsWith("x"))
        {
            bValue=1;
        } else {
            bValue = Integer.parseInt(b);
        } return bValue;

        }
        public static int cValue (String equation) {
        int cValue;
        String b = equation.substring(equation.indexOf("^2")+2, equation.indexOf("x+"));
        String c = equation.substring(equation.indexOf(b)+3,equation.indexOf("="));
        if (c.contains("-")){
            cValue = Integer.parseInt(c) * -1;}
        else cValue = Integer.parseInt(c);
        return cValue;
        }
        public static double [] solution (int a, int b, int c) {
        double [] solution = new double[2];
        int sqrt = (b*b)-(4*a*c);
        int divider = 2*a;
        solution[0]=(-b+(Math.sqrt(sqrt))) /divider;
        solution[1]=(-b-(Math.sqrt(sqrt)))/divider;
        return solution;
        }
        }

