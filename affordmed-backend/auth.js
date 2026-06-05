const axios = require("axios");

const getAuthToken = async () => {
  try {

    const response = await axios.post(
      "http://4.224.186.213/evaluation-service/auth",
      {
        email: "jakkalakshmikoumudi@gmail.com",
        name: "jakka lakshmi koumudi",
        rollNo: "23bq1a4728",
        accessCode: "QQdEYy",
        clientID: "9c728523-d7a7-4df9-a5de-5bf3ba2f5689",
        clientSecret: "ZxurJVsgSJnsjUee"
      }
    );

    console.log(response.data);

  } catch (error) {
    console.log(error.response.data);
  }
};

getAuthToken();