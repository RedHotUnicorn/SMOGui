/**
 * Created by Александр on 13.03.2016.
 */
public class Chain {
    public static void main(String[] args) {
        SMO m1 = new MultipleHandlerSMO(1.0,2.0,2);
       // SMO m2 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);
        System.out.println(m1.getP0());

       /* System.out.println(m1.getMv()+m2.getMv());

        SMO m3 = new MultipleHandlerSMO(0.8*1.0/3.0,1.0/5.0,2);
        SMO m4 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m3.getMv()+m4.getMv());

        SMO m5 = new MultipleHandlerSMO(1.0/3.0,1.0/5.0,3);
        SMO m6 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m5.getMv()+m6.getMv());*/

    }
    public static SMO createOneHandlerSMO(double lambda, double mu){
        SMO smo = new OneHandlerSMO(lambda,mu);
        return smo;
    }

    public static SMO createMultipleHandlerSMO(int n, double lambda, double mu){
        SMO smo = new MultipleHandlerSMO(lambda,mu,n);
        return smo;
    }

    public static void viewAllInformation()
    {};
}
