// 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
class Solution {
    public int minPartitions(String n) {
        int i =0;
        for(char c : n.toCharArray()){
            int x = c - '0';
            if(x > i){
                i = x;
            }
        }
        return i;
    }
}
