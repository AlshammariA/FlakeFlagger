/** 
 * **&#47r/s/t/u/v should match r/s/t/u/v and r/s/t/u/v/r/s/t/u/v and r/s/t/u/v/r/s/t/u/v/r/s/t/u/v
 */
@Test public void multipleMatches(){
  EventFilter filter=new GlobbingPathFilter("**/r/s/t/u/v");
  ImmutableTree t=tree;
  for (int c=0; c < 2; c++) {
    for (    String name : elements("r/s/t/u")) {
      t=t.getChild(name);
      assertFalse(filter.includeAdd(name,t.getNodeState()));
      filter=filter.create(name,t.getNodeState(),t.getNodeState());
      assertNotNull(filter);
    }
    t=t.getChild("v");
    assertTrue(filter.includeAdd("v",t.getNodeState()));
    filter=filter.create("v",t.getNodeState(),t.getNodeState());
    assertNotNull(filter);
  }
}
