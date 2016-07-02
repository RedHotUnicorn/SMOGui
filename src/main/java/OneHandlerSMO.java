/**
 * Created by Александр on 13.03.2016.
 */
public class OneHandlerSMO extends SMO {

    /**
     * Инициализирует поля {@link SMO#lamda} и {@link SMO#mu}
     */
    OneHandlerSMO(double lambda, double m) throws Exception {
        super(lambda,m,1);
        type=typesOfSMO.OneHandler;
        this.calculateCharacteristicOfSMO();
    }

    void setP0() {
        p0= 1-lamda/ro;
    }

    void setMv() {
        mv=1/(mu-lamda);
    }

    double getProbablyOfState(int stateNumber) {
        return Math.pow(ro, stateNumber)*p0;
    }

}
