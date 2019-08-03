class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);
            if(a == '(' || a == '[' || a == '{'){
                list.addFirst(a);
            }else{
                if(list.size() == 0) return false;
                else if(a == '}' && list.pollFirst() != '{' || 
                       a == ')' && list.pollFirst() != '(' || 
                       a == ']' && list.pollFirst() != '['){
                    return false;
                }
            }
        }
        return list.size() == 0;
    }

   
    public boolean isValid2(String s) {
        Stack stack = new Stack();
        Map<Character,Character> map = new HashMap();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i = 0; i < s.length(); i++){
            char c =s.charAt(i);
            if(map.containsKey(c)){
                stack.push(s.charAt(i));
            }else{
                if(!stack.empty() && map.get((char)stack.peek()) == c){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }

}