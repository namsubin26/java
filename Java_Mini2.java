
import java.util.InputMismatchException;
        import java.util.Scanner;

public class Java_Mini2 {
    public static void main(String[] args) {
        System.out.println("[캐시백 계산]");
        Scanner sc = new Scanner(System.in);

        int price = 12000;
        System.out.print("결제 금액을 입력해 주세요.(금액):" + price);

        System.out.println(" ");

        int cashback = price / 1000 >= 3 ? 300 : price / 1000 * 100;
        System.out.printf("결제 금액은 " + price + " 원이고, 캐시백은 " + cashback + "원 입니다.", price, cashback);
    }
}