@Test public void invertedSection() throws IOException {
  assertEquals("hello {{^section}} hello {{var}}! {{/section}}!",compile("hello {{^section}} hello {{var}}! {{/section}}!").text());
}
