/**
 * Created by Александр on 13.03.2016.
 */
public class OneHandlerSMO extends SMO{

    OneHandlerSMO(double l, double m){
        super(l,m,1);
    }

    @Override
    double coutP0() {
        return 1-lamda/ro;
    }

    @Override
    double coutMv() {
        return 1/(mu-lamda);
    }

}