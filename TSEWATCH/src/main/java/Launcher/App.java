package Launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;

import Model.AxeDeVeille;
import Model.ListDiffusion;
import file.io.FileManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.Const;

public class App {
	private static ArrayList<AxeDeVeille> listVeille = new ArrayList<AxeDeVeille>();
	private static ArrayList<ListDiffusion> listDiffusion = new ArrayList<ListDiffusion>();
	private static ArrayList<String> listReport = new ArrayList<String>();
	

	public static void main(String[] args) throws Exception {
		init();
		DisplayController.display(args);
	
	}

	
	
	
	public static void init() {
		FileManager.createFolder(null, 1);
		FileManager.createFolder(null, 2);
		FileManager.createFolder(null, 3);
		DisplayController.setFileManager( new FileManager());
		ArrayList<String> allVeille = null;
		ArrayList<String> allDiffusionList = null;
		ArrayList<String> allReport = null;
		
		
		// load all the 3 list .txt file
		// all_axe_list | all_diffusion_list | all_report
		try {
			allVeille = (ArrayList<String>) FileUtils.readLines(new File(Const.FILE_AXELIST),Charsets.ISO_8859_1);
			allDiffusionList = (ArrayList<String>) FileUtils.readLines(new File(Const.FILE_DIFFUSIONLIST),Charsets.ISO_8859_1);
			allReport = (ArrayList<String>) FileUtils.readLines(new File(Const.FILE_REPORTLIST),Charsets.ISO_8859_1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		// Reading all the axe de veille by using their names
		// name <-> folder name 
		//        folder 
		//      /       \
		//  avis.txt    config.txt<=> (mots cles)
		if(allVeille != null )
		for(String veilleName : allVeille) {
			try {
					listVeille.add(DisplayController.getFileManager().readAxe(veilleName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(allDiffusionList!=null)
		for(String diffusionName : allDiffusionList) {
			try {
					listDiffusion.add(DisplayController.getFileManager().readDiffusionList(diffusionName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(allReport != null) {
			for(String reportName : allReport) {
				listReport.add(reportName);
			}
		}
	}
	
	
	public static ObservableList<AxeDeVeille> getAxes(){
		ObservableList<AxeDeVeille> listAxes = FXCollections.observableArrayList();
		for(AxeDeVeille axe : listVeille) {
			listAxes.add(axe);
		}
		return listAxes;
	}
	
	public static ObservableList<String> getAxes4ReportPage(){
		ObservableList<String> listAxes = FXCollections.observableArrayList();
		for(AxeDeVeille axe : listVeille) {
			listAxes.add(axe.getName());
		}
		
		return listAxes;
	}
	
	public static ObservableList<String> getDF(){
		ObservableList<String> listDf = FXCollections.observableArrayList();
		for(ListDiffusion df : listDiffusion) {
			listDf.add(df.getName());
		}
		return listDf;
	}
	
	public static ObservableList<String> gerRP(){
		ObservableList<String> listRP = FXCollections.observableArrayList();
		for(String str : listReport) {
			listRP.add(str);
		}
		return listRP;
	}
	
	
	
	/**
	 * Getters and setters
	 */
	
	public static ArrayList<AxeDeVeille> getListVeille() {
		return listVeille;
	}




	public static void setListVeille(ArrayList<AxeDeVeille> listVeille) {
		App.listVeille = listVeille;
	}




	public static ArrayList<ListDiffusion> getListDiffusion() {
		return listDiffusion;
	}




	public static void setListDiffusion(ArrayList<ListDiffusion> listDiffusion) {
		App.listDiffusion = listDiffusion;
	}




	public static ArrayList<String> getListReport() {
		return listReport;
	}




	public static void setListReport(ArrayList<String> listReport) {
		App.listReport = listReport;
	}



}
