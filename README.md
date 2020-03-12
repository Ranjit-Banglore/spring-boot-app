# spring-io
spring boot application

#http://localhost:8090/greenfield/projects/all
This is to get all data for projects.

Application connects to localdatabase and pull data through APIs.

It also contains jobs that can run periodically based on define times, and populate latest datas.

We have three controllers and corresponding repository that extends JpaRepository<Products,Long>

Job will get the zip file and process xml data and post it to the Products add endpoint. 
This is relatively fast and populate nearly 0.6 million records in less than 10 minutes.

validator is disabled now once it is confirmed we update it correctly.



