@Test public void testSquareBracketsInName() throws RepositoryException {
  List<String> names=ImmutableList.of("jcr:content[1]","content[1]","jcr:conten[t]","conten[t]","jcr:con[]ent","jcr[]:content","con[]ent","jcr:con[t]ent","jc[t]r:content","con[t]ent","jcr:con]ent","jc]r:content","con]ent","jcr:con[ent","jc[r:content","con[ent");
  testNames(names);
}
