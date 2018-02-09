package listADT;
/** List ADT */
public interface List {

	public void add(Object elem);
	public void add(int index, Object elem);
	public Object get(int index);
	public void remove(int index);
	public void remove(Object elem);
	public int size();
	public void clear();

	public ListIterator listIterator();
	public ListIterator listIterator(int index);

}
