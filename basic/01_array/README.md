掌握:
* 实现一个数组, 支持增删改查以及动态扩容
* 实现两个有序数组合并为一个有序数组


动态数组实现要点:
* 主要函数有 `add(element)`, `get(index)`, `size()`, `remove(index)`
* 入参的 index 做边界校验
* `add(element)` 需要数组长度是否足够, 否则扩容
* 对于修改类的操作, 需要维护一个 `modCount` 字段, 用于实现遍历时的 `fast-fail`

迭代器实现要点:
* 操作时对比 `expectModCount` 与 `modCount`, 实现 `fast-fail`
* `remove` 时重新赋值 `expectModCount`
* 每一次 `remove` 只能对应本次的 `next`.