const axios = require("axios");

const register = async () => {
    try {

        const response = await axios.post(
            "http://4.224.186.213/evaluation-service/register",
            {
                email: "jakkalakshmikoumudi@gmail.com",
                name: "Jakka Lakshmi Koumudi",
                mobileNo: "9948542994",
                githubUsername: "jakkalakshmikoumudi",
                rollNo: "23BQ1A428",
                accessCode: "QQdEYy"
            }
        );

        console.log(response.data);

    } catch (error) {
        console.log(error.response?.data || error.message);
    }
};

register();