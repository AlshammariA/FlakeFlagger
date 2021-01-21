@Test public void testCreateRestriction() throws Exception {
  Map<String,Value> valid=ImmutableMap.of("boolean",vf.createValue(true),"longs",vf.createValue(10),REP_GLOB,vf.createValue("*"));
  for (  String name : valid.keySet()) {
    provider.createRestriction("/testPath",name,valid.get(name));
  }
}
