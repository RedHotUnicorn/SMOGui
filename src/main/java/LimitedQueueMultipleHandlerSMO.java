/**
 * Created by Михаил on 16.06.2016.
 */
public class LimitedQueueMultipleHandlerSMO extends MultipleHandlerSMO {
    int queueLimit; //рамер буффера (очереди)
    double queueLength;

    public LimitedQueueMultipleHandlerSMO(double lambda, double mu,int chanelCount, int queueLimit) {
        super(lambda, mu, chanelCount);
        this.queueLimit = queueLimit;
        type=3;
        this.setQueueLength();
        this.calc();
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
        return getProb(channelCount + queueLimit);
    }


}
//
