package DY;

public class Test {

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 34, 25, 12, 3, 8, 9, 10};

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + A[i];
        }
        System.out.println("총합은" + sum);

        double avg = 0.0;
        for(int i = 0 ; i < 10 ; i++){
            avg = (sum * 1.0) / A[i];
        }
        System.out.println("평균은" + avg);
    }
}