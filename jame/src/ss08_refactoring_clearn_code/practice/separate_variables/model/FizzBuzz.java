package ss08_refactoring_clearn_code.practice.separate_variables.model;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isDevisible3 = number % 3 == 0;
        boolean isDevisible5 = number % 5 == 0;
        if (isDevisible3 && isDevisible5)
            return "FizzBuzz";

        if (isDevisible3)
            return "Fizz";

        if (isDevisible5)
            return "Buzz";

        return number + "";
    }
}
