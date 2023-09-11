import java.util.Random;

 public class Java_Mini06 { //남수빈
    public static void main(String[] args) {
        int total = 10000;
        String[] names = {"이재명", "윤석열", "심상정", "안철수"};
        int[] votes = new int[names.length];

        for (int i = 1; i <= total; i++) {
            Random rand = new Random();
            int pick = rand.nextInt(names.length);
            votes[pick]++;

            System.out.printf("[투표 진행율]: %.2f%%, %d명 투표 => %s\n", (double) i / total * 100, i, names[pick]);
            for (int j = 0; j < names.length; j++) {
                double voteRate = (double) votes[j] / total * 100;
                System.out.printf("[기호:%d] %s: %05.2f%%, (투표수: %d)\n", j + 1, names[j], voteRate, votes[j]);
            }

            // 중복 당선 제거
            if (i == total) {
                int comp = votes[0];
                for (int k = 1; k < votes.length; k++) {
                    if (votes[k] > comp) {
                        comp = votes[k];
                    }
                }

                int same = 0;
                for (int k = 0; k < votes.length; k++) {
                    if (votes[k] == comp) {
                        same++;
                    }
                }
                if (same > 1) {
                    votes[pick]--;
                    i--;
                }
            }
        }

        int max = votes[0];
        int maxIndex = 0;
        for (int i = 1; i < votes.length; i++) {
            if (votes[i] > max) {
                max = votes[i];
                maxIndex = i;
            }
        }
        System.out.printf("[투표결과] 당선인: %s", names[maxIndex]);
    }
}
