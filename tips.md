SpringBoot
    01. 过滤器及拦截器执行顺序: 先过滤器再拦截器
    02. @SpringBootApplication  
            默认扫描该类同级目录下的文件
    03. @ServletComponentScan注解后
            Servlet Filter Listener 可以直接通过 @WebServlet @WebFilter @WebListener 注解自动注册
    04. Swagger测试地址
            http://ip:端口/应用名称/swagger-ui.html
    05. @Component  @Configuration
        @Configuration会生成代理类 可以返回Bean
        @Component不会生成代理类  webSocket需要用这个 有代理类会导致应用启动失败
fims
    01. 菜单配置 sys_menu
        01. 字段menu_type
            1: 页面
            2：查询权限
            3：设置权限
            4：数据权限(只能配置一个 menu_id为[20190000000000])
        02. 系统管理员 用户代码user_code为[admin]加载所有菜单 其他用户根据权限加载
        03. 系统管理员 用户代码user_code为[admin]加载页面按钮 其他用户根据权限加载
    02. 数据权限
        01. 系统管理员 用户代码user_code为[admin]加载所有用户数据 其他用户根据权限加载
        02. 数据权限及按钮权限控制页面
                收入信息 随礼信息 收入报表 送礼报表 收礼报表
        03. 没有数据权限及按钮权限控制页面
                用户信息 角色信息 字典信息
    03. ajax请求session失效处理 view.js 维护
    04. set.js 修改密码按钮事件已注释(移动至password.ftl)
    05. index.js 退出按钮事件已注释(移动至index.ftl)