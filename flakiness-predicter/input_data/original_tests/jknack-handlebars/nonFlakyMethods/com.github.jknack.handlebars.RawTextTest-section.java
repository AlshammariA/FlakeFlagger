@Test public void section() throws IOException {
  assertEquals("hello {{#section}} hello {{/section}}!",compile("hello {{#section}} hello {{/section}}!").text());
}
