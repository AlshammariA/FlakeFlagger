@Test public void testWhitespaceInName() throws Exception {
  List<String> names=ImmutableList.of("jcr:content ","content "," content","jcr:content\t","content\t","\tcontent","con\tent");
  testNames(names);
}
