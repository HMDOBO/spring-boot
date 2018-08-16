# spring-boot-swagger2

参考：https://github.com/SpringForAll/spring-boot-starter-swagger

使用spring-boot-starter-swagger，主要使用swagger ui

具体配置根据上面参考链接

常用注解

1. @Api 作用在类上，用于标识所属模块，例如用户管理模块、订单模块
2. @ApiOperation 作用在方法上，用于标识接口说明，可以自定义接口名称，接口描述，接口类型等
3. ApiImplicitParams和ApiImplicitParam 作用在方法上，用于定义接口参数格式、含义等
4. @ApiModel和@ApiModelProperty 分别作用于实体类的类上和字段上，用于实体类描述和字段描述、字段是否必填等

使用总结：

相比较传统Word格式接口文档，swagger ui优点在于接口文档编写更加快速，文档能够根据接口的变化实时更新，但是个人感觉缺点还是很明显的，比如不够灵活，必须遵循swagger的规范编写指定格式文档，并且文档和代码耦合到一块，其实文档并非业务所必须的，增加了无关的代码量，代码看起来更加繁琐。可能是目前对swagger ui理解不足，还是不太喜欢swagger。

