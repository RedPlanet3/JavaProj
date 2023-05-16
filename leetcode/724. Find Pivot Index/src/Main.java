class Main {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int sum2=0,req=-1;
        int i=0;
        while(i<nums.length)
        {
            sum2 = 0;
            sum = 0;
            for(int j=0;j<=i;j++)
            {
                if(j==i)
                {
                    continue;
                }
                else
                    sum=sum+nums[j];
            }
            for(int k=nums.length-1;k>=i;k--)
            {
                if(k==i)
                    continue;
                else
                    sum2=sum2+nums[k];
            }
            if(sum2==sum) {
                req = i;
                break;
            }
            i++;
        }
        return req;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("3: " + ds.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println("-1: " + ds.pivotIndex(new int[]{1,2,3}));
        System.out.println("0: " + ds.pivotIndex(new int[]{2,1,-1}));
    }
}