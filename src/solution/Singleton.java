package solution;

/**
 * Author: Berlin
 * Problem2：设计一个类，我们只能生成该类的一个实例。
 */
public class Singleton {

    /**
     * 饿汉式：在类加载的时候就创建对象实例，而不管实际是否需要创建。
     * 这样做的好处是编写简单，但是无法做到延迟创建对象。
     * 但是我们很多时候都希望对象可以尽可能地延迟加载，从而减小负载。详细见懒汉式。
     * 线程安全。
     */
    public static class Singleton0 {
        // 提前初始化
        private static Singleton0 instance = new Singleton0();

        // 把构造函数设为私有以禁止他人创建实例。
        private Singleton0() {}

        public static Singleton0 getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式：按需、延迟创建实例即延迟加载模式。
     * 非线程安全。
     */
    public static class Singleton1 {
        // 对象唯一，但此时不创建对象，延迟创建。
        private static Singleton1 instance = null;

        private Singleton1() {}

        // 一个线程写入instance的操作和另一个线程读取instance的操作之间不满足Happens-Before关系。
        // 因此在发布对象时存在数据竞争问题，因此另一个线程并不一定能看到instance的状态。详情见《Java并发编程实战》P283。
        // 也就是假设A线程看到instance为null，所以创建出一个实例对象，但在把对象引用写进instance时，
        // 这时候线程B可能看到instance也为null，因此又创建了一个对象。
        public static Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();    // 不安全的发布
            }
            return instance;
        }
    }

    /**
     * 懒汉式，线程安全版本，并发度不高。延迟初始化
     */
    public static class Singleton2 {
        private static Singleton2 instance = null;

        private Singleton2() {}

        // 当一个线程得到了锁之后，其他线程都要等待。加锁是一个非常耗时的操作，所以其效率不高。
        public static synchronized Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 双重检查加锁：加内置对象锁前后两次判断实例是否存在
     * 注意：线程安全
     * 虽然这是线程安全的，因为在共享的instance变量加上了volatile的同时也对instance的操作进行了同步，
     * 但是这个模式已经被废弃了，详情见《Java并发编程实战》P286
     */
    public static class Singleton3 {
        // 最重要的是加了volatile关键字，保证了instance的可见性和禁止重排序，
        // 如果没有volatile关键字，则会导致对象的部分构造（由于对象引用的写入
        // 操作与对象的域的写入操作会发生重排序而导致的），这是不安全的发布，是线程不安全的。
        private volatile static Singleton3 instance = null;

        private Singleton3() {}

        // 第一层判断是当instance不为null时，我们不需要再进行加锁，而直接返回实例，从而提高效率。
        public static Singleton3 getInstance() {
            if (instance == null) {
                synchronized(Singleton3.class) {
                    if (instance == null) {
                        instance = new Singleton3();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 延长初始化占位类模式
     * 静态内部类法：把Singleton实例放到一个静态内部类中，这样就避免了静态实例在类加载的时候就创建对象，
     * 并且由于静态内部类只会被加载一次，所以这种写法也是线程安全的。
     */
    public static class Singleton4 {
        private static class SingletonHolder {
            private static Singleton4 instance = new Singleton4();
        }

        private Singleton4() {}

        public static Singleton4 getInstance() {
            return SingletonHolder.instance;
        }
    }

    /**
     * 枚举：使用枚举除了线程安全和防止反射强行调用构造器之外，还提供了自动序列化机制，防止反序列化的时候创建新的对象。
     * 因此，《Effective Java》推荐尽可能地使用枚举来实现单例。
     */
    public enum Singleton5 {
        INSTANCE
    }

    public static void main(String[] args) {
        System.out.println(Singleton0.getInstance() == Singleton0.getInstance());
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.INSTANCE == Singleton5.INSTANCE);

    }
}
