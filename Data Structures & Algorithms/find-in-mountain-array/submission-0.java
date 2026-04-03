/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int low=0,high=mountainArr.length()-1;
        int peakIndex=findPeak(mountainArr);
        if(target==mountainArr.get(peakIndex))
            return peakIndex;
        // lets search in the left half
        int res=bsearch(target,mountainArr,low,peakIndex-1);
        if(res==-1)
            res=bsearch(target,mountainArr,peakIndex+1,high);
        return res;
    }
    public int bsearch(int target,MountainArray mountainArr,int low,int high){
        if(!(low<=high))
            return -1;
        int mid=low+(high-low)/2;
        int curr=mountainArr.get(mid);
        if(curr==target)
            return mid;
        boolean ir=increasingRight(mid,curr,mountainArr);
        if(target<curr){
            if(ir)
                high=mid-1;
            else
                low=mid+1;
        }
        else{
            if(ir)
                low=mid+1;
            else
                high=mid-1;
        }
        return bsearch(target,mountainArr,low,high);
    }
    public int findPeak(MountainArray mountainArr){
        int low=0,high=mountainArr.length()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int curr=mountainArr.get(mid);
            if(checkPeak(mid,mountainArr,curr)){
                return mid;
            }
            boolean ir=increasingRight(mid,curr,mountainArr);
            if(ir)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    // public int recursive(int target,int low,int high,MountainArray mountainArr){
    //     if(!(low<=high))
    //         return -1;
    //     int mid=low+(high-low)/2;
    //     int curr=mountainArr.get(mid);
    //     if(curr==target)
    //         return mid;
    //     else{
    //         boolean peak=checkPeak(mid,mountainArr,curr);
    //         if(peak){
    //             int res1=recursive(target,low,mid-1,mountainArr);
    //             if(res1==-1)
    //                 res1=recursive(target,mid+1,high,mountainArr);
    //             return res1;
    //         }
    //         else{
    //             boolean ir=increasingRight(mid,curr,mountainArr);
    //             if(target<curr){
    //                 if(ir)
    //                     high=mid-1;
    //             }
    //         }
    //     }
    // }
    public boolean checkPeak(int index,MountainArray mountainArr,int ele){
        if(index==0 || index==mountainArr.length()-1)
            return false;
        if(ele>mountainArr.get(index-1) && ele>mountainArr.get(index+1))
            return true;
        return false;
    }
    public boolean increasingRight(int index,int ele,MountainArray mountainArr){
        if(index==0)
            return true;
        if(index==mountainArr.length()-1)
            return false;
        if(ele>mountainArr.get(index-1))
            return true;
        return false;
    }
}