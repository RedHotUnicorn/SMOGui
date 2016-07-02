/**
 * Created by Михаил on 16.06.2016.
 */
public class LimitedQueueMultipleHandlerSMO extends MultipleHandlerSMO {
    int queueLimit;             //рамер буффера (очереди)
    double averageQueueLength;  //средняя длина очереди

    public LimitedQueueMultipleHandlerSMO(double lambda, double mu,int chanelCount, int queueLimit) throws Exception {
        super(lambda, mu, chanelCount);
        this.queueLimit = queueLimit;
        this.type=typesOfSMO.LimitedQueueMultipleHandler;
        this.setQueueLength();
        this.calculateCharacteristicOfSMO();
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
        mw = averageQueueLength / (lamda * (1 - getProbOfReject()));
        mx = 1 / mu;
        mv = mw + mx;
    }

    void setQueueLength() {
        averageQueueLength = 0;
        for (int i = 1; i <= queueLimit; i++) {
            averageQueueLength += getProbablyOfState(channelCount+i) * i;
        }
    }

    double getProbOfReject() {
        return getProbablyOfState(channelCount + queueLimit);
    }


}

