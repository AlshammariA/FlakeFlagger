@Test public void invertedEmptySection() throws IOException {
  assertEquals("hello {{^section}} {{/section}}!",compile("hello {{^section}} {{/section}}!").text());
}
