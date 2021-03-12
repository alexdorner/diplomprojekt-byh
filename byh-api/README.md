# Diplomprojekt-BYH
# Starten der API
Code byh-api runterladen und mit IntelliJ, STS, Eclipse,..., öffnen

Code ausführen --> Applikation läuft auf localhost:8080

# Testen
Beim Pfad "Diplomprojekt-BYH\byh-api\src\main\java\byh.api\controller" eine gewünschte  Controllerclass auswählen

Pfad der überhalb der Klasse definiert ist (@RequestMapping(path="")) + Pfad der überhalb der einzelnen Methoden definiert ist (@GetMapping("")) im Browser eingeben: bsp. localhost:8080/api/appointment/GetAll

# Controller
Organization --> Medical Departments (HNO usw.)
Device --> Service Unit (MRT, CT, usw.)
AppointmentController --> Gibt die Termine zurück
--> Abfragereihenfolge
PatientController --> ist nur Post & Delete
# Filtern von Appointments
URL --> /api/appointment/GetAll die Parameter mitgeben, nach denen gefiltert werden soll (Können auhc null sein oder gar nicht verwendet werden, dann wird aber nicht gefilter)
beispiel --> /api/appointment/GetAll?idOrganization=Urology&idDevice=MRT&datum=2021-02-18 --> wichtig, die Parameter müssen genau so heißen
(und auch das Datum in dem Format, weil im KIS ist es als String gespeichert, also muss ich es leider auch als String geben)

# Getting Started with TAN-Service

In the project directory, you can run:

### `mvn compile`

compiles the app 

### `mvn compile exec:java -Dexec.mainClass="byh.api.Application"`

Runs the app in the development mode.\
Open [http://localhost:8080](http://localhost:8080) to view it in the browser.

### `mvn test`

Launches the test runner in the interactive watch mode.\

## Configfile 

Needed for sending SMS and Email:

The name of the config file can be freely chosen, but must have the extension ".properties".
The directory where the config file is located can also be freely selected.

So that the BYH API knows where the config file is located and what it is called, 
two system environment variables must be defined in the operating system.

In the example, the config file is called "byh.properties" and is located in the directory "c:\byh". 

SPRING_CONFIG_NAME = application,byh
SPRING_CONFIG_LOCATION = file:c:/byh/

## Configfile content 

To send an email use your own Email-Account
To send a SMS create your own Twilio Account (https://www.twilio.com/) 

app.mail={Email-Adress}
app.mailServer={Email-Server}
app.mailPort={Email-Server Port}
app.mailUser={Email-Username}
app.mailPw={Email-Password}

app.smsSender={Sender Telephonnumber example: +12513194777}
app.smsAccountSID={Twilio-AccountSID}
app.smsAuthToken={Twilio-AuthToken}

## Email test
You can test sending Email in the browser, with the following link:
    http://localhost:8080/api/sendMail?to={your Email-Adress}

## SMS test 
You can test sending SMS in the browser, with the following link:
	http://localhost:8080/api/sendSms?to={your Telephonnumber}

## TAN-Service test
You can test the TAN-Service in the browser, with the following link: 
	http://localhost:8080/api/getTan