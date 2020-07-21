# mortgages

Endpoints details : <Br>
       1. http://localhost:9991/mortgage/submit <Br>
       2. http://localhost:9991/mortgage/getMortgage
       
       
RequestBody Sample: <br>
{
  "mortgageId": "m2",
  "version": 3,
  "offerId": "o1-3",
  "offerDate": "10/06/2021",
  "CreatedDate": "12/07/2020",
  "offerExpired": false
}

<Br>
       
       
<H1> Step to create Docker Image </H1> <Br>
       
  1. Perfrom <B> gradle clean build </b> command <br>
  2. Get the .jar from  build --> libs --> mortgage-0.0.1-SNAPSHOT.jar<br>
  3. Perfrom the command from workspace location <br>
             docker build -t mortgage-0.0.1-SNAPSHOT <br>
  4. Once the above command run successfully, Your Docker Image will be created. <br>
  5. To verify the Image you can use command <b> docker Image <b> <br> 
  6. After you need to run the image by performing below command <br>
  7. docker run -p 9991:9991 -t mortgage-0.0.1-SNAPSHOT
       
