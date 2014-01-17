public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] n1 = new int[num1.length()];
        for (int i = 0; i < n1.length; i++) {
            n1[i] = num1.charAt(n1.length - 1 - i) - '0';
        }
        int[] n2 = new int[num2.length()];
        for (int i = 0; i < n2.length; i++) {
            n2[i] = num2.charAt(n2.length - 1- i) - '0';
        }
        int[] result = new int[n1.length + n2.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            for (int len = 0; len <= i; len++) {
                if (len < n1.length && i - len < n2.length) {
                    sum += n1[len] * n2[i - len];
                }
            }
            result[i] = sum % 10;
            sum /= 10;
        }
        return Helper(result);
    }

    public String Helper(int[] resultArray) {
        StringBuilder result = new StringBuilder();
        int index = resultArray.length - 1;
        while (index >= 0 && resultArray[index] == 0)
            index--;
        while (index >= 0) {
            result.append((char)(resultArray[index--] + '0'));
        }
        if (result.length() == 0)
            return "0";
        return result.toString();
    }
}
