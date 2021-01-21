/** 
 * An empty path pattern should match no path
 */
@Test public void emptyMatchesNothing(){
  EventFilter rootFilter=new GlobbingPathFilter("");
  NodeState a=tree.getChild("a").getNodeState();
  assertFalse(rootFilter.includeAdd("a",a));
  assertNull(rootFilter.create("a",a,a));
}
