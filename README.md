# Software-Engineering

## To Run this Project via Terminal / Command Line :
- Open the root directory<br>
**Note: Do not Navigate to dist/, stay on the / root directory**
- Type the following command:
java -jar dist/OOMProject.jar
- Press Enter

## ABOUT THE PROJECT
This Project is a GUI enabled Automatic Elevator System, with automatic door opening and closing mechanism which can detect an overload and prompt the passengers accordingly. We have developed a scheduling algorithm for simulating the moving elevator which is based on serving requests such that it is the fastest possible route. There is a mechanism which in case of Power Cut, immediately sends an Email to the Admin requesting Power Backup, and after receiving the Power Backup directs the elevator to the nearest floor based on which direction it was moving earlier.
Also, we have included a new feature of Emergency Requests, which ignores all other requests in case of an emergency ( say , a medical emergency ) and serves this request first, later resuming to the normal elevator functionality. And for this purpose, only verified personnel (eg. Security Guards on each floor ) with valid Emergency IDs are allowed to call an emergency for someone.

## Development Tools
- JDK 15.0.1 (latest)
- Java Swing
- Apache Netbeans 12.1

# Demo :

[Demo Video](https://www.youtube.com/watch?v=MgSAHk1NLWw)

# Presentation :

[Presentation](https://docs.google.com/presentation/d/1HjcjKibOTe0e8UI8xzbZ7puzJu4PIhfAO_eHErjIFLM/edit?usp=sharing)

## APIs and External Libraries Used
- Java Mail API
- Java Audio API
- Java Activation(used with Java Mail)
- JCalender Library (to implement Date Picker for Log Screen)

## System Requirements
- Operating System: any
- JDK 15.0.1 preferred


## UML DIAGRAMS
### Use Case Diagram
![image](https://user-images.githubusercontent.com/74846797/165888806-cccd98c5-2ac4-4e64-9ab1-1b0176d3e78e.png)

### Class Diagram
![image](https://user-images.githubusercontent.com/74846797/165888914-c753cafc-e3b9-41b8-8beb-13f4f7e68d2d.png)

### UseCase Diagram
![image](https://user-images.githubusercontent.com/74846797/165888919-47a05394-6128-4ab6-a6b5-74ce8b30b60b.png)


## PROJECT SIMULATION AND INSTRUCTIONS
When the project is executed, this is the first screen that appears: 
![image](https://user-images.githubusercontent.com/74846797/165888947-edf2bdce-c25b-475b-b378-72f59c7f546a.png)

- First of all, the Admin is required to Configure the setting for the elevator. For this, click on the Configure button. Then the Configure window would open up, where the Admin can set the threshold values for Number of People and Weight.
- Also, Admin has to set a valid Email Id where the email will be sent in the case of Power Cut.
- Further, the Emergency IDs (without which emergency elevator request cannot be called ) can be added or removed in the configure window.
**See the steps below:**<br>

**CONFIGURE SCREEN** <br>
![image](https://user-images.githubusercontent.com/74846797/165888967-99a97e08-6a6a-410e-8738-3e4dc8dae724.png)

- There are validators set on Maximum weight and Mail ID. 
- Mail Id is validated as well:
- Now let’s add some emergency IDs( Their use will be made clear later ), Click on Edit Here. A window would open up.
![image](https://user-images.githubusercontent.com/74846797/165889054-a43c7e99-cb3c-4b79-b009-90afc1d021be.png)


- To add new ID, enter the string and click on +
- To remove an ID, select it and click on -
- Now click on Update, and the information would be updated.<br>
![image](https://user-images.githubusercontent.com/74846797/165889067-b60a456e-314a-4d15-81bd-cbf7098d0884.png)


**INITIATE SCREEN**<br>
Now back in the main screen, Click on Initiate button to initiate the Automatic Elevator.
![image](https://user-images.githubusercontent.com/74846797/165889091-8c02ef33-d35d-43e1-8b22-305a64b7037a.png)


**We cannot initiate elevator before setting Admin’s Mail Id.**<br>
Here, you have two options :<br>
**NORMAL REQUEST TO ELEVATOR**
- Click on Generate Floor Request. You can see in the terminal, a random floor request would be generated. You can generate as many requests as you want, the algorithm will take care of it accordingly. Let us generate three floor requests almost simultaneously and see how its taken care of (the floor requests can be seen in the terminal)<br>
![image](https://user-images.githubusercontent.com/74846797/165889122-d8291cf5-10c0-4b0e-94c7-5a6dd2e39618.png)

![image](https://user-images.githubusercontent.com/74846797/165889111-66ba39ff-7a96-448d-9807-1a92b7ba30d4.png)

- The elevator reaches floor 9 first, now you are prompted with a screen:
![image](https://user-images.githubusercontent.com/74846797/165889133-2387618d-fc4c-427a-bb5d-7211b63f5ab9.png)

- We enter 1 person (person's weight is randomly added ), now the destination floor for this person would also be randomly generated (in this case 0) This floor is also added to our elevator queue and next requests are served similarly Elevator first goes to floor 12 (as it was going up previously), then 0.
- The overall status of Elevator is also updated according to the situation. <br> 
See an example below:
![image](https://user-images.githubusercontent.com/74846797/165889152-7c24b034-cafe-4b9f-aa49-dccb7cac26be.png)

- Now let us set max people to 10 and max weight to 500 (and cause a condition of overload )

Also, while overload, there is a constant alert sound, until you remove a certain number of persons so that it is not overloaded now. The doors will also remain open until then.
**EMERGENCY FLOOR REQUEST**
- This is a new feature. Let’s say there is an emergency, (you can call it by clicking Emergency Floor Request ) .
- This is where those Emergency IDs will be used. To validate an emergency request, you need an ID.
![image](https://user-images.githubusercontent.com/74846797/165889180-62828ae7-af0a-4761-9f47-0ce492acbd4a.png)
 ![image](https://user-images.githubusercontent.com/74846797/165889192-fdd48514-ac75-40d3-b544-3e4c319a3569.png)

- As soon an emergency is called, the elevator ignores the normal requests and first completes the emergency request. Now, to simulate the POWER CUT, there is a Toggle Button named Power Cut, click on it.
- A Power Cut has occurred now, to see how the elevator responds, see the following situation:
- We have added our mail id as Admin mail in configure. There is a request at floor 9 Let us click POWER CUT on its way from floor 5 to floor 6 <br>
![image](https://user-images.githubusercontent.com/74846797/165889394-4f9ad3c4-afa8-47e1-afe3-8d4ce44db39a.png)

- An email is sent at that address:
![image](https://user-images.githubusercontent.com/74846797/165889388-e92228ea-9b76-4f7b-86af-89a4afd1b66a.png)

- When we release the POWER CUT button, the elevator goes to floor 6, rather than 9 because it is the nearest floor as of now and there was a Power Cut.<br>
**LOG SCREEN**<br>
On the main screen, click on the Log Button<br>
![image](https://user-images.githubusercontent.com/74846797/165889401-4674facf-cf65-4552-a76b-024974c1f8e5.png)

You first need to set a valid date:
The Log is now generated:
![image](https://user-images.githubusercontent.com/74846797/165889412-e48401cc-9ed8-4ebb-8300-53215c5e652f.png)

There are validation checks on Date as well:
![image](https://user-images.githubusercontent.com/74846797/165889419-e103f1a4-532d-4112-a866-8a8eac3dff75.png)


## FUTURE SCOPE
Following the new feature of Emergency Requests, we can incorporate a mechanism for ID cards using “Scan and Go” rather than entering IDs for verification every time. Also, once this mechanism is in place, it can further be used to add a new feature in the Elevator System for restricted floors for Staff Personnel only, using their staff ID Cards.
