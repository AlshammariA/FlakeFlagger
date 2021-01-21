/** 
 * **&#47r/s/t/u/v/w should match r/s/t/u/v/r/s/t/u/v/r/s/t/u/v/w
 */
@Test public void matchAtEnd(){
  EventFilter filter=new GlobbingPathFilter("**/r/s/t/u/v/w");
  ImmutableTree t=tree;
  for (  String name : elements("r/s/t/u/v/r/s/t/u/v/r/s/t/u/v")) {
    t=t.getChild(name);
    assertFalse(filter.includeAdd(name,t.getNodeState()));
    filter=filter.create(name,t.getNodeState(),t.getNodeState());
    assertNotNull(filter);
  }
  t=t.getChild("w");
  assertTrue(filter.includeAdd("w",t.getNodeState()));
  filter=filter.create("w",t.getNodeState(),t.getNodeState());
  assertNotNull(filter);
}
