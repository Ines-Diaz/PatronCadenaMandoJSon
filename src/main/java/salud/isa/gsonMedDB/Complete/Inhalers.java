package salud.isa.gsonMedDB.Complete;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class Inhalers extends Category {

	private static final String INHALERS_TAGNAME = "inhalers";

	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEPARATOR = ";";

	public Inhalers(Category suc) {
		super(suc);
		categoryName = new String(INHALERS_TAGNAME);
	}

	@Override
	protected String readObjectEntry(JsonReader reader) throws IOException {
		String inhaName = null;
		String inhaImage = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				inhaName = reader.nextString();
			} else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				inhaImage = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return inhaName + FIELD_SEPARATOR + inhaImage;
	}

}
