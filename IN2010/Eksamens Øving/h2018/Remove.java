class Remove{
    public Node removeLessThan(Node n, int value){
        if(n == null){
            return null;
        }
        if(value <= n.v){
        n.l = removeLessThan(n.l, value); //why?
        return n;//why?
        }
        if(value >= n.v){
            return removeLessThan(n.r, value);
        }
    
    }
}