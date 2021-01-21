@Test public void testCreateInvalidMvRestriction() throws Exception {
  Map<String,Value[]> invalid=ImmutableMap.of("boolean",new Value[]{vf.createValue(true),vf.createValue(false)},"longs",new Value[]{vf.createValue("wrong_type")},REP_NT_NAMES,new Value[]{vf.createValue(true)});
  for (  String name : invalid.keySet()) {
    try {
      provider.createRestriction("/testPath",name,invalid.get(name));
      fail("invalid restriction " + name);
    }
 catch (    AccessControlException e) {
    }
  }
}
