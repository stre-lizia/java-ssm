package org.xueyinhu.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.xueyinhu.ssm.dao.StudentDao;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /** \ @Transactional
     * 位置：方法（该方法）或类（类的所有方法）
     * 属性：
     *  readonly=true 只读模式可以提升事务的效率，若只有查询代码，则建议使用
     *      一般情况下，@Transactional 在类上指定，可以在方法上覆盖进行只读
     *  timeout=-1 默认永远不超时，若超时则会回滚事务、释放资源。
     *  rollbackFor={} 指定异常回滚，建议指定为 Exception.class
     *  noRollbackFor={} 指定什么异常事务不回滚
     *      事务发生回滚的时机：默认内部发生运行时异常，事务才算失败
     *  isolation = Isolation.READ_COMMITTED 推荐设置为 读已提交 级别
     *      事务隔离级别：
     *          读未提交：事务可以读取未被提交过的数据，容易产生脏读、不可重复读与幻读的问题，一般不适用
     *          读已提交：只能读取已经提交后的数据，可以避免脏读问题，但是还是解决不了不可重复读和幻读的问题。
     *          可重复读：在一个事务中，相同的查询将返回相同的结果集，不论其他事务对数据做了什么修改。可以避免脏读和不可重复读，还是可能幻读
     *          串行性：完全禁止并发，只允许一个事务执行完成后再执行，可以避免以上问题，但是执行效率低，不适用于高并发场景。
     *  propagation = Propagation.REQUIRED 如果父事务上有设置，则继承。 Propagation.REQUIRES_NEW 则独立
     *      若事务之间相互调用，如何影响子事务，事务传播行为的属性加在子事务上
     *      在同一类中的事务相互调用，则不会触发事务的传播
     */
    @Transactional(readOnly = false, timeout = -1, rollbackFor = {Exception.class},
            isolation = Isolation.READ_COMMITTED
    )
    public void changeInfo() {
        studentDao.updateAgeById(100, 1);
        studentDao.updateNameById("test1", 1);
    }
}
