package base;

/**
 * @Author: 余子毅
 * @Date: 2021/5/24 9:42
 */
public interface Module {

    /**
     * 题目说明
     * @return 名称
     */
    String desc();

    /**
     * 题号，如 "Acwing708"
     * @return 题号
     */
    String code();
}
