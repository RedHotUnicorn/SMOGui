/**
 * Created by Александр on 13.03.2016.
 */
public class OneHandlerSMO extends SMO {

    OneHandlerSMO(double lambda, double m){
        super(lambda,m);type=1;
        this.calc();
    }

    void setP0() {
        p0= 1-lamda/ro;
    }

    void setMv() {
        mv=1/(mu-lamda);
    }

    double getProb(int pNumber) {
        return Math.pow(ro,pNumber)*p0;
    }

}
