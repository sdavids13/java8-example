import java.util.List;

public interface MathExample {

    /**
     * @return Sum all int values together
     */
    int sum(int... intsToSum);

    /**
     * @return calculates baseNumber!
     */
    int factorial(int baseNumber);

    /**
     * @return List of all primes up to the given maxPrime
     */
    List<Integer> gatherPrimes(int maxPrime);

    /**
     * @return Average all int values
     */
    double average(int... intsToAverage);

    default boolean isPrime(int n) {
        for (int i = 2; 2 * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
