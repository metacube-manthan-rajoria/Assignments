# This file Is only for planning and trying out rough ideas.

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

```
