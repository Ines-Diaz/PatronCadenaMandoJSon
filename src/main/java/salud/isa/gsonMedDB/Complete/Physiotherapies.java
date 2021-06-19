package salud.isa.gsonMedDB.Complete;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class Physiotherapies extends Category {

	private static final String PHYSIOTHERAPIES_TAGNAME = "physiotherapies";

	private static final String NAME_FIELD_TAGNAME = "name";
	private static final String IMAGE_FIELD_TAGNAME = "image";
	private static final String FIELD_SEPARATOR = ";";

	public Physiotherapies(Category suc) {
		super(suc);
		categoryName = new String(PHYSIOTHERAPIES_TAGNAME);
	}

	@Override
	protected String readObjectEntry(JsonReader reader) throws IOException {
		String physioName = null;
		String physioImage = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				physioName = reader.nextString();
			} else if (name.equals(IMAGE_FIELD_TAGNAME)) {
				physioImage = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return physioName + FIELD_SEPARATOR + physioImage;
	}

}
