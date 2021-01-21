@Test public void lbcore127() throws IOException, JoranException {
  String jarEntry="buzz.xml";
  String jarEntry2="lightyear.xml";
  File jarFile=makeRandomJarFile();
  fillInJarFile(jarFile,jarEntry,jarEntry2);
  URL url1=asURL(jarFile,jarEntry);
  URL url2=asURL(jarFile,jarEntry2);
  URLConnection urlConnection2=url2.openConnection();
  urlConnection2.setUseCaches(false);
  InputStream is=urlConnection2.getInputStream();
  TrivialConfigurator tc=new TrivialConfigurator(rulesMap);
  tc.setContext(context);
  tc.doConfigure(url1);
  is.read();
  is.close();
  assertTrue(jarFile.delete());
  assertFalse(jarFile.exists());
}
