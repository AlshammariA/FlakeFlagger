@Test public void testAsteriskInName() throws RepositoryException {
  List<String> names=ImmutableList.of("jcr:con*ent","jcr:*ontent","jcr:conten*","con*ent","*ontent","conten*");
  testNames(names);
}
