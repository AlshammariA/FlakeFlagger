@Test public void joinValues() throws IOException {
  shouldCompileTo("{{{join \"6\" 7 n8 \"-\"}}}",$("n8",8),$("join",StringHelpers.join),"6-7-8");
}
