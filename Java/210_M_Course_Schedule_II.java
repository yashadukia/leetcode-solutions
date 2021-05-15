class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
         
        // Make a map of pre_req -> list of courses
        for (int[] pre : prerequisites)
        {
            int course = pre[0]; // course to be taken
            int course_pre = pre[1]; // pre req of the above course
            
            List<Integer> lst = adjList.getOrDefault(course_pre, new ArrayList<>());
            lst.add(course);
            adjList.put(course_pre, lst);
            // Increase the indegree of the course
            indegree[course]++;
        }
        
        // System.out.println(adjList);
        
        Queue<Integer> q = new LinkedList<>();
        
        // Add to Queue all the courses with indegree = 0
        for (int i = 0; i < numCourses; i++)
        {
            if (indegree[i] == 0)
                q.offer(i);
        }
        
        int i = 0; // This is just a counter to put values into the res[]
        
        // Iterate until Queue is not empty
        while (!q.isEmpty())
        {
            // Remove from Queue and add the course to res
            int x = q.remove();
            res[i++] = x;
            
            // If the course_pre is in the adjList
            // Get its List of courses and decrement the indegree for them
            // Think like course+pre is taken and now we can take the other courses in the List.
            if (adjList.containsKey(x))
            {
                for (int k: adjList.get(x))
                {
                    indegree[k]--;
                    
                    // If the reduced indegree is 0, then add this course to Queue
                    if (indegree[k] == 0)
                        q.offer(k);
                }
            }
        }
        
        return i == numCourses ? res : new int[0];
        
    }
}