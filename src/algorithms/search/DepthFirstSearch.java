package algorithms.search;

import java.util.*;

public class DepthFirstSearch extends ASearchingAlgorithm{
    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

    /**
     * solving the problem by depth first search algorithm
     * @param problem: the problem to solve
     * @return a solution
     */

    @Override
    public Solution solve(ISearchable problem) {
        if(problem==null)
            return null;
        Set<AState> visited=new HashSet<>();
        AState start=problem.initial();
        Stack<AState> queue=new Stack<>();

        queue.push(start);
        visited.add(start);

        while(!queue.isEmpty()){
            numOfEvaluated++;
            AState state = queue.pop();

            for (AState s : problem.getAllSuccessors(state)) {
                if (!visited.contains(s)) {
                    if (problem.TestGoal(s))
                        return buildSolution(s);
                    queue.push(s);
                    visited.add(s);
                }
            }
        }
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numOfEvaluated;
    }
}
