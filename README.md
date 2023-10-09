# NJUSE-Server-side-development
这是NJUSE2023年服务端开发课程作业仓库

今年的服务端开发也比较硬核，和往年的作业有所不同。如果发现有任何问题欢迎向我提问，联系方式：qq1375900657

第一次的作业比较简单，只需要用老师给你的代码跑一遍就行，跟着ppt做就好。

第二次的作业是依赖注入，主要介绍了三种依赖注入方法：自动注入，javaconfig，xml方式。我这里选择的是自动注入方式，其中contactRepositoryImpl，contactServiceImpl，contactConfig是我完成的的类，两个impl分别实现各自的接口构成组件，config作为入口对组件进行组装。

第三次作业是AOP，被自己环境配置坑的挺惨（，写aop相关代码的时候发现无法import  aop的包，得现在pom.xml中添加：<dependency>    <groupId>org.springframework.boot</groupId>    <artifactId>spring-boot-starter-aop</artifactId>    <version>2.5.4</version></dependency><!-- AspectJ依赖 --><dependency><groupId>org.aspectj</groupId><artifactId>aspectjrt</artifactId><version>1.9.7</version> <!-- 使用适当的版本 --></dependency><dependency>    <groupId>org.aspectj</groupId>    <artifactId>aspectjweaver</artifactId>    <version>1.9.19</version></dependency>

mvn clear install重新安装依赖才不爆红。

这次作业我的想法是让ContactConfig不能注入aop而ContactConfigAOP能注入aop，这样只有aop相关测试才会调用aop功能。这一步我选择了ContactConfig用@Bean方式注入，而ContactConfigAOP使用@ComponentScan方式注入，@Bean有较高自主性。

我的aop实现主要是在初始化的时候就构建固定数据缓存，并且获取当前测试的contactservice，在执行到cutpoint前把数据写入contactService缓存，getAll判断缓存不为空则返回缓存里的数据，否则（第一次作业测试）就返回数据库里的数据。然后还得把contactService的缓存设为空，否则影响接下来的测试。



第四次作业：导入validation相关包爆红：在pom.xm;添加相关依赖然后重新引入。

<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.0.0.Final</version>
</dependency>

生成html页面的过程叫渲染

contactForm.html只需要照ppt上的写就行，新增contactController、contactApplication



第五次作业使用h2进行数据持久化。

添加application.yml里的对数据库的设置

并且添加jpa使用h2数据库的依赖

<!-- Spring Data JPA --><dependency>    <groupId>org.springframework.boot</groupId>    <artifactId>spring-boot-starter-data-jpa</artifactId></dependency><!-- H2 Database --><dependency>    <groupId>com.h2database</groupId>    <artifactId>h2</artifactId>    <scope>runtime</scope></dependency>

使用了jpa的设置可以直接把repositoryimpl删除了，对contact做了实体化，还需要把contactServiceAspect注释掉，不然无法在web界面正确显示添加的联系人信息，修改了controller的存储设置，使用repository存储到h2数据库。

