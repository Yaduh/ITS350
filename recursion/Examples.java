package recursion;

public class Examples {

    static String parenthesis(String str, int n) {
        if (n <= 0) {
            return str;
        }
        return '(' + parenthesis(str, n - 1) + ')';
    }

    static long fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    void toH(int disk, char rodA, char rodB, char rodC) {
        if (disk == 1) {
            System.out.println("Move disk " + disk + " from rod " + rodA + " to rod " + rodC);
        } else {
            toH(disk - 1, rodA, rodC, rodB);
            System.out.println("Move disk " + disk + " from rod " + rodA + " to rod " + rodC);
            toH(disk - 1, rodB, rodA, rodC);
        }
    }

    public static void main(String args[]) {
        System.out.println(parenthesis("hi", -1)); // Expected output: "hi"
        System.out.println(parenthesis("hi", 3)); // Example to show the method working correctly, expected output: "(((hi)))"
        System.out.println(fact(10)); // Expected output: 3628800
        
        Examples ob = new Examples();
        ob.toH(3, 'A', 'B', 'C'); // Example with 3 disks for simplicity
    }
}
