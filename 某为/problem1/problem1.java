import java.util.Scanner;

public class problem1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String strs;
        strs = scanner.nextLine();
        String[] cash = strs.split(",");
        int fiveNum = 0, tenNum = 0,i = 0;
        for(i=0;i<cash.length;i++)
        {
            if(cash[i].equals("5")){
                fiveNum++;
            }
            if(cash[i].equals("10")){
                tenNum++;
                fiveNum--;
            }
            if(cash[i].equals("20")){
                if(tenNum>0){
                    tenNum--;
                    fiveNum--;
                }else{
                    fiveNum-=3;
                }
            }
            if(fiveNum<0){
                System.out.println("false,"+(i+1));
                break;
            }
        }
        if(i==cash.length){
            System.out.println("true,"+i);
        }
    }
}
