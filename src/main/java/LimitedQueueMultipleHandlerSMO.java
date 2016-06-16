/**
 * Created by Михаил on 16.06.2016.
 */
public class LimitedQueueMultipleHandlerSMO extends MultipleHandlerSMO {
    int queueLimit; //рамер буффера (очереди)
    double queueLength;

    public LimitedQueueMultipleHandlerSMO(double lambda, int mu, int queueLimit) {
        super(lambda, mu, 3);
        this.queueLimit = queueLimit;
        this.setQueueLength();
    }

    @Override
    void setP0() {
        double sum = getSumOfRoDivideToIFact();

        for (int i = 1; i <= queueLimit; i++) {
            sum += Math.pow(ro, channelCount + i) / (fact(channelCount) * Math.pow(channelCount, i));
        }

        p0= 1 / sum;
    }

    @Override
    void setMv() { // общее время обработки
        mw = queueLength/ (lamda * (1 - getProbOfReject()));
        mx = 1 / mu;
        mv = mw + mx;
    }

    void setQueueLength() {
        queueLength = 0;
        for (int i = 1; i <= queueLimit; i++) {
            queueLength += getProb(channelCount+i) * i;
        }
    }

    double getProbOfReject() {
        //return Math.pow(ro, channelCount + queueLimit) / (fact(channelCount) * Math.pow(channelCount, queueLimit)) * getP0();
        return getProb(channelCount + queueLimit);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            LimitedQueueMultipleHandlerSMO smo = new LimitedQueueMultipleHandlerSMO(250, 4 * 60, i);
            System.out.println(i);
            System.out.println("Mv = " + smo.getMv());
            System.out.println("QueueLength = " + smo.queueLength);
            System.out.println("P0 = " + smo.getP0());
            System.out.println("P fail = " + smo.getProbOfReject());
            System.out.println();
        }
    }
}
//
