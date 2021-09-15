import java.util.*
class Solution 
{ 
    fun solution(priorities: IntArray, location: Int): Int 
    { 
        var answer = 1
        var priorityQueue:Queue<Pair<Int,Int>> = LinkedList() 

        var sortedArray:Queue<Int> = LinkedList(priorities.sortedArrayDescending().toList()) 

        priorities.forEachIndexed{index, i -> 
            priorityQueue.offer(Pair(index,i))} 

        var end = false 

        while(!sortedArray.isEmpty()){ 
            var pivot = sortedArray.poll()
             
            for(i in 0..priorityQueue.size-1){ 
                if(priorityQueue.peek().second == pivot){ 
                    if(priorityQueue.peek().first == location){ 
                         end = true 
                         break 
                        } 
                        var temp = priorityQueue.poll() 
                        priorityQueue.add(temp) 
                        answer++ 
                        break 
                    } 
            else{ 
                var p = priorityQueue.poll() 
                priorityQueue.add(p) } 
            } 
            
            if(end) break
        } 
        return answer 
    } 
}

