@Test public void testColonInName() throws RepositoryException {
  List<String> names=ImmutableList.of("jcr:con:ent");
  testNames(names);
}
