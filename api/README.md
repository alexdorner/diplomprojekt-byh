# Getting Started with Spring Boot App

## Import the API 
Import in IntelliJ or SpringToolSuit 
## Run the API
Run Application to start the hole project
## Try it
go to the browser and type the URL from the controller (written in the controller classes)
## Available Scripts

In the project directory, you can run:

### `mvn compile`

compiles the app 

### `mvn compile exec:java -Dexec.mainClass="byh.api.Application"`

Runs the app in the development mode.\
Open [http://localhost:8080](http://localhost:8080) to view it in the browser.

### `mvn test`

Launches the test runner in the interactive watch mode.\

## Configfile (byh.properties)

Needed for sending SMS and Email:

app.mail={Email-Adress}
app.mailServer={Email-Server}
app.mailPort={Email-Server Port}
app.mailUser={Email-Username}
app.mailPw={Email-Password}

app.smsSender={Telephonnumber: +12513194777}
app.smsAccountSID={Twilio-AccountSID}
app.smsAuthToken={Twilio-AuthToken}

Create two environment entries: 

SPRING_CONFIG_NAME = application,byh
SPRING_CONFIG_LOCATION = file:c:/byh/
