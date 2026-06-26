class Solution {
    public String minWindow(String s, String t) {
        //create a map(count) to store the character and its count of character in t
        //create a map (window)to store the character and its count of character in t
        //add every character in t to the map
        //set have(stores the total count of characters that are in both t and s),l=0;and
        //set res[]={-1,-1} and reslen=s.length() or Integer.max_value;
        //for every character starting from r=0 to r<s.length():
        //Add the current character and its count in the window;
        //if this chracter is in count and is required:
        //increment have
        //while have == need:(while window is valid):
        //check if current window length is less than reslen:
        //if yes then set reslen to r-l+1(curr window length),res[0] to l and res[1] to r
        //remove the leftmost character by reducing its count in the map 
        //check if this character is required and if its count is less than the required:
        //then decrement have
        //at the end of while loop increment l or shrink the window so that all the above window conditions are satisfied
        //return the length of the substring
        return s;
        
    }
}
