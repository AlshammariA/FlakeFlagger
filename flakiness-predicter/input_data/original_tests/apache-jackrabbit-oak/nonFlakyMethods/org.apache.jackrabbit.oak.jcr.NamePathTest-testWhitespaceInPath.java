@Test public void testWhitespaceInPath() throws Exception {
  List<String> paths=ImmutableList.of("/content ","/ content","/content\t","/\tcontent","/jcr:con\tent","con\tent");
  testPaths(paths);
}
