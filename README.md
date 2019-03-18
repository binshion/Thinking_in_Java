# Thinking_in_Java
===================
* dete: 2019-03-13
* page：枚举类型

## Chapter
# 10. 内部类
* 10.7 嵌套类 ***********************234
* 10.8 为什么需要内部类 **************237
    * 10.8.1 闭包与回调 *****************238
    * 10.8.2 内部类与控制框架 ***********240
* 10.9 内部类的继承 ******************245
* 10.10 内部类可以被覆盖吗 ************245
* 10.11 局部内部类 *******************247
* 10.12 内部类标识符 *****************248

# 11. 持有对象 ************************249
* 11.1 泛型和安全类型的容器 ***********249
* 11.2 基本概念 *********************252
* 11.3 添加一组元素 *****************253
* 11.4 容器的打印 *******************254
* 11.5 List ************************256
* 11.6 迭代器 **********************259
* 11.7 LinkedList *****************261
* 11.8 Stack **********************262
* 11.9 Set ************************264
* 11.10 Map ***********************266
* 11.11 Queue *********************269
    * 11.11.1 PriorityQueue **********270
* 11.12 Collection和Iterator ******271
* 11.13 Foreach与迭代器 ***********274
    * 11.13.1 适配器方法惯用法 *******276
* 11.14 总结 *********************278

# 12. 通过异常处理错误 *************281
* 12.1 概念 **********************281
* 12.2 基本异常 *******************282
    * 12.2.1 异常参数 ****************283
* 12.3 捕获异常 *******************283
* 12.4 创建自定义异常 **************284
    * 12.4.1 异常与记录日志 ***********286
* 12.5 异常说明 *******************289
* 12.6 捕获所有异常 ***************289
    * 12.6.1 栈轨迹 ******************290
    * 12.6.2 重新抛出异常 ************291
    * 12.6.3 异常链 ******************293
* 12.7 Java标准异常 ***************296
    * 12.7.1 特例：RuntimeException **296
* 12.8 使用finally进行清理 ********297
    * 12.8.1 finally用来做什么 *******298
    * 12.8.2 在return中使用finally ***300
    * 12.8.3 缺憾：异常丢失 **********301
* 12.9 异常的限制 *****************302
* 12.10 构造器 ********************304
* 12.11 异常匹配 *****************308
* 12.12 其他可选方式 *************309
    * 12.12.1 历史 *****************310
    * 12.12.2 观点 *****************311
    * 12.12.3 把异常传递给控制台 ****312
    * 12.12.4 把“被检查异常”转换为“不检查异常” **312
* 12.13 异常使用指南 ***********314
* 12.14 总结 ******************314

# 13. 字符串 *******************316
* 13.1 不可变String ***********316
* 13.2 重载 “+” 与StringBuilder *316
* 13.3 无意识的递归 *************320
* 13.4 String上的操作 ***********321
* 13.5 格式化输出 ***************322
* 13.6 正则表达式 ***************328
    * 13.6.1 基础 ******************328
    * 13.6.2 创建正则表达式 *********330
    * 13.6.3 量词 ******************331
    * 13.6.4 Pattern和Matcher ******333
    * 13.6.5 split() ***************338
    * 13.6.6 替换操作 ***************339
    * 13.6.7 reset() ***************340
    * 13.6.8 正则表达式与Java I/O ***340
* 13.7 扫描输入 ******************342
    * 13.7.1 Scanner定界符 **********343
    * 13.7.2 用正则表达式扫描 ********344
* 13.8 StringTokenizer ***********345
* 13.9 总结 **********************345

# 14. 类型信息 ********************346
* 14.1 为什么需要RTTI *************346
* 14.2 Class对象 *****************347
    * 14.2.1 类字面常量 *************351
    * 14.2.2 泛化的Class引用 ********353
    * 14.2.3 新的转型语法 ***********355
* 14.3 类型转换前先做检查 ********355
    * 14.3.1 使用类字面常量 *********360
    * 14.3.2 动态的instanceof ******362
    * 14.3.3 递归计数 **************363
* 14.4 注册工厂 *****************364
* 14.5 instanceof与Class的等价性 *366
* 14.6 反射：运行时的类信息 ******367
    * 14.6.1 类方法提取器 **********368
* 14.7 动态代理 ****************370
* 14.8 空对象 ******************374
    * 14.8.1 模拟对象与桩 *********379
* 14.9 接口与类型信息 **********379
* 14.10 总结 ******************383

# 15. 泛型 *********************385
* 15.1 与C++的比较 ************385
* 15.2 简单泛型 ***************386
    * 15.2.1 一个元组类库 ********387
    * 15.2.2 一个堆栈类 **********389
    * 15.2.3 RandomList *********390
* 15.3 泛型接口 **************391
* 15.4 泛型方法 **************394
    * 15.4.1 杠杆利用类型参数推断 *395
    * 15.4.2 可变参数与泛型方法 **396
    * 15.4.3 用于Generator的泛型方法 *397
    * 15.4.4 一个通用的Generator **397
    * 15.4.5 简化元组的使用 *******399
    * 15.4.6 一个Set实用工具 ******400
