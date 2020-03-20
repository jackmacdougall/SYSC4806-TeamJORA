# SYSC4806-TeamJORA

# Project Description
Make an application that will allow students to evaluate their peers.  An Model.Instructor will set up a list of items to be assessed, with a rubric for each item. Students are part of one and only one group. Students can add themselves to an existing group or create a new one. The Model.Instructor can also create groups and assign existing students to a group. The instructor can also populate group memberships by uploading a file. A student can assess the peers in his/her group as per the rubric. The Model.Instructor can also generate a report which has the average assessment of each student (average of assessments done about (not by) this student) for each item. The report should be downloadable in a CSV file so that the instructor can further process it in a spreadsheet.

# Package Description
  Application: For back-end processes\
  Model: Where the data model and crudrepositories of the application are located\
  Controller: Where the controllers that hook up the front and back ends are located\
  Service: The intermediary between the controllers and the repositories
  
# Setup
    Use this heroku url - https://peerassessmenttool-jora.herokuapp.com/, in order to run the application. Note that it uses a postgresql database fir persistence 
 
# UML Class Diagram
![UML Class Diagram](https://github.com/jackmacdougall/SYSC4806-TeamJORA/blob/master/Docs/UML-%20Milestone%202.png)

# Database Schema
![Database Schema](https://github.com/jackmacdougall/SYSC4806-TeamJORA/blob/master/Docs/4806%20Database%20Schema-Milestone2.png)
