@Test public void joinArray() throws IOException {
  shouldCompileTo("{{{join this \", \"}}}",new String[]{"6","7","8"},$("join",StringHelpers.join),"6, 7, 8");
}
