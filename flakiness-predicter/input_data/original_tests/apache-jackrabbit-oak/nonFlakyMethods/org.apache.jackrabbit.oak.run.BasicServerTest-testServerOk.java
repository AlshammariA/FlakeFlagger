@Test public void testServerOk() throws Exception {
  URL server=new URL(SERVER_URL);
  HttpURLConnection conn=(HttpURLConnection)server.openConnection();
  conn.setRequestProperty("Authorization","Basic " + Base64.encode("admin:admin"));
  assertEquals(200,conn.getResponseCode());
}
