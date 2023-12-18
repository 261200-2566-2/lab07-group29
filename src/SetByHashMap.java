import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class SetByHashMap<E> implements Set<E> {

    private static final Object DefaultVal = new Object();
    private final HashMap<E,Object>map;

    public SetByHashMap(){
        this.map = new HashMap<>();
    }


    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object element) {
        return map.containsKey(element);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return a;
    }

    @Override
    public boolean add(E element) {
        return map.put(element,DefaultVal)==null;
    }

    @Override
    public boolean remove(Object element) {
        return map.remove(element) != null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object element : c){
            if(!contains(element)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for(E element : c){
            if(add(element)){
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Iterator<E> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            if(!c.contains(iterator.next())){
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for(Object element : c){
            if(remove(element)){
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        map.clear();
    }


    // https://chat.openai.com/---------------//
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
            if (iterator.hasNext()) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
    //----------------------------------------//
}

//https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Set.html