@Test public void testColonInPath() throws RepositoryException {
  List<String> paths=ImmutableList.of("/jcr:con:ent");
  testPaths(paths);
}
