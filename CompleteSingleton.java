public final class Singleton implements Serializable {
&nbsp;
<pre>
 // static Singleton reference is initialised to refer to Singleton instance, when this class is first loaded
 // so that this instance can be accessible without creating an object and without having to worry about thread
 // synchronization in case of, lazy loading (where we do a null check inside getInstance()...
 public static final Singleton instance= new Singleton(); // make it private as an optimization step.</p>
 // Suppresses instantiation outside this class
 private Singleton() {

 }

 // One instance per class loader of this class, per JVM
 public static Singleton getInstance(){
  return instance;
 }
 // Prevents Singleton.clone() call by the client
 public Object clone() throws CloneNotSupportedException {
  throw new CloneNotSupportedException();
 }

 private Object readResolve() throws ObjectStreamException {
  // Return the one true Singleton and let the garbage collector
  // take care of the Singleton impersonator.
  return instance;
 }
