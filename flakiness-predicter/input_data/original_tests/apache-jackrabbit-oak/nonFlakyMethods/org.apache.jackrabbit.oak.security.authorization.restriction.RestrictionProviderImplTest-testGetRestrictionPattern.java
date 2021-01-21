@Test public void testGetRestrictionPattern() throws Exception {
  Map<PropertyState,RestrictionPattern> map=newHashMap();
  map.put(PropertyStates.createProperty(REP_GLOB,"/*/jcr:content"),GlobPattern.create("/testPath","/*/jcr:content"));
  List<String> ntNames=ImmutableList.of(JcrConstants.NT_FOLDER,JcrConstants.NT_LINKEDFILE);
  map.put(PropertyStates.createProperty(REP_NT_NAMES,ntNames,Type.NAMES),new NodeTypePattern(ntNames));
  NodeUtil tree=new NodeUtil(root.getTree("/")).getOrAddTree("testPath",JcrConstants.NT_UNSTRUCTURED);
  Tree restrictions=tree.addChild(REP_RESTRICTIONS,NT_REP_RESTRICTIONS).getTree();
  for (  Map.Entry<PropertyState,RestrictionPattern> entry : map.entrySet()) {
    restrictions.setProperty(entry.getKey());
    RestrictionPattern pattern=provider.getPattern("/testPath",restrictions);
    assertEquals(entry.getValue(),pattern);
    restrictions.removeProperty(entry.getKey().getName());
  }
  for (  Map.Entry<PropertyState,RestrictionPattern> entry : map.entrySet()) {
    restrictions.setProperty(entry.getKey());
  }
  RestrictionPattern pattern=provider.getPattern("/testPath",restrictions);
  assertTrue(pattern instanceof CompositePattern);
}
