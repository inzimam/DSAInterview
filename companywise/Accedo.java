package companywise;

public class Accedo {
    public static void main(String[] args) {
        System.out.println(solution(670));
    }

    private static int solution(int N) {
        boolean isNegative = false;
        if (N < 0) {
            isNegative = true;
            N = -1 * N;
        }
        String str = N + "";
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= str.length(); i++) {
            str = str.substring(0, i) + "5" + str.substring(i);
            int val = Integer.parseInt(str);
            if (isNegative) {
                val = val * -1;
            }
            if (val > max) {
                max = val;
            }
            str = N + "";
        }
        return max;
    }
}
