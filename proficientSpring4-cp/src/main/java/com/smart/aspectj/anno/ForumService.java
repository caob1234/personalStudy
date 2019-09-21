package com.smart.aspectj.anno;

public class ForumService {
    private static String field="this is filed declaration";
    @NeedTest(isOrNo = true)
    public void deleteForum(int forumId){
        System.out.println("delete forum module: "+forumId);
    }

    @NeedTest(isOrNo = false)
    public void deleteTopic(int postId){
        System.out.println("delete forum topic: "+postId);
    }
}
