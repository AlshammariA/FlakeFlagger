@Test public void var() throws IOException {
  assertEquals("hello {{var}}!",compile("hello {{var}}!").text());
}
