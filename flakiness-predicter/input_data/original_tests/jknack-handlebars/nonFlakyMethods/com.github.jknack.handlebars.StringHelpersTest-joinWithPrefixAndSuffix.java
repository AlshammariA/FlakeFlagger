@Test public void joinWithPrefixAndSuffix() throws IOException {
  shouldCompileTo("{{{join this \", \" prefix='<' suffix='>'}}}",Arrays.asList("6","7","8"),$("join",StringHelpers.join),"<6, 7, 8>");
}
