import java.util.ArrayList;

/**
 * Created by Александр on 13.03.2016.
 */
public class QueueOfSMOs {

    ArrayList<SMO> queue = new ArrayList<SMO>();

    public void addOneHandlerSMO(double lambda, double mu){
        SMO smo = new OneHandlerSMO(lambda,mu);
        queue.add(smo);
    }

    public void addMultipleHandlerSMO(int chanelCount, double lambda, double mu){
        SMO smo = new MultipleHandlerSMO(lambda,mu,chanelCount);
        queue.add(smo);
    }

    public void addLimitedQueueMultipleHandlerSMO(int chanelCount, double lambda, double mu,int queueLimit){
        SMO smo = new LimitedQueueMultipleHandlerSMO(lambda,mu,chanelCount,queueLimit);
        queue.add(smo);
    }

    public void calculationIndicators(){
        double sum=0;
        for (int i = 0; i <queue.size() ; i++) {
            sum+=queue.get(i).getMv();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        SMO m1 = new MultipleHandlerSMO(1.0,2.0,2);
        SMO m2 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);
        System.out.println(m1.getP0());

        System.out.println(m1.getMv()+m2.getMv());

        SMO m3 = new MultipleHandlerSMO(0.8*1.0/3.0,1.0/5.0,2);
        SMO m4 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m3.getMv()+m4.getMv());

        SMO m5 = new MultipleHandlerSMO(1.0/3.0,1.0/5.0,3);
        SMO m6 = new OneHandlerSMO(0.8*1.0/3.0,1.0/2.5);

        System.out.println(m5.getMv()+m6.getMv());

    }

}
