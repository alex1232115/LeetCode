package YandexList;

import java.util.*;

public class FlattenNestedListIterator {
}

class NestedIterator implements Iterator<Integer> {
    private final Deque<Integer> flatList;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatList = new ArrayDeque<>();
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return flatList.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return flatList.size() > 0;
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger i: nestedList) {
            if (i.isInteger()) {
                flatList.add(i.getInteger());
            } else {
                dfs(i.getList());
            }
        }
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
