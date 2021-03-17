const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = app => {
  app.use(
    "/api",
    createProxyMiddleware({
      target: "http://byh.spengergasse.at:8080",
      changeOrigin: true
    })
  );
};