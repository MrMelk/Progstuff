import java.util.ArrayList;
import java.lang.Math;

public class BalanceArray {
//start på midten, også gå mot midten flere ganger

    ArrayList<Integer> balance = new ArrayList<>();

    public void ph(ArrayList<Integer> lst){
        ArrayList<Integer> temp_low = new ArrayList<>();
        ArrayList<Integer> temp_high = new ArrayList<>();
        int n = lst.size();
        if(n == 0){
            return;
        }
        int i = Math.round((n)/2);
        int b = lst.get(i);
        balance.add(b);
        for(int j = i+1; j < n; j++){
            int h = lst.get(j);
            temp_high.add(h);
        }
        for(int j = 0; j < i; j++){
            int h = lst.get(j);
            temp_low.add(h);
        }
       
        ph(temp_high);
        ph(temp_low);
         
    }
    public static void main(String[] args) {
        ArrayList<Integer> arey = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            arey.add(i);
        }
        System.out.println(arey);
        BalanceArray test = new BalanceArray();
        test.ph(arey);
        System.out.println(test.balance);
    }

}
