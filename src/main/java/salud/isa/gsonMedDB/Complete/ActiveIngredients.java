package salud.isa.gsonMedDB.Complete;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public class ActiveIngredients extends Category {
	
	private static final String ACTIVEINGREDIENTES_TAGNAME = "activeIngredients";
	
	private static final String NAME_FIELD_TAGNAME = "name";
	
	public ActiveIngredients(Category suc) {
		super(suc);
		categoryName = new String(ACTIVEINGREDIENTES_TAGNAME);
	}

	@Override
	protected String readObjectEntry(JsonReader reader) throws IOException {
		String actIngName = null;
		while (reader.hasNext()) {
			String name = reader.nextName();
			if (name.equals(NAME_FIELD_TAGNAME)) {
				actIngName = reader.nextString();
			} else {
				reader.skipValue();
			}
		}
		return actIngName;
	}

}
