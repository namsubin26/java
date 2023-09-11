import java.time.LocalDate;
        import java.util.InputMismatchException;
        import java.util.Scanner;

public class Java_Mini05 { // 남수빈
    public static void main(String[] args) {
        System.out.println("[달력 출력 프로그램]");
        Scanner sc = new Scanner(System.in);

        int year = 0;
        int month = 0;

        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        try {
            year = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return;
        }

        System.out.print("달력의 월을 입력해 주세요.(mm):");
        try {
            month = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력할 수 있습니다.");
            return;
        }

        System.out.printf("[%04d년 %02d월]\n", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        LocalDate date = LocalDate.of(year, month, 1);
        int firstDay = date.getDayOfWeek().getValue();
        int lastDay = date.lengthOfMonth();

        int day = firstDay % 7;
        System.out.println("\t".repeat(day));

        int count = day;
        for (int i = 1; i <= lastDay; i++) {
            System.out.printf("%02d\t", i);
            count++;

            if (count % 7 == 0) {
                System.out.println();
            }
        }
    }
}
