public class 4Sum {

    public boolean twoSum(int[] num, int pos, int target, int first, int second, ArrayList<ArrayList<Integer>> result) {
        boolean find = false;
        int left = pos;
        int right = num.length - 1;
        while (left < right) {
            if (num[left] + num[right] == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(first);
                list.add(second);
                list.add(num[left]);
                list.add(num[right]);
                result.add(list);
                left++;
                right--;
                find = true;
                while (left <= right && num[left] == num[left - 1])
                    left++;
                while (right >= left && num[right] == num[right + 1])
                    right--;
            } else if (num[left] + num[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<num.length-3; ++i){
            //remove duplicates
            if(i!=0 && num[i]==num[i-1])
                continue;
            for(int j=i+1; j<num.length-2; j++){
                //remove duplicates
                if(j!=i+1 && num[j]==num[j-1])
                    continue;
                twoSum(num, j+1,  target-(num[i]+num[j]), num[i], num[j], result);
            }
        }
        return result;
    }
}
