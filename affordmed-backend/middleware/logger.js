const axios = require("axios");

const Log = async (stack, level, packageName, message) => {

  try {

    const response = await axios.post(

      "http://4.224.186.213/evaluation-service/logs",

      {
        stack,
        level,
        package: packageName,
        message
      },

      {
        headers: {
          Authorization:
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiYXVkIjoiaHR0cDovLzIwLjI0NC41Ni4xNDQvZXZhbHVhdGlvbi1zZXJ2aWNlIiwiZW1haWwiOiJqYWtrYWxha3NobWlrb3VtdWRpQGdtYWlsLmNvbSIsImV4cCI6MTc4MDY0MDY3MSwiaWF0IjoxNzgwNjM5NzcxLCJpc3MiOiJBZmZvcmQgTWVkaWNhbCBUZWNobm9sb2dpZXMgUHJpdmF0ZSBMaW1pdGVkIiwianRpIjoiNzM1OTlhM2EtNTJlOS00MTgxLTg4NDItMzc5MjcxOWE2MGQ0IiwibG9jYWxlIjoiZW4tSU4iLCJuYW1lIjoiamFra2EgbGFrc2htaSBrb3VtdWRpIiwic3ViIjoiOWM3Mjg1MjMtZDdhNy00ZGY5LWE1ZGUtNWJmM2JhMmY1Njg5In0sImVtYWlsIjoiamFra2FsYWtzaG1pa291bXVkaUBnbWFpbC5jb20iLCJuYW1lIjoiamFra2EgbGFrc2htaSBrb3VtdWRpIiwicm9sbE5vIjoiMjNicTFhNDI4IiwiYWNjZXNzQ29kZSI6IlFRZEVZeSIsImNsaWVudElEIjoiOWM3Mjg1MjMtZDdhNy00ZGY5LWE1ZGUtNWJmM2JhMmY1Njg5IiwiY2xpZW50U2VjcmV0IjoiWnh1ckpWc2dTSm5zalVlZSJ9.QE0bdsbVCEBWvEi6NNzcydUghkPvGdU9pZ48OsKInSk"
        }
      }

    );

    console.log("Log created:", response.data);

  } catch (error) {

    console.log(
      "Logging Error:",
      error.response?.data || error.message
    );

  }

};

module.exports = Log;