# Projet_secu_des_reseaux

The aim of this project is to create a tool that calculates the Hash value (MD5, SHA1, SHA256) of given String or a given file and compares them with other values. This option can be used to control the checksum of downloaded softwares or files from the internet.
An other option of the tool is to use the hash values of the file to search in a database of known maliceous file to check if the file may be infected or not. The virus signature used in this project were found on the internet site virus share ( https://virusshare.com/hashes.4n6 , https://dyrk.org/2016/04/14/virus-de-500-000-signatures-de-virus-a-telecharger/ ) and some were copied from the clamav antivirus database.
In other to extract the viruses signature from the clamav virus file following procedures have been done
- download the daily.cvd and main.cvd file from the following location : http://www.clamwin.com/content/view/58/27/, or use the following command in linux :
wget http://database.clamav.net/main.cvd
wget http://database.clamav.net/daily.cvd

To uncompress the files the sigtool install with clamav can be used. Or if not the header of the file can be stripped of with the following command: e.g. using the main.cvd file

    #dd if=main.cvd of=main.tar.gz bs=512 skip=1 
The tar command can be used to untar the file and view its contain.

    #tar xzvf main.tar.gz
After unpacking the following files with extensions is present in folder: 

    cdb: container metadata
    fp: database of known good files
    hdb: MD5 hashes of known malicious programs
    ldb: matching signatures, icon signatures and PE metadata strings
    mdb: MD5 hashes of PE sections in known malicious programs
    ndb: hexadecimal signatures
    rmd: archive metadata signatures
    zmd: archive metadata signatures
    
In this tool only two file from the clamav antivirus database were used the file main.hdb and the file main.mdb

## Tool Usage

The GUI of this tool offers a pleasant and confortable interface for usage. It is composed of two tanned pane.

- String tabbed pane for string transformation 
The First tabbed pane is for the determination of the Hash (MD5, SHA-1, SHA-256) of a given String (word, or text).
On the Pane you have the possibility to calculate the hash value of a String, to compare the calculated hash value with an other one that you copied or found some where else.

- File tabbed pane for file transformation
The second pane can be used to calculate the hash value of a file. It is also possible to compare the calculated hash value with an other hash value found some where else or to search for the newly calculated value in the database of Virus signature which is integrateg in the tool.
If a possitiv match is found in the database, the name of the virus , the differents hash values (MD5, SHA-1, SHA-256) will be diplayed. 

# BUILD AND START TOOL
In oder to build and start the tool, you hava to install the following component on your computer.
 - java (JDK)
 - Maven (sudo apt-get install maven)
 - Or eclipse to build automatically
 
To Compile the tool clone the git projekt and move to the destination where the project is saved.
then type the command :
    
    # mvn clean install
Once the compilation done, move to the target folder and run the file having the .jar extention.
to run the tool you can type in the command:
    
    # java -jar [name of the tool].jar
for example 

    #  java -jar Hash_Calculator_Comparator-1.0.0-SNAPSHOT

You can copy the .jar file on an other computer (windows for example and run the programm just by double clicking on the jar file).

#### NB: Due to restriction of the size of files hosted on git Hub for a free account, the database of virus (folder ressources of the project) used for the tool have been considarably reduced fo it to be uploaded on git hub.
The files (main.mdb and vx.txt) can be downloaded from the fillowing link and can be replaced with the actual ones in the resource folder before compiling the project
