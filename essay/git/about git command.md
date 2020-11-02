##reset
reset Reset current HEAD to the special state.
git reset 可以将提交的内容重置。--mixed 是默认操作。 --soft 重置之后不会让本地的代码消失。 --hard 重置之后会让本地代码消失。
git reset --hard HEAD^^ 小角个数代表重置次数。执行reset操作之后，HEAD和远程仓库不一致，需要解决冲突才能push。
##rebase和merge
rebase和merge都是用来合并分支的命令。
rebase只是合并内容，不会合并提交历史。merge会把提交历史都合并。
##stash
stash将本地的变化缓存起来。stash pop将代码从缓存中弹出来。
可以有效利用该命令，合并远程代码。
##refusing to merge unrelated histories 
![QQ20190611-1@2x.png](https://upload-images.jianshu.io/upload_images/8196716-aa32cd52c4ed95ec.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
需要执行git pull origin master --allow-unrelated-histories将两个分支强行合并

有时候，git pull的时候提示失败，可以用git fetch之后，再git rebase

##更新代码
以下命令的效果，相当于fetch+rebase
git pull -r origin oa-cloud

没事的时候可以看看：https://www.cnblogs.com/qcloud1001/p/9796750.html

##存储密码，避免多次输入
You can use the [git-credential-store](https://git-scm.com/docs/git-credential-store) via

```
git config credential.helper store
```

which [stores your password unencrypted in the file system](https://git-scm.com/docs/git-credential-store)
