# Spring4总结
Spring一直贯彻并遵守"设计优于实现"，代码应该易于测试。这种思想表现在很多方面，比如说，Spring中
到处可见的interface，它使用接口来描述逻辑，以达到隔离代码，减少依赖性，解耦的目的。

Spring4主要包含以下几个问题：
![spring4总结](spring4总结.png)

AOP的八个要素：连接点(JoinPoint)、切点(pointCut)、增强(Advice)、目标对象(target)、引介(Introduction)、
织入(weaving)、代理(proxy)和切面(Aspect)
