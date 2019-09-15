package com.smart.aspectj.anno;

public class ForumService {
    private static String field="this is filed declaration";
    @NeedTest(value = true)
    public void deleteForum(int forumId){
        System.out.println("delete forum module: "+forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int postId){
        System.out.println("delete forum topic: "+postId);
    }
}
