@Test public void plainText() throws IOException {
  assertEquals("Plain Text!",compile("Plain Text!").text());
}
