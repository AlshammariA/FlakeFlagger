@Test public void noEmptyStringMustacheBlock() throws IOException {
  shouldCompileTo("{{#nonempty}}truthy{{/nonempty}}",$("nonempty","xyz"),"truthy");
}
