@Test public void testMvCreateRestriction() throws RepositoryException {
  Map<String,Value[]> valid=ImmutableMap.of("longs",new Value[]{vf.createValue(100)},REP_NT_NAMES,new Value[]{vf.createValue("nt:base",PropertyType.NAME),vf.createValue("nt:unstructured",PropertyType.NAME)});
  for (  String name : valid.keySet()) {
    provider.createRestriction("/testPath",name,valid.get(name));
  }
}
