/** 
 * ** should match every path
 */
@Test public void all(){
  EventFilter filter=new GlobbingPathFilter(STAR_STAR);
  ImmutableTree t=tree;
  for (  String name : elements("a/b/c/d")) {
    t=t.getChild(name);
    assertTrue(filter.includeAdd(name,t.getNodeState()));
    filter=filter.create(name,t.getNodeState(),t.getNodeState());
    assertNotNull(filter);
  }
}
