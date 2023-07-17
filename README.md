# 注水井综合开发评价系统 Cloud后台
## 项目结构
group06-cloud
- group06-ability：鉴权相关
  - group06-ability-auth：身份认证接口 @AUTH
  - group06-ability-gateway：网关组件
- group06-api：REST接口
  - group06-api-core：业务接口 @API
  - group06-api-system：系统接口 @SYSTEM
- group06-common：通用工具类
  - group-common-core：常规通用工具类
  - group-common-mysql：MYSQL配置相关类
  - group-common-web：WEB相关工具类
- group06-config：配置中心
- group06-data：DAL数据访问层
  - group06-data-core：业务接口DAL
  - group06-data-system：系统接口DAL