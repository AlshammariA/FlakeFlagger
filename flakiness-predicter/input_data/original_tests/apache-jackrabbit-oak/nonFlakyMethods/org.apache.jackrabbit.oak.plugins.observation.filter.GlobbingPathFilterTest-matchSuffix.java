/** 
 * r/s/t&#47** should match r/s/t and all its descendants
 */
@Test public void matchSuffix(){
  EventFilter filter=new GlobbingPathFilter("r/s/t/**");
  ImmutableTree t=tree;
  for (  String name : elements("r/s")) {
    t=t.getChild(name);
    assertFalse(filter.includeAdd(name,t.getNodeState()));
    filter=filter.create(name,t.getNodeState(),t.getNodeState());
    assertNotNull(filter);
  }
  for (  String name : elements("t/u/v/r/s/t/u/v/r/s/t/u/v/w")) {
    t=t.getChild(name);
    assertTrue(filter.includeAdd(name,t.getNodeState()));
    filter=filter.create(name,t.getNodeState(),t.getNodeState());
    assertNotNull(filter);
  }
}
