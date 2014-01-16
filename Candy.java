public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length < 2)
            return ratings.length;
        int result = ratings.length;
        int current = 0;
        int[] firstRound = new int[ratings.length];
        firstRound[0] = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                current++;
            else
                current = 0;
            firstRound[i] = current;
        }
        current = 0;
        result += firstRound[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                current++;
            } else {
                current = 0;
            }
            result += Math.max(firstRound[i], current);
        }
        return result;
    }
}
