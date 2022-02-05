class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        
        return Integer.max(kadane(a,n), reverseKadane(a,n));
    }
    static int kadane(int a[],int n){
        
        int max = 0;
        int x =  a[0];
        for(int i = 0; i < n; i++){
            max = Math.max(a[i],max+a[i]);
            x= Math.max(x,max);
        }
        return x;
    }

    static int reverseKadane(int a[],int n){
        int s=0;
        for(int i=0;i<n;i++)
        s+=a[i];
      for(int i=0;i<n;i++)
      a[i]=-a[i];
    
    int res=kadane(a,n);
    
    if(s==-res)
    return s;
    else
    return s+res;
    }
    }
    