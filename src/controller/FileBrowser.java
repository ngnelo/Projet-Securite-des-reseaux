package controller;

import java.io.File;

import javafx.stage.FileChooser;

/**
 * 
 * @author: theophane
 * 
 */
public final class FileBrowser
{

   private static FileBrowser instance;

   final private FileChooser fileChooser;

   private FileBrowser()
   {
	   fileChooser = new FileChooser();
	   fileChooser.setTitle("Select a file");
	   fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
   }

   public String getPath()
   {
      String filePath ="";
      File selectedFile = fileChooser.showOpenDialog(null);

      if (selectedFile != null) 
      {
    	  filePath = selectedFile.getAbsolutePath();
      }
	  else 
	  {
		  filePath = null;
	  }
      return filePath;
   }

   public static FileBrowser getInstance()
   {
      if(FileBrowser.instance == null)
      {
         FileBrowser.instance = new FileBrowser();
      }
      return instance;
   }
}
