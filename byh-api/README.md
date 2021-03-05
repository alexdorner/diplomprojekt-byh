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

