# Challenge

**Task description:** For given public REST API from Penguin Random House for author search and possible search opportunities (search by firstName and lastName), please list all authors with their unique ids in a system, names and number of titles. In case the author who took contribution is other written resource, the REST API would return more author objects with the same author name and different IDs. List all author IDs with the  corresponding number of titles.

**Additional information:** Create a simple Java application which enables its users to search authors by their first and last name. Search parameters could be provided as program arguments. REST API for the  author  search  is  http://www.penguinrandomhouse.biz/webservices/rest/#authors.  The parameter names for the search are firstName and lastName correspondingly for the author's first name and last name. The Rest API supports both response formats: xml and json - choose one you are familiar with or prefer. Preferred platform to share the code when done is GitHub. To solve the task you can use any library/tool/framework you wish, as long as it results in a java program. Please take into account the rules of clean coding & best practices. 

**Example**: For input parameters: firstName = Dan and  lastName= Brown, application would print: 
* 3446; BROWN, DAN; 65
* 224942; BROWN, DAN; 0
* 2182290; BROWN, DAN; 3

# Solutions

For this problem, I prepared two solutions. The first solution is a simple Java application, where the users can make all consults using the commom console. The second one is a executable jar file, in this way, it is just necessary a double click to open the application.

## First solution

To solve this challenge, it was used Eclipse IDE and the following tutorial will be based on it, but you can also can use your favorite interface, you just need to pay attention on the steps, because their can change.


To run this first solution, you will need to follow the steps below:

1. Open the project using Eclipse IDE
2. Rigth click on the project folder
3. Click on **Run As**
4. Select **Java Application** option
5. Select the  **Principal** option in the Select Java Application window.

Making all the steps above, the application will appear on the eclipse console. With the application running, you can make a consult, for this, you need to write the author first name and press enter and make the same for the author last name. Now it is necessary to wait the get request and some seconds after you will see the results. If you would like to make one more consult, you need to write **Yes** on the console and repeat everything, else, write **No** and the application will close.

### Jar File

It was used you external jar file (org.json), if when you try to run the application and appears an error about JSON dependencies, you will need to add this external jar file. For this, it is just necessary to follow the steps below:

1. Right click on the project folder
2. Click on **Build Path** and select **Configure build path**
3. When java build path window open, click on **Add external Jar**
4. You can find the jar file in the following path: ..\Jar Files. Select the jar file and click on open button
5. To finish the process, click on apply and close button


## Second solution

The second solution will use the same methods presents on the connection class, but differently as the first application, now the user has a graphic interface where it is possible to write the first and last name in a specific box and just click on **Search** button to see all the results on the screen.

To run this application, it is just necessary a double click on the Searcher.jar and automatically the application window will open and you can search the authors just writting the first and last name and clicking on search.

PS: It is possible to run the executable jar file using Eclipse IDE too, for this, you will need to follow the steps present in the **First solution** section, but intead of select **Principal** you will select **Searcher** and the application window will open.

