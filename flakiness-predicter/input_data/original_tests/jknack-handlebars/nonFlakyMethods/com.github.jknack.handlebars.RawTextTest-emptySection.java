@Test public void emptySection() throws IOException {
  assertEquals("hello {{#section}} {{/section}}!",compile("hello {{#section}} {{/section}}!").text());
}