* 15.5 匿名内部类 *************402
* 15.6 构建复杂模型 ***********404
* 15.7 擦除的神秘之处 *********405
    * 15.7.1 C++的方式 ***********406
    * 15.7.2 迁移兼容性 **********408
    * 15.7.3 擦除的问题 **********409
    * 15.7.4 边界处的动作 ********410
* 15.8 擦除的补偿 *************413
    * 15.8.1 创建类型实例 ********414
    * 15.8.2 泛型数组 ************416
* 15.9 边界 ******************419
* 15.10 通配符 ****************422
    * 15.10.1 编译器有多聪明 *****424
    * 15.10.2 逆变 ***************426
    * 15.10.3 无界通配符 *********428
    * 15.10.4 捕获转换 ***********432
* 15.11 问题 *****************433
    * 15.11.1 任何基本类型都不能作为类型参数 *433
    * 15.11.2 实现参数化接口 ****434
    * 15.11.3 转型和警告 ********435
    * 15.11.4 重载 **************436
    * 15.11.5 基类劫持了接口 *****437
* 15.12 自限定的类型 **********437
    * 15.12.1 古怪的循坏泛型 *****437
    * 15.12.2 自限定 ************438
    * 15.12.3 参数协变 **********440
* 15.13 动态类型安全 *********442
* 15.14 异常 ****************443
* 15.15 混型 ****************445
    * 15.15.1 C++中的混型 ******445
    * 15.15.2 与接口混合 *******446
    * 15.15.3 使用装饰器模式 ***447
    * 15.15.4 与动态代理混合 ***448
* 15.16 潜在类型机制 ********449
* 15.17 对却反潜在类型机制的补偿 *453
    * 15.17.1 反射 *************453
    * 15.17.2 将一个方法应用于序列 *454
    * 15.17.3 当你并未碰巧拥有真确的接口时 *456
    * 15.17.4 用适配器仿真潜在类型机制 *457
* 15.18 将函数对象用作策略 ***459
* 15.19 总结：转型真的如此之糟吗？ *463
    * 15.19.1 进阶读物 **********465

# 16. 数组 *******************466
* 16.1 数组为什么特殊 *******466
* 16.2 数组是第一级对象 *****467
* 16.3 返回一个数组 *********469
* 16.4 多维数组 *************470
* 16.5 数组与泛型 ***********473
* 16.6 创建测试数据 *********475
    * 16.6.1 Arrays.fill() ****475
    * 16.6.2 数据生成器 ********476
    * 16.6.3 从Generator中创建数组 *480
* 16.7 Arrays实用功能 *******483
    * 16.7.1 复制数组 **********483
    * 16.7.2 数组的比较 ********484
    * 16.7.3 数组元素的比较 ****485
    * 16.7.4 数组排序 *********487
    * 16.7.5 在已排序的数组中查找 *488
* 16.8 总结 ***************490

# 17. 容器深入研究 **********492
* 17.1 完整的容器分类法 ****492
* 17.2 填充容器 ***********493
    * 17.2.1 一种Generator解决方案 *493
    * 17.2.2 Map生成器 ******495
    * 17.2.3 使用Abstract类 **497
* 17.3 Collection的功能方法 *503
* 17.4 可选操作 **********505
    * 17.4.1 未获支持的操作 **506
* 17.5 List的功能方法 ****507
* 17.6 Set和存储顺序 *****510
    * 17.6.1 SortedSet *****512
* 17.7 队列 *************513
    * 17.7.1 优先级队列 *****514
    * 17.7.2 双向队列 *******515
* 17.8 理解Map **********516
    * 17.8.1 性能 *******517
    * 17.8.2 SortedMap ***519 
    * 17.8.3 LinkedHashMap **520
* 17.9 散列与散列码 *********521
    * 17.9.1 理解hashCode() **523
    * 17.9.2 为速度而散列 *****525
    * 17.9.3 覆盖hashCode() **528
* 17.10 选择不同的接口 ********532
    * 17.10.1 性能测试框架 ****532
    * 17.10.2 对List的选择 ****535
    * 17.10.3 微基准测试的危险 *540
    * 17.10.4 对Set的选择 *****541
    * 17.10.5 对Map的选择 *****542
* 17.11 使用方法 **************545
    * 17.11.1 List的排序和查询 *547  内容丢失
    * 17.11.2 设定Collection或Map为不可修改 *548 部分丢失
    * 17.11.3 Collection或Map的同步控制 ****549
* 17.12 持有引用 **************551
    * 17.12.1 WeakHahMap ******552
* 17.13 Java 1.0/1.1 的容器 ****553
    * 17.13.1 Vector和Enumeration **553
    * 17.13.2 Hashtable ********554
    * 17.13.3 Stack ************554
    * 17.13.4 BitSet ***********555
* 17.14 总结 ********************557

# 18. Java I/O系统 *************558

# 19. 枚举类型 ******************623
* 19.1 基本enum特性 *************623
    * 19.1.1 将静态导入用于enum **624
* 19.2 向enum中添加新方法 ********624
    * 19.2.1 覆盖enum的方法 ******625
* 19.3 switch语句中的enum ********626
* 19.4 values()的神秘之处 ********627
* 19.5 实现，而非继承 ************628
* 19.6 随机选取 ******************629
# 20. 

# 21. 

# 22.
     
