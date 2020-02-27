public class Singleton {
	private static Singleton instance;
	private Singleton (){}
 
	//not thread safe
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	//thread safe but slow
	public synchronized static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	//Synchronize the critical code only, not thread safe
	public static Singleton getInstance() {
		if(singleton == null) {
			synchronized(Singleton.class) { 
				singleton = new Singleton();
			}
		}
		return singleton;
	}
}

public class Singleton {
	private volatile static Singleton instance; //声明成 volatile
	private Singleton (){}
 
	public static Singleton getSingleton() {
		if (instance == null) {                         
			synchronized (Singleton.class) {
				if (instance == null) {       
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
// Correct lazy initialization in Java 
@ThreadSafe
class Singleton {
	private static class SingletonHolder {
	   public static Singleton instance = new Singleton();
	}
 
	public static Singleton getInstance() {
		return SingletonHolder.instance;
	}
}
	
