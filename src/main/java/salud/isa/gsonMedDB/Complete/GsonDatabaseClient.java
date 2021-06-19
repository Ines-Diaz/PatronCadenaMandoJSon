package salud.isa.gsonMedDB.Complete;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GsonDatabaseClient {

	public static void main(String[] args) {
		try {

			Category umStepsReader = new UserManualSteps(null);
			Category umPhyStepsReader = new UserManualPhysioSteps(umStepsReader);
			Category resMedPresReader = new RescueMedicinePresentations(umPhyStepsReader);
			Category medPresReader = new MedicinePresentations(resMedPresReader);
			Category posoReader = new Posologies(medPresReader);
			Category inhaReader = new Inhalers(posoReader);
			Category physioReader = new Physiotherapies(inhaReader);
			Category actIngReader = new ActiveIngredients(physioReader);
			Category medReader = new Medicines(actIngReader);

			DatabaseJSonReader dbjp = new DatabaseJSonReader();

			try {
				System.out.println(dbjp.parse(medReader, "./src/main/resources/datos.json"));
			} finally {
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
