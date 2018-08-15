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
        // 对象唯一且不可变。
        private static final Singleton0 instance = new Singleton0();

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

        // 非线程安全，当有多个线程执行这个方法时，有可能一个线程检查完instance==null，
        // 而此时这个线程阻塞，就在此时另一个线程创建了一个对象，而之前那个线程重新执行，这时候就会出现多个对象。
        public static Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    /**
     * 懒汉式，线程安全版本，效率不高。
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
     * 双重校验模式：加同步锁前后两次判断实例是否存在
     */
    public static class Singleton3 {
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
     * 静态内部类法：把Singleton实例放到一个静态内部类中，这样就避免了静态实例在类加载的时候就创建对象，
     * 并且由于静态内部类只会被加载一次，所以这种写法也是线程安全的。
     */
    public static class Singleton4 {
        private static class SingletonHolder {
            private static final Singleton4 instance = new Singleton4();
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
        INSTANCE;

        public void doSomething() {
            //
        }
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
