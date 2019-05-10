package cn.dubby.algorithm.lintcode;

/**
 * @author dubby
 * @date 2019/5/10 10:04
 */
public class ABProblem {

    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        int r1 = a ^ b;
        int r2 = (a & b) << 1;

        int and = r1 & r2;
        //需要进位
        while (and != 0 && and != (1 << 31)) {
            r1 = (r1 | r2) ^ and;
            r2 = and << 1;
            and = r1 & r2;
        }
        r1 = r1 | r2;
        if (r1 == -2147483648) {
            return 0;
        }
        return r1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 31);
        ABProblem abProblem = new ABProblem();
        System.out.println(abProblem.aplusb(100, -100));
    }

}
