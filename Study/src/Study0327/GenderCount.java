package Study0327;

import vo.Person0327;

public class GenderCount {

    public static void gendercnt(Person0327[] x){
        int manCount=0;
        int womanCount=0;
        for(int i = 0; i < x.length ; i++){

            if(x[i].getGender()=='m'){
                manCount++;
            }
            else{
                womanCount++;
            }
        }
        System.out.println("남자 : " + manCount + ", 여자 : " + womanCount );
    }
}
