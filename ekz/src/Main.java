import java.math.BigDecimal;
import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        int nMaxx = 11; //количество членов ряда x
        int nMaxy = 4; //количество членов ряда y

        double x = 1.0/5.0;
        double y = 1.0/239.0;

        //вычисление арктангенса
        Result arctanx = CalculateArctangens.arctangens(x, nMaxx);
        Result arctany = CalculateArctangens.arctangens(y, nMaxy);

        //ошибка разности
        double atanx16 = 16.0 * arctanx.sum;
        double atany4 = 4.0 * arctany.sum;
        double atanx16MinusAtany4 = atanx16 - atany4;

        double raznost_error = abs(atanx16MinusAtany4) * CalculateArctangens.U;

        double total_error = arctanx.abs_error * 16.0 + arctany.abs_error * 4.0 + raznost_error;
        System.out.println("total_error = " + total_error);

        double result = 4.0 * (4.0 * arctanx.sum - arctany.sum);
        System.out.println("result = " + result);

        // вычисление относительной ошибки
        double relativeMistake = abs(total_error / result);
        System.out.println("Относительная ошибка = " + BigDecimal.valueOf(relativeMistake).toPlainString());


//        System.out.println("Дробь x=" + x + ":");
//        System.out.println(Arrays.toString(arctanx.fraction));
//
//        System.out.println("Дробь y=" + y + ":");
//        System.out.println(Arrays.toString(arctany.fraction));
//
//        System.out.println("Сумма дроби x=" + x + ":");
//        System.out.println(Arrays.toString(arctanx.sumArray));
//
//        System.out.println("Сумма дроби y=" + y + ":");
//        System.out.println(Arrays.toString(arctany.sumArray));

    }
}
