### **KIS – ERPNext**


`docker pull pipech/erpnext-docker-debian:v12-py3-latest` to pull the docker image

`docker run -d - -name KIS -p 81:80 pipech/erpnext-docker-debian:v12-py3-latest` to run the app

`docker exec -it KIS bash` to get inside the container’s shell and to run bench commands

`bench get-app https://github.com/alexdorner/KIS` to get your custom app (kis) (different repository because of frappe structure)

`bench install-app kis` to install the kis

`--> localhost:8180` to try it out
