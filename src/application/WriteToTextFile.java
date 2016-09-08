package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

public class WriteToTextFile {

	private int i;

	private double checkboxY;
	private double checkboxX;
	private double textfieldX;
	private double textfieldY;
	private double textareaX;
	private double textareaY;

	ArrayList<String> textList = new ArrayList<String>();
	
	private HashMap<Integer, Double> checkBoxMapX = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> checkBoxMapY = new HashMap<Integer, Double>();

	private HashMap<Integer, Double> textFieldMapX = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> textFieldMapY = new HashMap<Integer, Double>();

	private HashMap<Integer, Double> textAreaMapX = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> textAreaMapY = new HashMap<Integer, Double>();

	// konstruktor
	WriteToTextFile() {

	}

	public boolean SaveFile(File file) {

		int iteratorCheckbox = -1;
		int iteratorTextField = -1;
		int iteratorTextArea = -1;
		System.out.println("checking file");
		try {
			String txt = "", checkTxt;
			FileWriter fileWriter;

			// s�ker efter keywords som checkbox,textfield eller textarea i
			// textlist arrayen
			for (i = 0; i < textList.size(); i++) {
				checkTxt = textList.get(i);
				if (checkTxt.equals("checkbox")) {
					// varje g�ng checkbox p�tr�ffas i loopen Itererar jag en
					// int f�r att h�lla reda p� nyckeln som h�ller v�rdet i hashmappen
					iteratorCheckbox++;

					textList.set(i + 1, String.valueOf(checkBoxMapX.get(iteratorCheckbox).intValue()));
					textList.set(i + 2, String.valueOf(checkBoxMapY.get(iteratorCheckbox).intValue()));
				}

				if (checkTxt.equals("textfield")) {
					iteratorTextField++;

					textList.set(i + 1, String.valueOf(textFieldMapX.get(iteratorTextField).intValue()));
					textList.set(i + 2, String.valueOf(textFieldMapY.get(iteratorTextField).intValue()));
				}

				if (checkTxt.equals("textarea2")) {
					iteratorTextArea++;

					textList.set(i + 1, String.valueOf(textAreaMapX.get(iteratorTextArea).intValue()));
					textList.set(i + 2, String.valueOf(textAreaMapY.get(iteratorTextArea).intValue()));
				}
			}

			
			fileWriter = new FileWriter(file);
			if(fileWriter == null){
				return false;
			}
			for (i = 0; i < textList.size(); i++) {

				txt = textList.get(i) + "\r\n";
				fileWriter.write(txt);
			}
			System.out.println(textList.toString());

			fileWriter.close();


		} catch (IOException ex) {
			Logger.getLogger(WriteToTextFile.class.getName()).log(Level.SEVERE, null, ex);
		}
        return true;
	}

	public void showFileChooser() {
		FileChooser fileChooser = new FileChooser();
		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("INI files (*.ini)", "*.ini");
		fileChooser.getExtensionFilters().add(extFilter);
		// Show save file dialog
		File file = fileChooser.showSaveDialog(null);
		if (file != null) {
			SaveFile(file);
		}
	}

	public void setTextInFile(String text) {
		textList.add(text);

	}

	public void setCheckboxX(double checkboxX) {
		this.checkboxX = checkboxX;
	}

	public double getCheckboxX() {
		return this.checkboxX;
	}

	public void setCheckboxY(double checkboxY) {
		this.checkboxY = checkboxY;
	}

	public void setTextfieldX(double textfieldX) {
		this.textfieldX = textfieldX;
	}

	public void setTextfieldY(double textfieldY) {
		this.textfieldY = textfieldY;
	}

	public void setTextareaX(double textareaX) {
		this.textareaX = textareaX;
	}

	public void setTextareaY(double textareaY) {
		this.textareaY = textareaY;
	}

	// collision index skickas varje g�ng en checkbox blir dragen ,
	// creationIndex updateras varje g�ng en nod skapas
	public void setCheckBoxMap(Integer collisionIndex, Integer creationIndex) {

		// creation index h�r f�r att fylla nyckel positionen , value l�mmnar
		// jag noll vid tillf�llet
		checkBoxMapX.put(creationIndex, 0.0);
		checkBoxMapY.put(creationIndex, 0.0);

		// varje g�ng jag drar i en checkbox kallas denna metod och updaterar
		// hashmapen
		checkBoxMapX.replace(collisionIndex, checkboxX);
		checkBoxMapY.replace(collisionIndex, checkboxY);

		System.out.println("checkbox" + collisionIndex + " X : " + checkBoxMapX.get(collisionIndex) + " \t" + "y : "
				+ checkBoxMapY.get(collisionIndex));
	}

	public void setTextFieldMap(Integer collisionIndex, Integer creationIndex) {

		// creation index h�r f�r att fylla nyckel positionen , value l�mmnar
		// jag noll vid tillf�llet
		textFieldMapX.put(creationIndex, 0.0);
		textFieldMapY.put(creationIndex, 0.0);

		// varje g�ng jag drar i en checkbox kallas denna metod och updaterar
		// hashmapen
		textFieldMapX.replace(collisionIndex, textfieldX);
		textFieldMapY.replace(collisionIndex, textfieldY);

		System.out.println("textfield" + collisionIndex + " X : " + textFieldMapX.get(collisionIndex) + " \t" + "y : "
				+ textFieldMapY.get(collisionIndex));
	}

	public void setTextAreaMap(Integer collisionIndex, Integer creationIndex) {

		// creation index h�r f�r att fylla nyckel positionen , value l�mmnar
		// jag noll vid tillf�llet
		textAreaMapX.put(creationIndex, 0.0);
		textAreaMapY.put(creationIndex, 0.0);

		// varje g�ng jag drar i en checkbox kallas denna metod och updaterar
		// hashmapen
		textAreaMapX.replace(collisionIndex, textareaX);
		textAreaMapY.replace(collisionIndex, textareaY);

		System.out.println("textArea" + collisionIndex + " X : " + textAreaMapX.get(collisionIndex) + " \t" + "y : "
				+ textAreaMapY.get(collisionIndex));
	}

}
