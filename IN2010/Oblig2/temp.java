public void setEarliestStart(int addTime){
        
    if(cntPredecessors > prevVertices){
        if(earliestStart < addTime){
            earliestStart = addTime;
        }
        prevVertices++;
    }
    
    if(cntPredecessors == prevVertices){
        for(Task t : outEdges){
            t.setEarliestStart(earliestStart + time);
        }
    }
}