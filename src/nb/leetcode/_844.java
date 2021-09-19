class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        int skipS=0;
        int skipT=0;
        while(i>=0||j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    i--;
                    skipS++;
                }else if(skipS>0){
                    i--;
                    skipS--;
                }else{
                    break;
                }
            }

            while(j>=0){
                if(t.charAt(j)=='#'){
                    j--;
                    skipT++;
                }else if(skipT>0){
                    j--;
                    skipT--;
                }else{
                    break;
                }
            }

            if(i>=0&&j>=0){
                if(s.charAt(i)==t.charAt(j)){
                    i--;
                    j--;
                }else{
                    return false;
                }
            }else{
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }

        }
        return true;
    }

}