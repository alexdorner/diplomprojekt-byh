### **KIS – ERPNext**


`docker pull lukptr/erpnext7` to pull the docker image

`docker run -d --name KIS  -p 80:80 lukptr/erpnext7` to run the app

`docker exec -it KIS bash` to get inside the container’s shell and to run bench commands

`bench get-app https://github.com/alexdorner/KIS` to get your custom app (kis) (different repository because of frappe structure)

`bench install-app kis` to install the kis

`--> localhost:80` to try it out

** Requests you can try: **
http://localhost/api/resource/Medical%20Department
http://localhost/api/resource/Patient
http://localhost/api/resource/Practitioner
http://localhost/api/resource/Appointment Type
http://localhost/api/resource/Patient Appointment

...
