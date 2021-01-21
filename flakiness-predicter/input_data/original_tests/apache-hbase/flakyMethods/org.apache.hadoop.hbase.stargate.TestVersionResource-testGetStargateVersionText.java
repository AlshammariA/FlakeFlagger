public void testGetStargateVersionText() throws IOException {
  Response response=client.get("/version",MIMETYPE_PLAIN);
  assertTrue(response.getCode() == 200);
  String body=Bytes.toString(response.getBody());
  assertTrue(body.length() > 0);
  assertTrue(body.contains(RESTServlet.VERSION_STRING));
  assertTrue(body.contains(System.getProperty("java.vm.vendor")));
  assertTrue(body.contains(System.getProperty("java.version")));
  assertTrue(body.contains(System.getProperty("java.vm.version")));
  assertTrue(body.contains(System.getProperty("os.name")));
  assertTrue(body.contains(System.getProperty("os.version")));
  assertTrue(body.contains(System.getProperty("os.arch")));
  assertTrue(body.contains(ServletContainer.class.getPackage().getImplementationVersion()));
}
