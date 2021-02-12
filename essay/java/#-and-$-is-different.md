#1.# and $ in Spring setting file is different
@Value注解加载属性值得时候可以支持两种方式，如下代码所示：
```
@Component
public class Book {
    @Value("#{'${book.name}'}") //SpEL
    private String name;
    @Value("${book.author}") //PlaceHolder
    private String author;
    @Value("#{'${book.desc}'}")
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
```
PlaceHolder：占位符，格式为@Value("${book.author}")，{...}内为PlaceHolder，即直接在代码中替换。
SpEL：SpEL表达式，格式为@Value("#{'${book.name}'}")，{...}内为SpEL表达式，需要Spring提供的动态语言解析该值。
**参考**
(1)《Spring Cloud微服务实战 翟永超》——第2章 微服务构建——Page 22
(2) https://www.baeldung.com/spring-expression-language
(3) https://www.cnblogs.com/larryzeal/p/5910149.html