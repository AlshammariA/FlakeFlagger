@Test public void joinIterable() throws IOException {
  shouldCompileTo("{{{join this \", \"}}}",Arrays.asList("6","7","8"),$("join",StringHelpers.join),"6, 7, 8");
}
