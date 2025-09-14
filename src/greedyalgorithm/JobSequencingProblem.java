// Problem: https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
class Solution {
    class Job{
        int deadline;
        int profit;
        
        public Job(int deadline,int profit){
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // TC - O(n) + O(n log n) + O(n*maxDeadline)
        // SC - O(n) + O(maxDeadline) + O(2) for returning answer
        
        // Idea: We will mark the jobs with maximum profit starting from 
        // the end deadline. For this first will create a new class Job 
        // that stores both deadline and profit. Create an array of jobs and sort 
        // it in descending order of their profits. Create an hash array that
        // keeps track of which slots are available for the job to execute. 
        // Iterate through the jobs and mark the slots from the end
        
        // Step 1: Create jobs array
        Job[] jobs = new Job[deadline.length];
        int maxDeadline = Integer.MIN_VALUE;
        
        // O(n)
        // Step 2: Create jobs objects and find the maximum deadline
        for(int i=0; i<deadline.length; i++){
            Job job = new Job(deadline[i],profit[i]);
            jobs[i] = job;
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        
        // O(n log n)
        // Step 3: Sort jobs by profit in descending order
        Arrays.sort(jobs,new Comparator<Job>() {
            @Override
            public int compare(Job j1, Job j2){
                return Integer.compare(j2.profit,j1.profit); // Sort by profit in descending order
            }
        });
        
        // Step 4: Initialize hash array to track available slots
        int[] hash = new int[maxDeadline + 1]; // +1 because deadlines are 1-based
        int maxProfit = 0;
        int maxJobs = 0;
        
        // O(n*maxDeadline)
        // Step 5: Assign jobs to available slots
        for(int i=0; i<jobs.length; i++){
            for(int j=jobs[i].deadline; j>0; j--){
                if(hash[j]==0){ // If slot is free
                    hash[j] = 1;  // Mark slot as taken
                    maxProfit+=jobs[i].profit; // Add profit
                    maxJobs++; // Increment number of jobs
                    break; // Stop once we find an available slot
                } 
            }
        }
        
        // Step 6: Return the result as an ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        result.add(maxJobs);     // Number of jobs scheduled
        result.add(maxProfit);   // Total profit

        return result;
    }
}