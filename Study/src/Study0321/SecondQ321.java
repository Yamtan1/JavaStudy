package Study0321;

public class SecondQ321 {

    public static void main(String[] args) {
        //배열을 복사해주는 함수
        //배열을 특정한 부부만 복사하는 함수
        int[] A = {12, 13, 167, 60, 50, 49, 123, 57, 246, 2, 10};
        int[] B = {1,2,3,4,5,6,7,8,9,10,11};
        int C = 3;
        int D = 7;
        fun2(A,B, C, D);
        for (int i = 0; i < A.length; i++) {
            System.out.print(B[i] + "\t");
        }
       /* for (int i = 0; i < A.length; i++) {
            System.out.print(B[i] + "\t");
        }
        System.out.println();
        fun(A, B);
        for (int i = 0; i < A.length; i++) {
            System.out.print(B[i] + "\t");

        } */
    }



    public static void fun(int[] a, int[] b) {
       for (int i = 0; i < a.length; i++) {
           b[i] = a[i];
       }
    }

    public static void fun2(int[] a, int[] b, int c, int d) {
        for(int i = c ; c <= d ; c++){
            b[c] = a[c];
        }
    }
}

