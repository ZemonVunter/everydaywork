import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> array=new ArrayList<>();
        if(k>input.length){
            return array;
        }
        for(int i=0;i<input.length;i++){
            for(int j=0;j<input.length-i-1;j++){
                if(input[j]>input[j+1]){
                    int temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        for(int i=0;i<k;i++){
            array.add(input[i]);
        }
        return array;
    }
}