@Test public void testSlashInName() throws RepositoryException {
  List<String> names=ImmutableList.of("/jcr:content","/content","jcr:con/ent","jc/r:content","con/ent");
  testNames(names);
}
