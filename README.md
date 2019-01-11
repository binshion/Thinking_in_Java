# Thinking_in_Java
### dete: 2019-01-11
### page：413

## Chapter
# 10. 内部类

## 10.7 嵌套类 ***********************234

## 10.8 为什么需要内部类 **************237
### 10.8.1 闭包与回调 *****************238
### 10.8.2 内部类与控制框架 ***********240

## 10.9 内部类的继承 ******************245

## 10.10 内部类可以被覆盖吗 ************245

## 10.11 局部内部类 *******************247

## 10.12 内部类标识符 *****************248


# 11. 持有对象 ************************249

## 11.1 泛型和安全类型的容器 ***********249

## 11.2 基本概念 *********************252

## 11.3 添加一组元素 *****************253

## 11.4 容器的打印 *******************254

## 11.5 List ************************256

## 11.6 迭代器 **********************259

## 11.7 LinkedList *****************261

## 11.8 Stack **********************262

## 11.9 Set ************************264

## 11.10 Map ***********************266

## 11.11 Queue *********************269
### 11.11.1 PriorityQueue **********270

## 11.12 Collection和Iterator ******271

## 11.13 Foreach与迭代器 ***********274
### 11.13.1 适配器方法惯用法 *******276

## 11.14 总结 *********************278

# 12. 通过异常处理错误 *************281

## 12.1 概念 **********************281

## 12.2 基本异常 *******************282
### 12.2.1 异常参数 ****************283

## 12.3 捕获异常 *******************283

## 12.4 创建自定义异常 **************284
### 12.4.1 异常与记录日志 ***********286

## 12.5 异常说明 *******************289

## 12.6 捕获所有异常 ***************289
### 12.6.1 栈轨迹 ******************290
### 12.6.2 重新抛出异常 ************291
### 12.6.3 异常链 ******************293

## 12.7 Java标准异常 ***************296
### 12.7.1 特例：RuntimeException **296

## 12.8 使用finally进行清理 ********297
### 12.8.1 finally用来做什么 *******298
### 12.8.2 在return中使用finally ***300
### 12.8.3 缺憾：异常丢失 **********301

## 12.9 异常的限制 *****************302

## 12.10 构造器 ********************304

## 12.11 异常匹配 *****************308

## 12.12 其他可选方式 *************309
### 12.12.1 历史 *****************310
### 12.12.2 观点 *****************311
### 12.12.3 把异常传递给控制台 ****312
### 12.12.4 把“被检查异常”转换为“不检查异常” **312

## 12.13 异常使用指南 ***********314

## 12.14 总结 ******************314

# 13. 字符串 *******************316

## 13.1 不可变String ***********316

## 13.2 重载 “+” 与StringBuilder *316

## 13.3 无意识的递归 *************320

## 13.4 String上的操作 ***********321

## 13.5 格式化输出 ***************322

## 13.6 正则表达式 ***************328
### 13.6.1 基础 ******************328
### 13.6.2 创建正则表达式 *********330
### 13.6.3 量词 ******************331
### 13.6.4 Pattern和Matcher ******333
### 13.6.5 split() ***************338
### 13.6.6 替换操作 ***************339
### 13.6.7 reset() ***************340
### 13.6.8 正则表达式与Java I/O ***340

## 13.7 扫描输入 ******************342
### 13.7.1 Scanner定界符 **********343
### 13.7.2 用正则表达式扫描 ********344

## 13.8 StringTokenizer ***********345

## 13.9 总结 **********************345


# 14. 类型信息 ********************346

## 14.1 为什么需要RTTI *************346

## 14.2 Class对象 *****************347
### 14.2.1 类字面常量 *************351
### 14.2.2 泛化的Class引用 ********353
### 14.2.3 新的转型语法 ***********355

## 14.3 类型转换前先做检查 ********355
### 14.3.1 使用类字面常量 *********360
### 14.3.2 动态的instanceof ******362
### 14.3.3 递归计数 **************363

## 14.4 注册工厂 *****************364

## 14.5 instanceof与Class的等价性 *366

## 14.6 反射：运行时的类信息 ******367
### 14.6.1 类方法提取器 **********368

## 14.7 动态代理 ****************370

## 14.8 空对象 ******************374
### 14.8.1 模拟对象与桩 *********379

## 14.9 接口与类型信息 **********379

## 14.10 总结 ******************383

# 15. 泛型 *********************385

## 15.1 与C++的比较 ************385

## 15.2 简单泛型 ***************386
### 15.2.1 一个元组类库 ********387
### 15.2.2 一个堆栈类 **********389
### 15.2.3 RandomList *********390

## 15.3 泛型接口 **************391

## 15.4 泛型方法 **************394
### 15.4.1 杠杆利用类型参数推断 *395
### 15.4.2 可变参数与泛型方法 **396
### 15.4.3 用于Generator的泛型方法 *397
### 15.4.4 一个通用的Generator **397
### 15.4.5 简化元组的使用 *******399
### 15.4.6 一个Set实用工具 ******400

## 15.5 匿名内部类 *************402

## 15.6 构建复杂模型 ***********404

## 15.7 擦除的神秘之处 *********405
### 15.7.1 C++的方式 ***********406
### 15.7.2 迁移兼容性 **********408
### 15.7.3 擦除的问题 **********409
### 15.7.4 边界处的动作 ********410

## 15.8 擦除的补偿 *************413
### 15.8.1 创建类型实例 ********414