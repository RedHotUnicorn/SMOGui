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
    protected int type;     //Тип обработчика : Одноканальный, многоканальный, с буфером

    SMO(double lamda, double mu){
        this.lamda = lamda;
        this.mu=mu;
        this.ro=this.lamda/mu;

    }
    void calc(){
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

    abstract double getProb(int pNumber);

    public int fact(int num) {
        return (num == 0) ? 1 : num * fact(num - 1);
    }
}
