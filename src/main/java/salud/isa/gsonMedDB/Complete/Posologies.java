package salud.isa.gsonMedDB.Complete;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class Posologies extends Category {

	private static final String POSOLOGIES_TAGNAME = "posologies";

	private static final String DESCRIPTION_FIELD_TAGNAME = "description";

	public Posologies(Category suc) {
		super(suc);
		categoryName = new String(POSOLOGIES_TAGNAME);
	}

	@Override
	protected String readObjectEntry(JsonReader reader) throws IOException {
		String posoDescription = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(DESCRIPTION_FIELD_TAGNAME)) {
				posoDescription = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return posoDescription;
	}

}
