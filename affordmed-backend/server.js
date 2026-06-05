const express = require("express");
const dotenv = require("dotenv");
const connectDB = require("./controllers/config/db");
const logger = require("./middleware/logger");
const healthRoutes = require("./routes/healthRoutes");
dotenv.config();
const app = express();
app.use(express.json());

app.use(async (req, res, next) => {
    await logger(
        "backend",
        "info",
        "middleware",
        `${req.method} ${req.url}`
    );
    next();
});
connectDB();

app.use("/", healthRoutes);
const PORT = process.env.PORT || 5000;

app.listen(PORT, () => {

    console.log(`Server running on port ${PORT}`);

});