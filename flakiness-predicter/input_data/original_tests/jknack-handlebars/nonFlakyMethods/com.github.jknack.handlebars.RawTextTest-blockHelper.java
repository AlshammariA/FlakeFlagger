@Test public void blockHelper() throws IOException {
  assertEquals("hello {{#with context arg0 hash=hash0}}hah{{/with}}!",compile("hello {{#with context arg0 hash=hash0}}hah{{/with}}!").text());
}
