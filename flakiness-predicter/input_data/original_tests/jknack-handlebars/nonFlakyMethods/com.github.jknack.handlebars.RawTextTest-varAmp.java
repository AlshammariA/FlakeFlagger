@Test public void varAmp() throws IOException {
  assertEquals("hello {{&var}}!",compile("hello {{& var}}!").text());
}
