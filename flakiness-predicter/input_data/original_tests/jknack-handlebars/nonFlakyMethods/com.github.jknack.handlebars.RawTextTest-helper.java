@Test public void helper() throws IOException {
  assertEquals("hello {{with context arg0 hash=hash0}}!",compile("hello {{with context arg0 hash=hash0}}!").text());
}
