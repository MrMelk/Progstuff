import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.PriorityQueue;

//Har jobbet sammen med Ada Mathea Stensrud Veddegjerde

class Oblig2 {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        Scanner in = new Scanner(new File(filename));

        int n = in.nextInt();
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i + 1);
        }

        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            Task task = tasks[id - 1];
            task.name = in.next();
            task.time = in.nextInt();
            task.staff = in.nextInt();

            while (true) {
                int dep = in.nextInt();
                if (dep == 0) {
                    break;
                }
                tasks[dep - 1].addEdge(task);
                tasks[id - 1].cntPredecessors++;
                tasks[id - 1].orgPredecessors = tasks[id - 1].cntPredecessors;
            }
        }
        realizable(tasks);
        optimalTime(tasks);
        printProject(tasks);
    }
    public static boolean realizable(Task[] taskList){
        ArrayList<Task> tSorted = topoSorter(taskList);
        if(tSorted.size() >= taskList.length){
            return true;
        }
        
        for(Task T : taskList){
            if(T.cntPredecessors > 0 && T.outEdges.size() > 0){
                DFS(T, T, "");
                System.exit(1);
            }
        }
        return false;
    }
    public static void DFS(Task start, Task vertex, String bolle){
        vertex.visited = true;
        bolle += vertex.name + " -> ";
        if(vertex.outEdges.contains(start)){
            System.out.println(bolle + start.name);
            return;
        }
        for(Task T: vertex.outEdges){
            if(!T.visited){
                DFS(start, T, bolle);
            }
        }
    }
    public static ArrayList<Task> topoSorter(Task[] taskList){
        Stack<Task> S = new Stack<>();
        ArrayList<Task> topoList = new ArrayList<>();
        for(Task t : taskList){
            if(t.cntPredecessors == 0){
                S.push(t);
                topoList.add(t);
            }
        }
        while(!S.empty()){
            Task u = S.pop();
            for(Task T : u.outEdges){
                T.cntPredecessors -= 1;
                if(T.cntPredecessors <= 0){
                    S.push(T);
                    topoList.add(T);
                }
            }
        }
        for(Task t : topoList){
            t.cntPredecessors = t.orgPredecessors;
        }
        return topoList;
    }


    public static void optimalTime(Task[] taskList){
        if(!realizable(taskList)){
            return;
        }

        ArrayList<Task> tSorted = topoSorter(taskList);
        
        
        for(Task T : tSorted){
            T.setEarliestStart(0);
        }
        setLatestStart(taskList);
        for(Task T : tSorted){
            T.slack = T.latestStart - T.earliestStart;
            if(T.slack == 0){
                T.critical = true;
            }
        }

    }
    public static void setLatestStart(Task[] taskList){
        int end = 0;
        ArrayList<Task> tL = topoSorter(taskList);
        for(Task t : taskList){
            if(end < t.earliestStart + t.time){
                end = t.earliestStart + t.time;
            }
            for(int i = tL.size()-1; i >= 0; i--){
                if(tL.get(i).outEdges.size() == 0){
                    tL.get(i).latestStart = end - tL.get(i).time;
                }
                else{
                    int late = tL.get(i).outEdges.get(0).latestStart;
                    for(int j = tL.get(i).outEdges.size() - 1; j >= 0; j--){
                        if(late > tL.get(i).outEdges.get(j).latestStart){
                            late = tL.get(i).outEdges.get(j).latestStart;
                        }
                    }
                    tL.get(i).latestStart = late - tL.get(i).time;
                    if(tL.get(i).latestStart < tL.get(i).earliestStart){
                        tL.get(i).latestStart = tL.get(i).earliestStart;
                    }
                }
            }
        }
    }
    public static void printProject(Task[] taskList){
        String fin = "Finished: ";
        String start = "Starting: ";
        String time = "Time: "; 
        String staff = "Current Staff: ";

        ArrayList<Task> topoList = topoSorter(taskList);
        
        PriorityQueue<Integer> timeQueue = new PriorityQueue<>();
        for(Task t : topoList){
            if(!timeQueue.contains(t.earliestStart)){
                timeQueue.add(t.earliestStart);
            }
            if(!timeQueue.contains((t.earliestStart + t.time))){
                timeQueue.add(t.earliestStart + t.time);
            }
        }
        
        int currentStaff = 0;
        while(!timeQueue.isEmpty()){
            System.out.println(time + timeQueue.peek() );
            
            for(Task t: topoList){
                
                if(t.earliestStart == timeQueue.peek()){
                    System.out.println(start + t.name);
                    currentStaff += t.staff;
                }
                if((t.earliestStart + t.time) == timeQueue.peek()){
                    System.out.println(fin + t.name);
                    currentStaff -= t.staff;
                }
                
            }
            System.out.println(staff + currentStaff);
            System.out.println("_________________________________");
            timeQueue.poll();
        }
        for(Task t : taskList){
            System.out.println("Id: " + t.id);
            System.out.println("Name: " + t.name);
            System.out.println("Time needed to finish task: " + t.time);
            System.out.println("Staff needed: " + t.staff);
            System.out.println("Earliest starting time: " + t.earliestStart);
            System.out.println("slack: " + t.slack);
            System.out.print("Ekstra tasks: ");
            for(Task e : t.outEdges){
                System.out.print(e.name + ", ");
            }
            System.out.println("");
        }
        

    }


}