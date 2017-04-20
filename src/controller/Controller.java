package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class Controller implements Initializable {

@FXML
private Button browse;

@FXML
private TextField filePath;

@FXML
private ComboBox<String> combobox; 

@FXML
private ComboBox<String> combobox2; 

@FXML
private TextArea stringToHash;

@FXML
private Button buttonCalculate;

@FXML
private TextField hashCalculated;

@FXML
private Button buttonCompare;

@FXML
private Label result;

@FXML
private TextField hashToCompare;

@FXML
private TextField hashCalculated2;

@FXML
private TextField hashToCompare2;

@FXML
private Button buttonCalculate2;

@FXML
private Button buttonCompare2;

@FXML
private Button search;

@FXML
private TextArea textArea;

//contain the action to perfomr when a button of the string Hash tab is prressed
public void operationOnString (ActionEvent e)
{
	result.setText("");
	if(e.getSource() == buttonCompare)
	{
		 if (!(hashCalculated.getText().trim().isEmpty())
		    	  && hashCalculated.getText().trim() != null
		    	  && !(hashToCompare.getText().trim().isEmpty())
		    	  && hashToCompare.getText().trim() != null)
		      {
		    	if (hashCalculated.getText().trim().equalsIgnoreCase(hashToCompare.getText().trim()))  
		    	{
		    		result.setText("Both hash Values match.\n");
		    		result.setTextFill(Color.GREEN);
		    	}
		    	else
		    	{
		    		result.setText("Both hash Values do not match.\n");
		    		result.setTextFill(Color.RED);
		    	}
		      }
		      else
		      {
					Alert alert = new Alert(AlertType.ERROR, "Please fill in the two hash values to be compared!", ButtonType.CANCEL);
		    		alert.showAndWait();
		  	  }
	}
	else if(e.getSource() == buttonCalculate)
	{
		String haslAlgorithm = (String)combobox.getSelectionModel().getSelectedItem().toString();
		hashCalculated.setText("");
		try
		{
			if (stringToHash.getText() != null
	    		    && !stringToHash.getText().trim().isEmpty())
	    		{
					if (haslAlgorithm.equalsIgnoreCase("md5"))
					{
						hashCalculated.setText(HashGeneratorUtils.generateMD5(stringToHash.getText()));
					}
					else if  (haslAlgorithm.equalsIgnoreCase("sha-1"))
					{
						hashCalculated.setText(HashGeneratorUtils.generateSHA1(stringToHash.getText()));
					}
					else if  (haslAlgorithm.equalsIgnoreCase("sha-256"))
					{
						hashCalculated.setText(HashGeneratorUtils.generateSHA256(stringToHash.getText()));
					}
					else if  (haslAlgorithm.equalsIgnoreCase("sha-512"))
					{
						hashCalculated.setText(HashGeneratorUtils.generateSHA512(stringToHash.getText()));
					}
	    		}
				else 
		    	{
		    		Alert alert = new Alert(AlertType.WARNING, "Please type in some text to generate Hash Value from it!", ButtonType.CANCEL);
		    		alert.showAndWait();
				}
		}
		catch (HashGenerationException ex) 
		{
			ex.printStackTrace();
		}
	}     

}


public void operationOnFile(ActionEvent e)
{
	if (e.getSource() == buttonCalculate2)
	{
		String haslAlgorithm = (String)combobox2.getSelectionModel().getSelectedItem().toString();
		
		textArea.setText("");
	
		try
		{
			if (filePath.getText() != null
			    && !filePath.getText().trim().isEmpty())
			{
				String file_path = filePath.getText().trim();
				
				File file = new File(file_path);
				
				if (file != null && !file.isDirectory())
				{	
					if (haslAlgorithm.equalsIgnoreCase("md5"))
					{
						hashCalculated2.setText(HashGeneratorUtils.generateMD5(file));
					}
					else if  (haslAlgorithm.equalsIgnoreCase("sha-1"))
					{
						hashCalculated2.setText(HashGeneratorUtils.generateSHA1(file));
					}
					else if  (haslAlgorithm.equalsIgnoreCase("sha-256"))
					{
						hashCalculated2.setText(HashGeneratorUtils.generateSHA256(file));
					}
					else if  (haslAlgorithm.equalsIgnoreCase("sha-512"))
					{
						hashCalculated2.setText(HashGeneratorUtils.generateSHA512(file));
					}
				}
				else 
	    		{    
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please selected a proper file which hash value will be generated!");
					
		    		alert.showAndWait();
				}
			}
			else 
			{
				Alert alert = new Alert(AlertType.WARNING, "Please selected a file whichs hash value will be generated!", ButtonType.CANCEL);
	    		alert.showAndWait();
			}	
		}
		catch (HashGenerationException ex) 
		{
			ex.printStackTrace();
		}
	}
	else if (e.getSource() == buttonCompare2)
	{
		textArea.setText("");
		
	      if (!(hashCalculated2.getText().trim().isEmpty())
	    	  && hashCalculated2.getText().trim() != null
	    	  && !(hashToCompare2.getText().trim().isEmpty())
	    	  && hashToCompare2.getText().trim() != null)
	      {
	    	  if(hashCalculated2.getText().trim().equalsIgnoreCase(hashToCompare2.getText().trim()))
	    	  {
	    		  Alert alert = new Alert(AlertType.CONFIRMATION, "Both hash Values match.\n", ButtonType.CLOSE);
	      		  alert.showAndWait();
	    	  }
	    	  else 
	    	  {
	    		  Alert alert = new Alert(AlertType.INFORMATION, "Both hash Values do not match.\n", ButtonType.CLOSE);
	      		  alert.showAndWait();
	    	  }
	      }
	      else
	      {
	    	  textArea.setText("Please fill in the two hash values to be compared!\n");	    	  
	    	  Alert alert = new Alert(AlertType.WARNING, "Please fill in the two hash values to be compared!", ButtonType.CANCEL);
	  		  alert.showAndWait();
	  	  }
	}
	else if(e.getSource() == search)
	{
		if(hashCalculated2.getText().trim() != null &&
	        	! hashCalculated2.getText().trim().isEmpty()	)
	        {
	        	textArea.setText("");
	        	String hashalgo = (String)(String)combobox2.getSelectionModel().getSelectedItem().toString();
	        	String hash = hashCalculated2.getText().trim().toString() ;
	        	
	        	DatabaseReader readFile = DatabaseReader.getInstance();
	        	try 
	        	{
//	        		readFile.start(hashalgo, hash);
					String [] result = readFile.start(hashalgo, hash);
					if (result != null)
					{
						textArea.setText("Virus name : " +  result[0] + "\n");
						textArea.appendText("MD5 HASH : " +  result[1] + "\n");
						if(result.length > 2)
						{
							textArea.appendText("SHA-1 HASH : " +  result[2] + "\n");
							textArea.appendText("SHA-256 HASH : " +  result[3] + "\n");
						}
						
					}
					else
					{
						Alert alert = new Alert(AlertType.WARNING, "No matching value could ne found in the database in the database!", ButtonType.CANCEL);
			    		  alert.showAndWait();
					}
						
				}
	        	catch (Exception e1) 
	        	{
					e1.printStackTrace();
				}
	        }
	        else
	        {
	        	Alert alert = new Alert(AlertType.WARNING, "Please fill in the hash values which is to be searched in the database!", ButtonType.CANCEL);
	    		  alert.showAndWait();
	        }
	}
	else if (e.getSource() == browse)
	{
		// fetch and copy the path of the file to be deployed in the archive field
		  final FileBrowser fb = FileBrowser.getInstance();
		  filePath.setText(fb.getPath());
	}
}

@Override
public void initialize(URL location, ResourceBundle resources) 
{
	combobox.getItems().removeAll(combobox.getItems());
	combobox.getItems().addAll("MD5", "SHA-1", "SHA-256", "SHA-512");
	combobox.getSelectionModel().select("MD5");
	
	combobox2.getItems().removeAll(combobox2.getItems());
	combobox2.getItems().addAll("MD5", "SHA-1", "SHA-256", "SHA-512");
	combobox2.getSelectionModel().select("MD5");
	
}

//public void updateResult(String[] result)
//{
//	if (result != null)
//	{
//		textArea.setText("Virus name : " +  result[0] + "\n");
//		textArea.appendText("MD5 HASH : " +  result[1] + "\n");
//		textArea.appendText("SHA-1 HASH : " +  result[2] + "\n");
//		textArea.appendText("SHA-256 HASH : " +  result[3] + "\n");
//	}
//	else
//	{
//		Alert alert = new Alert(AlertType.WARNING, "No matching value could ne found in the database in the database!", ButtonType.CANCEL);
//		  alert.showAndWait();
//	}
//	
//}


}
