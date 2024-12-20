# Problem Statement
Design a class JobScheduler to simulate FCFS (First Come First Serve) scheduling algorithm. <br>
FCFS means the process which arrives first, gets executed first. 

Assume that we are receiving a number of processes with their arrival time and burst time seconds in a two dimensional array as input.  For example:

```
Arrival Time    Burst Time
[0   ]          [10 ]
[60  ]          [10 ]
[6   ]          [20 ]
[110 ]          [5  ]
```

Define methods to perform following operations: 
- Calculate completion time for each process. 
- Calculate waiting time for each process.
- Calculate turn around time for each process.
- Average waiting time of processes.
- Maximum waiting time period for a process in queue.

# Job Scheduler
```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Task implements Comparable<Task> {
    // Auto increments id at each new instance
    private static int idCounter = 0;

    private int taskID = 0;
    private int taskArrivalTime = 0;
    private int taskBurstTime = 0;
    private double taskCompletionTime = 0;
    private double taskWaitingTime = 0;
    private double taskTurnAroundTime = 0;

    public Task(int taskArrivalTime, int taskBurstTime) {
        this.taskArrivalTime = taskArrivalTime;
        this.taskBurstTime = taskBurstTime;
        this.taskID = idCounter++;
    }

    // Getters and Setters
    public int getTaskID() {
        return this.taskID;
    }
    public int getTaskArrivalTime() {
        return this.taskArrivalTime;
    }
    public int getTaskBurstTime() {
        return this.taskBurstTime;
    }
    public double getTaskCompletionTime(){
        return this.taskCompletionTime;
    }
    public double getTaskWaitingTime(){
        return this.taskWaitingTime;
    }
    public double getTaskTurnAroundTime(){
        return this.taskTurnAroundTime;
    }
    public void setTaskCompletionTime(double taskCompletionTime){
        this.taskCompletionTime = taskCompletionTime;
    }
    public void setTaskWaitingTime(double taskWaitingTime){
        this.taskWaitingTime = taskWaitingTime;
    }
    public void setTaskTurnAroundTime(double taskTurnAroundTime){
        this.taskTurnAroundTime = taskTurnAroundTime;
    }

    // CompareTo method for Collections.sort()
    @Override
    public int compareTo(Task other) {
        return taskArrivalTime - other.getTaskArrivalTime();
    }
}

class JobScheduler {
    ArrayList<Task> jobs;
    private double totalCompletionTime = 0;
    private double avgWaitingTime = 0;
    private double maxWaitingTime = 0;

    public JobScheduler(ArrayList<Task> jobs) {
        this.jobs = jobs;
        Collections.sort(jobs);
    }

    // Main Logic for Scheduler
    public void startScheduler(){
        for(Task task : jobs){
            totalCompletionTime += task.getTaskBurstTime();
            task.setTaskCompletionTime(totalCompletionTime);
            task.setTaskTurnAroundTime(task.getTaskCompletionTime() - task.getTaskArrivalTime());
            task.setTaskWaitingTime(task.getTaskTurnAroundTime() - task.getTaskBurstTime());
        }

        for(Task task: jobs){
            avgWaitingTime += task.getTaskWaitingTime();
            if(maxWaitingTime < task.getTaskWaitingTime()){
                maxWaitingTime = task.getTaskWaitingTime();
            }
        }
        avgWaitingTime = avgWaitingTime/jobs.size();

        printJobsDetailed();
    }

    // Print Tasks
    public void printJobs(){
        int len = this.jobs.size();
        for (int i = 0; i < len; i++) {
            System.out.println("Arrival Time : " + jobs.get(i).getTaskArrivalTime() + "\tBurst Time : " + jobs.get(i).getTaskBurstTime());
        }
    }
    public void printJobsDetailed(){
        int len = this.jobs.size();
        for (int i = 0; i < len; i++) {
            System.out.println(
                "ID : " + jobs.get(i).getTaskID() + "\t\t" +
                "AT : " + jobs.get(i).getTaskArrivalTime() + "\t\t" +
                "BT : " + jobs.get(i).getTaskBurstTime() + "\t\t" +
                "CT : " + jobs.get(i).getTaskCompletionTime() + "\t\t" +
                "TAT: " + jobs.get(i).getTaskTurnAroundTime() + "\t\t" +
                "TAT: " + jobs.get(i).getTaskWaitingTime()
            );
        }
        System.out.println(
            "Avg Waiting Time : " + avgWaitingTime + "\n" +
            "Max Waiting Time : " + maxWaitingTime
        );
    }

    // Getters for total_CT, avg_WT, max_WT
    private double getTotalCompletionTime(){
        return this.totalCompletionTime;
    }
    private double getAvgWaitingTime(){
        return this.avgWaitingTime;
    }
    private double getMaxWaitingTime(){
        return this.maxWaitingTime;
    }
}

class Assignment {
    public static void main(String[] args) {
        ArrayList<Task> jobs = new ArrayList<Task>();

        jobs.add(new Task(2, 2));
        jobs.add(new Task(5, 6));
        jobs.add(new Task(0, 4));
        jobs.add(new Task(0, 7));
        jobs.add(new Task(7, 4));

        JobScheduler js = new JobScheduler(jobs);
        js.startScheduler();
    }
}
```
