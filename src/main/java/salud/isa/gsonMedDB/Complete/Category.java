package salud.isa.gsonMedDB.Complete;

import java.io.IOException;

import com.google.gson.stream.JsonReader;

public abstract class Category {
	
	protected Category sucesor;
	protected String categoryName;

	public Category(Category suc) {
		sucesor = suc;
	}

	protected StringBuffer readCategory(JsonReader reader, String name) throws IOException {
		if (name.equals(categoryName)) {
			StringBuffer objectData = new StringBuffer();
			reader.beginArray();
			while (reader.hasNext()) {
				reader.beginObject();
				objectData.append(readObjectEntry(reader)).append("\n");
				reader.endObject();
			}
			objectData.append("\n");
			reader.endArray();
			return objectData;
		} else {
			return sucesor.readCategory(reader, name);
		}
	}

	protected abstract String readObjectEntry(JsonReader reader) throws IOException;

}
