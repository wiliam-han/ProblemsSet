import java.util.*;
public class problem3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] strs;
        String str;
        str = scanner.nextLine();
        strs = str.split(",");
        int Num = Integer.parseInt(strs[1]);
        char[] cha = strs[0].toCharArray();
        int groupNum = 0;
        for(int i=0;i< cha.length;i++)
        {
            if(cha.length>(i*(2*Num-3))&&(cha.length<((i+1)*(2*Num-3))))
            {
                groupNum = i + 1;
                break;
            }
        }
        int index = 0;
        for(int i=1;i<(2*Num-2);i++)
        {
            for(int j=0;j<groupNum;j++)
            {
                if((i<=((Num+1)/2)&&(i%2!=0))||((i>((Num+1)/2)&&(i%2==0))))
                {
                    index = i%2==0 ? i/2 -1 :(i+1)/2 - 1;
                }
                else
                {
                    index = (2*Num-1)-i;
                }
                if(cha.length>j*(2*Num-3)+index)
                {
                    System.out.print(cha[j*(2*Num-3)+index]);//11=1,14=4,22=7
                }
            }
        }
        System.out.println('\n');
    }
}
