@Test public void testSlashInPath() throws RepositoryException {
  List<String> paths=ImmutableList.of("//jcr:content","//content");
  testPaths(paths);
}
