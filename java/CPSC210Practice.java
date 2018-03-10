public class CPSC210Practice {
	boolean cooking;

	/*
	EFFECTS: prints the name and lab section of each student,
	throws NullListException if names and/or labs are null
	throws SizeMismatchException if names and labs are of different sizes
	*/
	public void printLabSections(List<String> names, List<String> labs) throws NullListException, SizeMismatchException {
		if (names == null || labs == null) {
			throw new NullListException();
		}

		if (names.size() != labs.size()) {
			throw new SizeMismatchException();
		}

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + " is in lab section " + labs.get(i));
		}		
	}

	/*
	MODIFIES: this
	EFFECTS: if door is open, throws DoorOpenException
	otherwise cooks the food
	*/
	public void cook() throws DoorOpenException {
		if (this.isDoorOpen()) {
			throw new DoorOpenException("trying to cook while door is open");
		}
		this.cooking = true;
	}
}