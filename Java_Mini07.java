import java.util.InputMismatchException;
        import java.util.Scanner;
        import java.util.TreeSet;

 public class Java_Mini07 { //남수빈
    public static void main(String[] args) {
        System.out.println("[로또 당첨 프로그램]\n");
        Scanner sc = new Scanner(System.in);

        int amount = 0;
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        try {
            amount = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return;
        }

        if (amount < 1 || amount > 10) {
            System.out.println("범위를 다시 한번 확인해주시길 바랍니다.");
            return;
        }

        // 로또 번호 자동
        int[][] rotto = new int[amount][6];
        for (int i = 0; i < amount; i++) {
            TreeSet<Integer> numbers = new TreeSet<>();

            // 로또 번호 랜덤 뽑기
            while (numbers.size() < 6) {
                int num = (int) (Math.random() * 45) + 1;
                numbers.add(num);
            }

            // 뽑은 로또 번호 넣기
            int idx = 0;
            for (int item : numbers) {
                rotto[i][idx++] = item;
            }

            // 뽑은 로또 번호 출력
            System.out.printf("%c\t%02d,%02d,%02d,%02d,%02d,%02d\n", i + 'A', rotto[i][0], rotto[i][1], rotto[i][2], rotto[i][3], rotto[i][4], rotto[i][5]);
        }

        // 당첨 로또 번호
        int[] lucky = new int[6];
        TreeSet<Integer> luckySet = new TreeSet<>();

        // 당첨 로또 번호 랜덤 뽑기
        while (luckySet.size() < 6) {
            int num = (int) (Math.random() * 45) + 1;
            luckySet.add(num);
        }

        // 당첨 로또 번호 넣기
        int idx = 0;
        for (int item : luckySet) {
            lucky[idx++] = item;
        }

        // 당첨 로또 번호 출력
        System.out.println();
        System.out.println("[로또 발표]");
        System.out.printf("\t%02d,%02d,%02d,%02d,%02d,%02d\n", lucky[0], lucky[1], lucky[2], lucky[3], lucky[4], lucky[5]);
        System.out.println();

        // 로또 결과
        System.out.println("[내 로또 결과]");
        for (int i = 0; i < rotto.length; i++) {
            int count = 0;
            for (int j = 0; j < 6; j++) {
                if (luckySet.contains(rotto[i][j])) {
                    count++;
                }
            }
            System.out.printf("%c\t%02d,%02d,%02d,%02d,%02d,%02d => %d개 일치\n", i + 'A', rotto[i][0], rotto[i][1], rotto[i][2], rotto[i][3], rotto[i][4], rotto[i][5], count);
        }
    }
}
