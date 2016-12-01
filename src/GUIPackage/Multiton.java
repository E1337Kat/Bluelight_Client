package GUIPackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Multiton<K extends Enum<K> & Multiton.Creator> {

	private final ConcurrentMap<K, Future<Object>> multitons = new ConcurrentHashMap<K, Future<Object>>();
	
	// The enums must create
	public interface Creator {
		public abstract Object create();

	}
	
	// The getter.
	  public <V> V get(final K key, Class<V> type) {
	    // Has it run yet?
	    Future<Object> f = multitons.get(key);
	    if (f == null) {
	      // No! Make the task that runs it.
	      FutureTask<Object> ft = new FutureTask<Object>(
	              new Callable() {

	                public Object call() throws Exception {
	                  // Only do the create when called to do so.
	                  return key.create();
	                }

	              });
	      // Only put if not there.
	      f = multitons.putIfAbsent(key, ft);
	      if (f == null) {
	        // We replaced null so we successfully put. We were first!
	        f = ft;
	        // Initiate the task.
	        ft.run();
	      }
	    }
	    try {
	      /**
	       * If code gets here and hangs due to f.status = 0 (FutureTask.NEW)
	       * then you are trying to get from your Multiton in your creator.
	       *
	       * Cannot check for that without unnecessarily complex code.
	       *
	       * Perhaps could use get with timeout.
	       */
	      // Cast here to force the right type.
	      return type.cast(f.get());
	      
	    } catch (Exception ex) {
	      // Hide exceptions without discarding them.
	      throw new RuntimeException(ex);
	    }
	  }
	
	enum E implements Creator {
	    A {

	              public String create() {
	                return "Face";
	              }

	            },
	    B {

	              public Integer create() {
	                return 0xFace;
	              }

	            },
	    C {

	              public Void create() {
	                return null;
	              }

	            };
	  }
	
}
