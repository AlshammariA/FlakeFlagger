@Test public void joinIterator() throws IOException {
  shouldCompileTo("{{{join this \", \"}}}",Arrays.asList("6","7","8").iterator(),$("join",StringHelpers.join),"6, 7, 8");
}
