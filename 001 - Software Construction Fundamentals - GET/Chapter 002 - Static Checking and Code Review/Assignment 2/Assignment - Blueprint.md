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



```Old Snippets
Collections.sort(this.jobs, new Comparator<Task>() {
    public int compare(Task t1, Task t2) {
        return t1.getTaskArrivalTime() > t2.getTaskArrivalTime() ? 1 : -1;
    }
});

Collections.sort(jobs, new Comparator<Task>() {
    public int compare(Task left, Task right)  {
        return left.getTaskID() - right.getTaskID(); // The order depends on the direction of sorting.
    }
});
this.jobs.sort((obj1, obj2)->(obj1.getTaskID() > obj2.getTaskID())?1:-1);




//final int len = 4;
Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            System.out.print("Arrival Time : ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time : ");
            int burstTime = scanner.nextInt();
            System.out.println();

            Task task = new Task(arrivalTime, burstTime);
            jobs.add(task);
        }
        scanner.close();