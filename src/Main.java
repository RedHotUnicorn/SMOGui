/**
 * Created by Александр on 13.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        SMO m1 = new MSMO(1.0/3.0,1.0/5.0,2);
        SMO m2 = new OneSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m1.coutMv()+m2.coutMv());

        SMO m3 = new MSMO(0.8*1.0/3.0,1.0/5.0,2);
        SMO m4 = new OneSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m3.coutMv()+m4.coutMv());

        SMO m5 = new MSMO(1.0/3.0,1.0/5.0,3);
        SMO m6 = new OneSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m5.coutMv()+m6.coutMv());

    }
}
