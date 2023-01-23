## Before running
Edit the file /src/main/java/onemrva/exercice/simplecrud/config/ApplicationConfig.java at this specific line :
`public static final String PROJECT_DIRECTORY = "C:\\javadev\\projets\\SimpleCrud\\simpleCrud\\src\\main\\";`
Put there the route from your absolute path to the project folder.

## Eventual bug
If all employees Id are 0 in the frontend, remove the dom from the csv file, to do it you need to select the csv file on intelliji, click on file, file properties and click on remove DOM.