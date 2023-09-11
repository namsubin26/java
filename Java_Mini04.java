import java.util.InputMismatchException;
        import java.util.Random;
        import java.util.Scanner;

 public class Java_Mini04 { // 남수빈
    public static void main(String[] args) {
        System.out.println("[주민등록번호 계산]");
        Scanner sc = new Scanner(System.in);

        int year = 0;
        int month = 0;
        int day = 0;

        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        try {
            year = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return;
        }

        System.out.print("출생월을 입력해 주세요.(mm):");
        try {
            month = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return;
        }

        System.out.print("출생일을 입력해 주세요.(dd):");
        try {
            day = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return;
        }

        System.out.print("성별을 입력해 주세요.(m/f):");
        char sex = sc.next().charAt(0);
        if (sex != 'm' && sex != 'M' & sex != 'f' && sex != 'F') {
            System.out.println("올바르지 않은 값을 입력하셨습니다.");
            return;
        }

        StringBuilder answer = new StringBuilder();
        answer.append(String.format("%02d", year % 100));
        answer.append(String.format("%02d", month));
        answer.append(String.format("%02d", day));
        answer.append("-");

        if (year < 2000) {
            answer.append(sex == 'm' ? "1" : "2");
        } else {
            answer.append(sex == 'm' ? "3" : "4");
        }

        Random rand = new Random();
        int rNum = rand.nextInt(999999) + 1;
        answer.append(String.format("%06d", rNum));
        System.out.println(answer);
    }
}
