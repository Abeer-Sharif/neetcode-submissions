class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start=0;
        int end = s.length()-1;
        while( start < end){
            // while(start < end && ! s.charAt(start)){
            //     start++;
            // }
            // while (end > start && ! s.charAt(end)){
            //     end --;
            // }
            if(s.charAt(start)!= s.charAt(end)){
                return false;
            }
            start ++ ;
            end -- ;
        }
        return true;
    }
}
