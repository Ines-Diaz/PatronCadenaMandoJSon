package salud.isa.gsonMedDB.Complete;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class Medicines extends Category {

	private static final String MEDICINES_TAGNAME = "medicines";

	private static final String NAME_FIELD_TAGNAME = "name";

	public Medicines(Category suc) {
		super(suc);
		categoryName = new String(MEDICINES_TAGNAME);
	}

	@Override
	protected String readObjectEntry(JsonReader reader) throws IOException {
		String medName = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				medName = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return medName;
	}

}
