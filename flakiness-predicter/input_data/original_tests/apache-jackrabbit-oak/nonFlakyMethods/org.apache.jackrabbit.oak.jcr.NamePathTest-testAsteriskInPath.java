@Test public void testAsteriskInPath() throws RepositoryException {
  List<String> paths=ImmutableList.of("/jcr:con*ent","/jcr:*ontent","/jcr:conten*","/con*ent","/*ontent","/conten*");
  testPaths(paths);
}
