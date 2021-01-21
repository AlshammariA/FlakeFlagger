@Test public void testCreateInvalidRestriction() throws Exception {
  Map<String,Value> invalid=ImmutableMap.of("boolean",vf.createValue("wrong_type"),REP_GLOB,vf.createValue(true));
  for (  String name : invalid.keySet()) {
    try {
      provider.createRestriction("/testPath",name,invalid.get(name));
      fail("invalid restriction " + name);
    }
 catch (    AccessControlException e) {
    }
  }
}
