package com.pattern.pattern.responsibility;

/**
 * Description: 解决问题的抽象类
 *
 * @author lihui
 * @time 2021/6/2 7:35 下午
 */
public abstract class Support {

    private String name;

    private Support next;

    public Support(String name) {
        this.name = name;
    }

    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    protected abstract boolean resolve(Trouble trouble);

    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } {
            fail(trouble);
        }
    }

    @Override
    public String toString() {
        return "Support{" +
                "name='" + name + '\'' +
                '}';
    }

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by" + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + "cannot be resolved.");
    }
}
