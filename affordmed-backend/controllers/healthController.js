const healthCheck = async (req, res) => {

    res.json({
        message: "Health endpoint active"
    });

};

module.exports = { healthCheck };
