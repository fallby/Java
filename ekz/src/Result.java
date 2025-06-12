//класс Result для дальнейшего удобного вывода результата работы функции arctangens
public class Result {
    public double sum;
    public double[] fraction;
    public double[] sumArray;
    public double predstavleniya_error;
    public double obryv_ryada_error;
    public double okryglenie_error;
    public double sum_error;
    public double abs_error;

    public Result(double sum, double[] fraction, double[] sumArray, double predstavleniya_error, double obryv_ryada_error, double okryglenie_error, double sum_error, double abs_error) {
        this.sum = sum;
        this.fraction = fraction;
        this.sumArray = sumArray;
        this.predstavleniya_error = predstavleniya_error;
        this.obryv_ryada_error = obryv_ryada_error;
        this.okryglenie_error = okryglenie_error;
        this.sum_error = sum_error;
        this.abs_error = abs_error;
    }
}
