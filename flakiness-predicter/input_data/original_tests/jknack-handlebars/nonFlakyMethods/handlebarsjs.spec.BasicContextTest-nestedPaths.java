@Test public void nestedPaths() throws IOException {
  shouldCompileTo("Goodbye {{alan/expression}} world!","{alan: {expression: beautiful}}","Goodbye beautiful world!","Nested paths access nested objects");
}
