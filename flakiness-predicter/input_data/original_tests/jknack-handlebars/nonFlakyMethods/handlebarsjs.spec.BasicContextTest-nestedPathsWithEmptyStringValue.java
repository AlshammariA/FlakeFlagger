@Test public void nestedPathsWithEmptyStringValue() throws IOException {
  shouldCompileTo("Goodbye {{alan/expression}} world!","{alan: {expression: ''}}","Goodbye  world!","Nested paths access nested objects with empty string");
}
