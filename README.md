
# springboot-multiDataSource-Demo
* SpringBoot+MyBatis多数据源使用分页插件PageHelper

## 配置文件
```application.yml

```

### 数据源配置类
/springboot-multiDataSource-Demo/src/main/java/com/simple/multiDataSource/config/DataSourceConfig.java

### 动态数据源
/springboot-multiDataSource-Demo/src/main/java/com/simple/multiDataSource/config/DynamicDataSource.java

### Mapper中的方法添加注解
/springboot-multiDataSource-Demo/src/main/java/com/simple/multiDataSource/mapper/NewsMapper.java


### 多数据源配置主意的几点：

*  SimpleServerApplication 中去掉springboot自动配置数据源， @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

* 不要在SqlSessionFactory中配置PageInterceptor,因为pagehelper-spring-boot-autoconfigure-*.jar里把PageInterceptor加上了。项目是拷贝出了com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration,在加拦截器之前给PageInterceptor设置autoRuntimeDialect=true属性。

* com.simple.multiDataSource.config.DatabaseType中可以配置数据源类型，方便扩展。

* DynamicDataSourceAspect中配置好切面，配置为mapper所在的包



        		
        		