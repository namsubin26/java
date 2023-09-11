import java.util.InputMismatchException;
        import java.util.Scanner;

 public class Java_Mini08 { //남수빈
    static final int[][] TAX_TABLES = {
            {0, 0, 0},
            {12000000, 6, 0},
            {46000000, 15, 1080000},
            {88000000, 24, 5220000},
            {150000000, 35, 14900000},
            {300000000, 38, 19400000},
            {500000000, 40, 25400000},
            {1000000000, 42, 35400000},
            {1000000000, 45, 65400000}
    };

    public static int getInputMoney() {
        Scanner sc = new Scanner(System.in);

        int money = 0;
        System.out.print("연소득을 입력해 주세요.: ");
        try {
            money = sc.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
        if (money <= 0) {
            return 0;
        }
        return money;
    }

    public static int getTaxValue(int money) {
        int result = 0;
        for (int i = 0; i < TAX_TABLES.length; i++) {
            if (money > TAX_TABLES[i][0]) {
                result++;
            }
        }
        return result;
    }

    public static void printTotalTax(int money, int count) {
        int taxPrice = 0;
        int totalPrice = 0;
        int totalTax = 0;
        for (int i = 1; i <= count; i++) {
            if (i == count) {
                taxPrice = money - totalPrice;
            } else {
                taxPrice = TAX_TABLES[i][0] - TAX_TABLES[i - 1][0];
                totalPrice += taxPrice;
            }

            totalTax += taxPrice / 100 * TAX_TABLES[i][1];
            System.out.printf("%10d * %2d%% = %10d\n", taxPrice, TAX_TABLES[i][1], taxPrice / 100 * TAX_TABLES[i][1]);
        }

        System.out.println();
        System.out.printf("[세율에 의한 세금]:\t\t\t%10d\n", totalTax);
        if (count > 1) {
            System.out.printf("[누진공제 계산에 의한 세금]:\t%10d\n", money / 100 * TAX_TABLES[count][1] - TAX_TABLES[count][2]);
        }
    }

    public static void main(String[] args) {
        int money = getInputMoney();
        if (money == -1) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return;
        } else if (money == 0) {
            System.out.println("계산할 수 없는 값입니다.");
            return;
        }

        int count = getTaxValue(money) > 8 ? 8 : getTaxValue(money);
        printTotalTax(money, count);
    }
}
