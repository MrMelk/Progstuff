import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Task {
    //kanskje gjøre til private hvis ting fakker seg?
    int id, time, staff;
    String name;
    int earliestStart, latestStart, slack;
    ArrayList<Task> outEdges = new ArrayList<>();
    boolean critical = false;
    int cntPredecessors;
    int orgPredecessors;
    int prevVertices = 0;
    boolean visited = false;

    public void addEdge(Task tsk){
        outEdges.add(tsk);
    }

    public Task(int i){
        this.id = i;
    }

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
    @Override
    public String toString(){
        return name;//String.valueof(id)
    }
}
