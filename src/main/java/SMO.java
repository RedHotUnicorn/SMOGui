import com.sun.javaws.exceptions.InvalidArgumentException;

import java.security.InvalidParameterException;

/**
 * Created by Александр on 13.03.2016.
 */
public abstract class SMO {
    protected double lamda;  //Интенсивность входного потока
    protected double mu;    //Иненсивность обработки
    protected double ro;    //Отношение интенсивностей
    protected double mv;    //Время реакции системы
    protected double mx;    //Время обработки
    protected double mw;    //Время в очереди
    protected double p0;   //Вероятность начального состояния

    enum typesOfSMO {OneHandler,MultipleHandler,LimitedQueueMultipleHandler} //Тип обработчика : Одноканальный, многоканальный, с буфером
    protected typesOfSMO type;

    /**
     *
     * @param lamda Интенсивность входного потока
     *
     * @param mu Интенсивность обработчика
     */

    SMO(double lamda, double mu, int numOfProccess) throws Exception{
        this.lamda = lamda;
        this.mu=mu;
        this.ro=this.lamda/(mu*numOfProccess);

            if (ro > 1) throw new Exception() ;



    }

    void calculateCharacteristicOfSMO(){
        this.setP0();
        this.setMv();
    }

    double getP0() {
        return p0;
    }
    abstract void setP0();

    double getMv() {
        return mv;
    }
    abstract void setMv();


    /**
     * @param stateNumber Номер состояния в схеме гибели и размножения
     *
     * @return Вкроятность нахождения системы в этом состоянии
     */
    abstract double getProbablyOfState(int stateNumber);

    public int fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }
}
