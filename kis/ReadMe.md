KIS – ERPNext

•	Installing – 2 options

Own Image:

docker pull alexandradorner/kis
docker run -d - -name kis -p 80:80 alexandradorner/kis
docker exec -it kis bash (to get inside the container’s shell and to run bench commands)

ERPNext + Custom App:

docker pull lukptr/ernext
docker run -d - -name erpnext -p 81:80 lukptr
docker exec -it erpnext bash
bench get-app https://github.com/alexdorner/diplomprojekt-byh
bench install-app kis




