@Test public void testSquareBracketsInPath() throws RepositoryException {
  List<String> paths=ImmutableList.of("//jcr:content","/jcr:con]ent","/con]ent");
  testPaths(paths);
}
