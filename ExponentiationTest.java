class ExponentiationTest {

public static void main(String[] args) {
// TODO Auto-generated method stub
double a = 2, b = -10; //
double pow = powerWithRecurSquaring(a, b);
if (b < 0) {
pow = 1 / pow;
}
System.out.println(a + ” to the power of  ” + b + ” = ” + pow);
}

// a power b, runs in ~ O(2 log b) time
public static double powerWithRecurSquaring(double a, double b) {
if (b < 0) {
b = -b; //   b = Math.abs(b);
} else if (b == 0) {
return 1;
} else if (b == 1) {
return a;
} else if (b == 2) {
return a * a;
} else if (b % 2 == 0) {
return powerWithRecurSquaring(powerWithRecurSquaring(a, b / 2), 2);
}
return powerWithRecurSquaring(a, b – 1) * a;
}

}
