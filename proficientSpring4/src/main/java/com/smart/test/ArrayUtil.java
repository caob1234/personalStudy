package com.smart.test;

public class ArrayUtil {

    /**
     * 第一题方法
     *
     * @param dist
     * @param search
     * @return
     * @throws Exception
     */
    public int findStartIndex(int[] dist, int[] search) throws Exception {
        int index = -1;
        int length = 0;
        for (int j = 0; j < dist.length; j++) {
            if (search[0] == dist[j]) {
                for (int i = 0; i < search.length; i++) {
                    if ((j + i) < dist.length && search[i] == dist[j + i]) {
                        length++;
                    } else {
                        break;
                    }
                }
                if (length == search.length) {
                    index = j;
//                    System.out.println("start point:" + j);
                    break;
                } else {
//                    System.out.println("--------:" + "-1");
                    length = 0;
                    continue;
                }

            } else {
                continue;
            }
        }
        return index;
    }

    /**
     * 第二题方法
     *
     * @param search
     * @param dist
     * @return
     * @throws Exception
     */
    public int indexOf(int[] search, int[] dist) throws Exception {
        int rootIndex = this.findIndexByValue(search[0], 0, dist);
        ChildNode childNode = new ChildNode(rootIndex);
        this.visitTree(rootIndex, search[1], search, dist, childNode);
        return this.number;
    }

    public int findIndexByValue(int value, int startIndex, int[] dist) {
        int index = -1;
        if (startIndex == dist.length || startIndex > dist.length) {
            return index;
        }
        for (int i = startIndex + 1; i < dist.length; i++) {
            if (value == dist[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int NumberOfValue(int startIndex, int lastIndex, int value, int[] dist) {
        int number = 0;
        for (int i = startIndex; i < lastIndex + 1; i++) {
            if (value == dist[i]) {
                number++;
            }
        }
        return number;
    }

    /**
     * Recursively traverse the child nodes of tree
     *
     * @param rootIndex   root node index of dist array
     * @param searchValue A value of search array
     * @param search      search array
     * @param dist        dist array
     * @param childNode   Tree node for recursively traverse
     */
    public void visitTree(int rootIndex, int searchValue, int[] search, int[] dist, ChildNode childNode) {
        int nextIndex = findIndexByValue(searchValue, rootIndex, dist);
        while (nextIndex != -1) {
            ChildNode nextChildNode = new ChildNode(nextIndex);
            int nextValue = getNextValue(searchValue, search);
            childNode.childNodes.add(nextChildNode);
            if (nextValue != -1) {
                visitTree(nextIndex, nextValue, search, dist, nextChildNode);
                nextIndex = findIndexByValue(dist[nextChildNode.data], nextChildNode.data, dist);
            } else {
                number++;
                int index = findIndexByValue(searchValue, nextChildNode.data, dist);
                while (index != -1) {
                    number++;
                    childNode.childNodes.add(new ChildNode(index));
                    index = findIndexByValue(searchValue, index, dist);
                }
                break;
            }
        }
    }

    public int number = 0;

    /**
     * Get next value of search array via searchValue
     *
     * @param searchValue
     * @param search
     * @return
     */
    private int getNextValue(int searchValue, int[] search) {
        int nextValue = -1;
        for (int i = 0; i < search.length; i++) {
            if (searchValue == search[i] && (i + 1) < search.length) {
                nextValue = search[i + 1];
                break;
            }
        }
        return nextValue;
    }
}
