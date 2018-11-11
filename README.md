# backend

To start the backend (including db):

`$ docker-compose up`

Notes:

Command to run mongo container:

`$ docker run -d -p 27017:27017 -v ~/data:/data/db --name mongo mongo`
