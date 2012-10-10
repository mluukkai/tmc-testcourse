
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        
        return sum;
    }
    
    public static int sum2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            for (int j = 0; j < n; j++) {
                sum++;                
            }
            sum -= n;

        }
        
        return sum;
    }    
}
