@Test public void testGetPatternFromRestrictions() throws Exception {
  Map<PropertyState,RestrictionPattern> map=newHashMap();
  map.put(PropertyStates.createProperty(REP_GLOB,"/*/jcr:content"),GlobPattern.create("/testPath","/*/jcr:content"));
  List<String> ntNames=ImmutableList.of(JcrConstants.NT_FOLDER,JcrConstants.NT_LINKEDFILE);
  map.put(PropertyStates.createProperty(REP_NT_NAMES,ntNames,Type.NAMES),new NodeTypePattern(ntNames));
  List<String> prefixes=ImmutableList.of("rep","jcr");
  map.put(PropertyStates.createProperty(REP_PREFIXES,prefixes,Type.STRINGS),new PrefixPattern(prefixes));
  NodeUtil tree=new NodeUtil(root.getTree("/")).getOrAddTree("testPath",JcrConstants.NT_UNSTRUCTURED);
  Tree restrictions=tree.addChild(REP_RESTRICTIONS,NT_REP_RESTRICTIONS).getTree();
  for (  Map.Entry<PropertyState,RestrictionPattern> entry : map.entrySet()) {
    restrictions.setProperty(entry.getKey());
    RestrictionPattern pattern=provider.getPattern("/testPath",provider.readRestrictions("/testPath",tree.getTree()));
    assertEquals(entry.getValue(),pattern);
    restrictions.removeProperty(entry.getKey().getName());
  }
  for (  Map.Entry<PropertyState,RestrictionPattern> entry : map.entrySet()) {
    restrictions.setProperty(entry.getKey());
  }
  RestrictionPattern pattern=provider.getPattern("/testPath",provider.readRestrictions("/testPath",tree.getTree()));
  assertTrue(pattern instanceof CompositePattern);
}
